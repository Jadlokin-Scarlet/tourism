package com.tourism.entity.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tourism.entity.Business;
import com.tourism.entity.Deal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@ApiModel(value = "景点(门票)实体类",parent = Business.class)
@Getter
@Setter
@ToString(callSuper = true)
public class Scenic extends Business {
	@JsonFormat(pattern = "HH:mm:ss")
	@ApiModelProperty(value = "开门时间")
	private Date startTime;
	@JsonFormat(pattern = "HH:mm:ss")
	@ApiModelProperty("关门时间")
	private Date endTime;

	@ApiModelProperty("价格多少钱起")
	private String moneyMin;

	@ApiModelProperty("几a景区")
	private Integer lever;

	@ApiModelProperty("是否有停车场")
	private boolean hasP;
	@ApiModelProperty("是否有wifi")
	private boolean hasWifi;
	@ApiModelProperty("是否有卫生间")
	private boolean hasWc;

}
