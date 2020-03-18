package com.tourism.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ApiModel("User实体类")
@Getter
@Setter
@ToString
public class User {
    @ApiModelProperty("用户id")
    private int id;

    @ApiModelProperty("用户注册时间")
    private Date createTime;
    @ApiModelProperty("用户信息最后更新时间")
    private Date updateTime;

    @ApiModelProperty("昵称")
    private String nickName = "";
    @ApiModelProperty("微信openID")
    private String openId = "";
    @ApiModelProperty("微信SessionKey")
    private String sessionKey = "";

    @ApiModelProperty("性别")
    private String sex = "";
    @ApiModelProperty("手机号")
    private String phone = "";
    @ApiModelProperty("头像图片地址")
    private String avatarUrl = "";

}