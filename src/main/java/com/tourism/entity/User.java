package com.tourism.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("User实体类")
public class User {
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("用户注册时间")
    private Date createTime;
    @ApiModelProperty("用户信息最后更新时间")
    private Date updateTime;

    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("微信openID")
    private String openId;
    @ApiModelProperty("微信SessionKey")
    private String sessionKey;

    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("头像图片地址")
    private String avatarUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}