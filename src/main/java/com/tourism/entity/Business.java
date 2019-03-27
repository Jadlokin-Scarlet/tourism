package com.tourism.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel("商家(酒店卖房间,景区卖门票,车店借车,餐馆卖吃的)实体类")
@Getter
@Setter
@ToString
public class Business {

	@ApiModelProperty("id")
	private int id;

	@ApiModelProperty("名字")
	private String name;
	@ApiModelProperty("简介")
	private String briefIntroduce;
	@ApiModelProperty("封面uri")
	private String imgUrl;

	@ApiModelProperty("所属地区")
	private String areaName;
	@ApiModelProperty("评分")
	private Double score;

}
