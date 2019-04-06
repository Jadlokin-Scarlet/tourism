package com.tourism.entity;

import com.tourism.util.MyUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

@ApiModel("商家(酒店卖房间,景区卖门票,车店借车,餐馆卖吃的)实体类")
@Getter
@Setter
@ToString
public class Business {

	@ApiModelProperty(value = "id",example = "0")
	private int id;

	@ApiModelProperty("类别")
	private String type = MyUtil.getEnd(this.getClass().getName().split("\\.")).toLowerCase();

	@ApiModelProperty("名字")
	private String name;
	@ApiModelProperty("简介")
	private String briefIntroduce;
	@ApiModelProperty("商家电话号码")
	private String phone;
	@ApiModelProperty("封面uri")
	private String imgUrl;

	@ApiModelProperty("地址")
	private String address;
	@ApiModelProperty(value = "评分",example = "0")
	private Double score;

	@ApiModelProperty(hidden = true,example = "false")
	private boolean isClose;
}
