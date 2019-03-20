package com.tourism.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "商品实体类",description = "作为很多实体类的基类")
public class Deal {
    @ApiModelProperty("商品id")
    private Integer id;

    @ApiModelProperty("商品上架时间")
    private Date createTime;
    @ApiModelProperty("商品最后更新时间")
    private Date updateTime;

    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("简介")
    private String briefIntroduce;

    @ApiModelProperty("单价")
    private Integer price;
    @ApiModelProperty("余量")
    private Integer balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBriefIntroduce() {
        return briefIntroduce;
    }

    public void setBriefIntroduce(String briefIntroduce) {
        this.briefIntroduce = briefIntroduce;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}