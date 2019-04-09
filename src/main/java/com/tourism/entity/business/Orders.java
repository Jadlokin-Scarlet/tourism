package com.tourism.entity.business;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
@ApiModel("订单实体类")
public class Orders {
    @ApiModelProperty("订单id")
    private int id;

    @ApiModelProperty("购买者id")
    private int userId;
    @ApiModelProperty("购买的商品的商家类别")
    private String businessType;
    @ApiModelProperty("购买的商品id")
    private int businessId;

    @ApiModelProperty("订单创建时间")
    private Date createTime;
    @ApiModelProperty("订单最后更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "订单状态",example = "待付款,待使用,已完成,已取消")
    private String payStat;

    @ApiModelProperty("总价")
    private Double totalPrice;
    @ApiModelProperty("实付")
    private Double actualPay;
    @ApiModelProperty("数量")
    private int number;
    @ApiModelProperty("支付方式")
    private String payType;

    @ApiModelProperty("几星评价")
    private Double star;

}