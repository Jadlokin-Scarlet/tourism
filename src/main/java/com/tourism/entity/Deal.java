package com.tourism.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("商品上架时间")
    private Date createTime = new Date();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("商品最后更新时间")
    private Date updateTime = new Date();

    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty(value = "封面uri",example = "http://10.210.96.229:8081/default.png")
    private String imgUrl = "http://10.210.96.229:8081/default.png";

    @ApiModelProperty(value = "单价",example = "999999999")
    private int price = 999999999;
    @ApiModelProperty(value = "余量",example = "0")
    private int balance = 0;


}
