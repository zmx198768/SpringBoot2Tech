package com.zengmx.springboot2.jpa.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/5/10  14:29
 */
@Entity(name = "t_customer")
@ApiModel("用户信息")
public class Customer implements Serializable {
    private static final long serialVersionUID = -7432859108661956208L;

    @Id
    @GeneratedValue(generator = "sys-uuid")
    @GenericGenerator(name = "sys-uuid", strategy = "uuid")
    @ApiModelProperty(value = "用户唯一主键", position = 0)
    /**
     * 1、使用uuid策略生成bean主键
     * 2、apimodelproperty若没有指定position，则为无序；未指定position优先；同一position值无序
     */
    private String unid;

    @NotNull
    @Size(min = 2, max = 32, message = "用户名称长度必须在2-32之间")
    @ApiModelProperty(value = "用户名", position = 1)
    @Column
    private String username;

    @ApiModelProperty(value = "用户昵称", position = 2)
    private String nickname;

    @ApiModelProperty(value = "出生日期", position = 3)
    private String birthday;

    @Column(name = "create_time",insertable = false,updatable = false)
    @ApiModelProperty(value = "注册时间", position = 4)
    private Date createTime;
    @Column(name = "update_time",insertable = false,updatable = false)
    @ApiModelProperty(value = "最后更新时间", position = 5)
    private Date updateTime;

    @ApiModelProperty(value = "是否启用", position = 6)
    private Boolean enable;

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
