package com.zengmx.springboot2.datajpa.bean;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
* @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date Fri Jun 01 11:57:04 CST 2018
 */
@Entity(name = "t_customer")
public class Customer  implements Serializable {
  private static final long serialVersionUID =  7381700286707878057L;

  @Id
  @GeneratedValue(generator = "sys-uuid")
  @GenericGenerator(name = "sys-uuid", strategy = "uuid")
  private String unid;

  @Column(name="username")
  private String username;

  @Column(name="nickname")
  private String nickname;

  @Column(name="create_time")
  private Date createTime;

  @Column(name="update_time")
  private Date updateTime;

  @Column(name="birthday")
  private String birthday;

  @Column(name="enable")
  private Long enable;



  public String getUnid() {
    return this.unid;
  }

  public void setUnid(String unid) {
    this.unid = unid;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNickname() {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getBirthday() {
    return this.birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public Long getEnable() {
    return this.enable;
  }

  public void setEnable(Long enable) {
    this.enable = enable;
  }
}
