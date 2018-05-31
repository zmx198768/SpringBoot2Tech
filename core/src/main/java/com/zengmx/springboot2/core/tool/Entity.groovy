package com.zengmx.springboot2.core.tool

import com.intellij.database.model.DasTable
import com.intellij.database.model.ObjectKind
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil

import java.sql.Date

/*
 * Available context bindings:
 *   SELECTION   Iterable<DasObject>
 *   PROJECT     project
 *   FILES       files helper
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

def generate(table, dir) {
  def className = javaName(table.getName(), true)
  def fields = calcFields(table)
  packageName = getPackageName(dir)
  new File(dir, className + ".java").withPrintWriter { out -> generate(out, className, fields, table) }
}

/**
 * 获取包名称
 * @param dir 实体类所在目录
 * @return
 */
def getPackageName(dir) {
  return dir.toString().replaceAll("/", ".").replaceAll("\\\\", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}

/**
 * 实体类代码生成
 * @param out
 * @param className
 * @param fields
 * @return
 */
def generate(out, className, fields, table) {
  Set types = new HashSet()

  fields.each() {
    types.add(it.type)
  }

  out.println "package $packageName"
  out.println ""
    //异常乱码问题导致生成的POJO也乱码，待处理后开放
  //out.println "import io.swagger.annotations.ApiModel;"
  //out.println "import io.swagger.annotations.ApiModelProperty;"
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
    //out.println "@ApiModel(\"" + table.comment + "\")"
  }
  out.println "public class $className  implements Serializable {"
  out.println genSerialID()
  out.println ""
  fields.each() {
    if (it.annos != "") out.println "  ${it.annos}"

    // 输出注释
    if (isNotEmpty(it.comment)) {
      //out.println "@ApiModelProperty(\"" + it.comment + "\")"
    }

    if (it.name == 'id' || it.name == 'unid'  ) {
      out.println "  @Id"
      out.println "  @GeneratedValue(generator = \"sys-uuid\")"
      out.println "  @GenericGenerator(name = \"sys-uuid\", strategy = \"uuid\")"
    } else {
      out.println "  @Column(name=\"${it.colName.toLowerCase()}\")"
    }

    out.println "  private ${it.type} ${it.name.replace('_', '')};"
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