package com.tourism.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ApiModel(value = "商品实体类",description = "作为很多实体类的基类")
@Getter
@Setter
@ToString
public class Deal {
    @ApiModelProperty("商品id")
    private int id;

    @ApiModelProperty("商品上架时间")
    private Date createTime;
    @ApiModelProperty("商品最后更新时间")
    private Date updateTime;

    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("封面uri")
    private String imgUrl;

    @ApiModelProperty("单价")
    private int price;
    @ApiModelProperty("余量")
    private int balance;

}
