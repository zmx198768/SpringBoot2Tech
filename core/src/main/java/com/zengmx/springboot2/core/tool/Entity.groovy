import com.intellij.database.model.DasTable
import com.intellij.database.model.ObjectKind
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil

import java.sql.Date


/**
 * Title:由数据库生成entity模板，若有注释，默认采用swagger进行注解，对于所有实体类，默认实现序列化（idea使用，打开database panel后，scripted extension→go to script directory，将本entity放入即可）
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018-6-1 09:18:00
 */

packageName = ""
typeMapping = [
        (~/(?i)tinyint|smallint|mediumint/)      : "Integer",
        (~/(?i)int/)                             : "Long",
        (~/(?i)bool|bit/)                        : "Boolean",
        (~/(?i)float|double|decimal|real/)       : "Double",
        (~/(?i)datetime|timestamp|date|time/)    : "Date",
        (~/(?i)blob|binary|bfile|clob|raw|image/): "InputStream",
        (~/(?i)/)                                : "String"
]

FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir ->
  SELECTION.filter { it instanceof DasTable && it.getKind() == ObjectKind.TABLE }.each { generate(it, dir) }
}
/**
 * 创建对应的pojo Java文件
 * @param table
 * @param dir
 * @return
 */
def generate(table, dir) {
  def className = javaName(table.getName(), true)
  def fields = calcFields(table)
  packageName = getPackageName(dir)
  new File(dir, className + ".java").withPrintWriter { out -> generate(out, className, fields, table) }
}

/**
 * 实体类代码生成
 * @param out
 * @param className
 * @param fields
 * @return
 */
def generate(out, className, fields, table) {
  //获取字段类型、获取是否有表注释、是否有字段注释
  Set types = new HashSet()
  def tableApi = false
  if (isNotEmpty(table.comment)) {
    tableApi = true
  }
  def columnApi = false

  fields.each() {
    types.add(it.type)
    if (isNotEmpty(it.comment)) {
      columnApi = true
    }
  }

  out.println "package $packageName"
  out.println ""

  if (tableApi == true) {
    out.println "import io.swagger.annotations.ApiModel;"
  }
  if (tableApi == true) {
    out.println "import io.swagger.annotations.ApiModelProperty;"
  }

  out.println "import org.hibernate.annotations.GenericGenerator;"

  out.println "import javax.persistence.Column;"
  out.println "import javax.persistence.Entity;"
  out.println "import javax.persistence.GeneratedValue;"
  out.println "import javax.persistence.Id;"
  out.println "import java.io.Serializable;"
  if (types.contains("Date")) {
    out.println "import java.util.Date;"
  }
  if (types.contains("InputStream")) {
    out.println "import java.io.InputStream;"
  }

  out.println ""
  out.println "/**"
  out.println " * Title:"
  out.println " * Company:互撸娃大战铁茎肛.avi"
  out.println " *"
  out.println "* @author <a href=\"mailto:8574157@qq.com\">zengmx</a>"
  out.println " * @date " + new java.util.Date().toString()
  out.println " */"
  out.println "@Entity(name = \"" + table.getName() + "\")"
  if (isNotEmpty(table.comment)) {
    //此处若发现获取到的注释乱码，但是模板中的中文正常，且setting、db connect都是utf-8时，可以在idea目录中在idea64.exe.vmoptions文件最后添加 -Dfile.encoding=utf8   即可解决
    out.println "@ApiModel(\"" + table.comment + "\")"
  }
  out.println "public class $className  implements Serializable {"
  out.println genSerialID()
  out.println ""
  fields.each() {
    if (it.annos != "") out.println "  ${it.annos}"

    // 输出注释
    if (isNotEmpty(it.comment)) {
      out.println "  @ApiModelProperty(\"" + it.comment + "\")"
    }

    //如果列名为id或者unid，则默认为主键，主键采用uuid策略生成
    if (it.name == 'id' || it.name == 'unid'  ) {
      out.println "  @Id"
      out.println "  @GeneratedValue(generator = \"sys-uuid\")"
      out.println "  @GenericGenerator(name = \"sys-uuid\", strategy = \"uuid\")"
    } else {
      out.println "  @Column(name=\"${it.colName.toLowerCase()}\")"
    }

    out.println "  private ${it.type} ${it.name.replace('_', '')};"
    out.println ""
  }
  out.println ""
  fields.each() {
    out.println ""
    def actionName = "Boolean".equals(it.type.toString()) ? "is" : "get"

    out.println "  public ${it.type} ${actionName}${it.name.capitalize()}() {"
    out.println "    return this.${it.name};"
    out.println "  }"
    out.println ""

    out.println "  public void set${it.name.capitalize()}(${it.type} ${it.name}) {"
    out.println "    this.${it.name} = ${it.name};"
    out.println "  }"
  }
  out.println "}"
}



/**
 * 获取包名称
 * @param dir 实体类所在目录
 * @return
 */
def getPackageName(dir) {
  return dir.toString().replaceAll("/", ".").replaceAll("\\\\", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}

def calcFields(table) {
  DasUtil.getColumns(table).reduce([]) { fields, col ->
    def spec = Case.LOWER.apply(col.getDataType().getSpecification())
    def typeStr = typeMapping.find { p, t -> p.matcher(spec).find() }.value
    fields += [[
                       colName : col.getName(),
                       name    : javaName(col.getName(), false),
                       type    : typeStr,
                       comment : col.getComment(),
                       annos   : ""]]
  }
}

def javaName(str, capitalize) {
  def s = str.split(/[^\p{Alnum}]/).collect { def s = Case.LOWER.apply(it).capitalize() }.join("")
  capitalize ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}

static String genSerialID()
{
  return "  private static final long serialVersionUID =  "+Math.abs(new Random().nextLong())+"L;";
}

def isNotEmpty(content) {
  return content != null && content.toString().trim().length() > 0
}