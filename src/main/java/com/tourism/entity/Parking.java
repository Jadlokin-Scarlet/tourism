package com.tourism.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("停车场实体类")
class Parking {

	@ApiModelProperty("价格xx每小时")
	private Double price;

	@ApiModelProperty("名称")
	private String name;
	@ApiModelProperty("简介")
	private String briefIntroduce;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
}
