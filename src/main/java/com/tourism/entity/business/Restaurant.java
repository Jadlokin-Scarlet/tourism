package com.tourism.entity.business;

import com.tourism.entity.Business;
import com.tourism.entity.Deal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ApiModel(value = "餐馆酒店小吃店实体类",parent = Business.class)
@Getter
@Setter
@ToString(callSuper = true)
public class Restaurant extends Business {

	@ApiModelProperty("店名")
	private String name;

	@ApiModelProperty("开门时间")
	private Date startTime;
	@ApiModelProperty("关门时间")
	private Date endTime;

	@ApiModelProperty("封面图片地址")
	private String imgUrl;

	@ApiModelProperty("美食类型")
	private String type;

	@ApiModelProperty("店面地址")
	private String address;

	@ApiModelProperty("商家电话号码")
	private String phone;

}
