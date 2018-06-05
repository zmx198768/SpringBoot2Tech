package com.zengmx.springboot2.datajpa.bean;

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
 * @date Fri Jun 01 11:57:04 CST 2018
 */
@Entity(name = "ucap_dept")
public class UcapDept  implements Serializable {
  private static final long serialVersionUID =  9199790221937054632L;

  @Id
  @Column(name="dept_unid")
  private String deptUnid;

  @Column(name="dept_name_spell")
  private String deptNameSpell;

  @Column(name="dept_name")
  private String deptName;

  @Column(name="dept_leaders")
  private String deptLeaders;

  @Column(name="dept_belongto")
  private String deptBelongto;

  @Column(name="dept_sort")
  private Long deptSort;

  @Column(name="dept_admins")
  private String deptAdmins;

  @Column(name="dept_alias")
  private String deptAlias;

  @Column(name="dept_underdept")
  private String deptUnderdept;

  @Column(name="dept_belong_to_unit")
  private String deptBelongToUnit;

  @Column(name="dept_serial_number")
  private String deptSerialNumber;

  @Column(name="dept_is_enabled")
  private String deptIsEnabled;

  @Column(name="dept_is_business")
  private String deptIsBusiness;

  @Column(name="dept_code")
  private String deptCode;

  @Column(name="dept_ab")
  private String deptAb;



  public String getDeptUnid() {
    return this.deptUnid;
  }

  public void setDeptUnid(String deptUnid) {
    this.deptUnid = deptUnid;
  }

  public String getDeptNameSpell() {
    return this.deptNameSpell;
  }

  public void setDeptNameSpell(String deptNameSpell) {
    this.deptNameSpell = deptNameSpell;
  }

  public String getDeptName() {
    return this.deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public String getDeptLeaders() {
    return this.deptLeaders;
  }

  public void setDeptLeaders(String deptLeaders) {
    this.deptLeaders = deptLeaders;
  }

  public String getDeptBelongto() {
    return this.deptBelongto;
  }

  public void setDeptBelongto(String deptBelongto) {
    this.deptBelongto = deptBelongto;
  }

  public Long getDeptSort() {
    return this.deptSort;
  }

  public void setDeptSort(Long deptSort) {
    this.deptSort = deptSort;
  }

  public String getDeptAdmins() {
    return this.deptAdmins;
  }

  public void setDeptAdmins(String deptAdmins) {
    this.deptAdmins = deptAdmins;
  }

  public String getDeptAlias() {
    return this.deptAlias;
  }

  public void setDeptAlias(String deptAlias) {
    this.deptAlias = deptAlias;
  }

  public String getDeptUnderdept() {
    return this.deptUnderdept;
  }

  public void setDeptUnderdept(String deptUnderdept) {
    this.deptUnderdept = deptUnderdept;
  }

  public String getDeptBelongToUnit() {
    return this.deptBelongToUnit;
  }

  public void setDeptBelongToUnit(String deptBelongToUnit) {
    this.deptBelongToUnit = deptBelongToUnit;
  }

  public String getDeptSerialNumber() {
    return this.deptSerialNumber;
  }

  public void setDeptSerialNumber(String deptSerialNumber) {
    this.deptSerialNumber = deptSerialNumber;
  }

  public String getDeptIsEnabled() {
    return this.deptIsEnabled;
  }

  public void setDeptIsEnabled(String deptIsEnabled) {
    this.deptIsEnabled = deptIsEnabled;
  }

  public String getDeptIsBusiness() {
    return this.deptIsBusiness;
  }

  public void setDeptIsBusiness(String deptIsBusiness) {
    this.deptIsBusiness = deptIsBusiness;
  }

  public String getDeptCode() {
    return this.deptCode;
  }

  public void setDeptCode(String deptCode) {
    this.deptCode = deptCode;
  }

  public String getDeptAb() {
    return this.deptAb;
  }

  public void setDeptAb(String deptAb) {
    this.deptAb = deptAb;
  }
}
