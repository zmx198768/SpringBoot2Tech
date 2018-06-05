package com.zengmx.springboot2.datajpa.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
* @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date Fri Jun 01 10:31:42 CST 2018
 */
@Entity(name = "fds_people")
@ApiModel("执法人员表")
public class FdsPeople  implements Serializable {
  private static final long serialVersionUID =  3830697790461041166L;

  @Id
  @GeneratedValue(generator = "sys-uuid")
  @GenericGenerator(name = "sys-uuid", strategy = "uuid")
  private String unid;

  @ApiModelProperty("执法人员姓名")
  @Column(name="name")
  private String name;

  @Column(name="deptunid")
  private String deptunid;

  @Column(name="deptname")
  private String deptname;

  @Column(name="deptseqence")
  private String deptseqence;

  @Column(name="telephone")
  private String telephone;

  @Column(name="sex")
  private String sex;

  @Column(name="birthday")
  private String birthday;

  @Column(name="useable")
  private String useable;

  @Column(name="sortid")
  private Long sortid;

  @Column(name="createtime")
  private String createtime;

  @Column(name="remark")
  private String remark;

  @Column(name="executorid")
  private String executorid;

  @Column(name="type")
  private String type;

  @Column(name="area")
  private String area;

  @Column(name="credential")
  private String credential;

  @Column(name="agency")
  private String agency;

  @Column(name="timestamp")
  private String timestamp;

  @Column(name="flag")
  private String flag;

  @Column(name="sdate")
  private String sdate;

  @Column(name="edate")
  private String edate;

  @Column(name="applyfrom")
  private String applyfrom;

  @Column(name="country")
  private String country;

  @Column(name="city")
  private String city;

  @Column(name="role")
  private String role;

  @Column(name="partment")
  private String partment;

  @Column(name="position")
  private String position;

  @Column(name="areacode")
  private String areacode;



  public String getUnid() {
    return this.unid;
  }

  public void setUnid(String unid) {
    this.unid = unid;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDeptunid() {
    return this.deptunid;
  }

  public void setDeptunid(String deptunid) {
    this.deptunid = deptunid;
  }

  public String getDeptname() {
    return this.deptname;
  }

  public void setDeptname(String deptname) {
    this.deptname = deptname;
  }

  public String getDeptseqence() {
    return this.deptseqence;
  }

  public void setDeptseqence(String deptseqence) {
    this.deptseqence = deptseqence;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getBirthday() {
    return this.birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getUseable() {
    return this.useable;
  }

  public void setUseable(String useable) {
    this.useable = useable;
  }

  public Long getSortid() {
    return this.sortid;
  }

  public void setSortid(Long sortid) {
    this.sortid = sortid;
  }

  public String getCreatetime() {
    return this.createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getExecutorid() {
    return this.executorid;
  }

  public void setExecutorid(String executorid) {
    this.executorid = executorid;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getArea() {
    return this.area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getCredential() {
    return this.credential;
  }

  public void setCredential(String credential) {
    this.credential = credential;
  }

  public String getAgency() {
    return this.agency;
  }

  public void setAgency(String agency) {
    this.agency = agency;
  }

  public String getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getFlag() {
    return this.flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getSdate() {
    return this.sdate;
  }

  public void setSdate(String sdate) {
    this.sdate = sdate;
  }

  public String getEdate() {
    return this.edate;
  }

  public void setEdate(String edate) {
    this.edate = edate;
  }

  public String getApplyfrom() {
    return this.applyfrom;
  }

  public void setApplyfrom(String applyfrom) {
    this.applyfrom = applyfrom;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPartment() {
    return this.partment;
  }

  public void setPartment(String partment) {
    this.partment = partment;
  }

  public String getPosition() {
    return this.position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getAreacode() {
    return this.areacode;
  }

  public void setAreacode(String areacode) {
    this.areacode = areacode;
  }
}
