package com.tourism.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
@ApiModel("订单实体类")
public class Order {
    @ApiModelProperty("订单id")
    private Integer id;

    @ApiModelProperty("购买者id")
    private Integer userId;
    @ApiModelProperty("购买的商品id")
    private Integer dealId;

    @ApiModelProperty("订单创建时间")
    private Date createTime;
    @ApiModelProperty("订单最后更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "订单状态",example = "待付款,待使用,待评价,已完成")
    private String payStat;

    @ApiModelProperty("总价")
    private Double totalPrice;
    @ApiModelProperty("实付")
    private Double actualPay;
    @ApiModelProperty("数量")
    private Integer number;
    @ApiModelProperty("支付方式")
    private String payType;

    @ApiModelProperty("几星评价")
    private Double star;
    @ApiModelProperty("评论")
    private String comment;
    @ApiModelProperty("评论时间")
    private Date commentTime;
    @ApiModelProperty("评论配图地址")
    private List<String> commentImgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
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

    public String getPayStat() {
        return payStat;
    }

    public void setPayStat(String payStat) {
        this.payStat = payStat;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getActualPay() {
        return actualPay;
    }

    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public List<String> getCommentImgUrl() {
        return commentImgUrl;
    }

    public void setCommentImgUrl(List<String> commentImgUrl) {
        this.commentImgUrl = commentImgUrl;
    }
}