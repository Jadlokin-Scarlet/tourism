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

@ApiModel(value = "餐馆酒店小吃店实体类",parent = Business.class)
@Getter
@Setter
@ToString(callSuper = true)
public class Restaurant extends Business {

	@ApiModelProperty("开门时间")
    @JsonFormat(pattern = "HH:mm:ss")
	private Date noonStartTime;
	@ApiModelProperty("关门时间")
	@JsonFormat(pattern = "HH:mm:ss")
	private Date noonEndTime;
	@ApiModelProperty("开门时间")
	@JsonFormat(pattern = "HH:mm:ss")
	private Date nightStartTime;
	@ApiModelProperty("关门时间")
	@JsonFormat(pattern = "HH:mm:ss")
	private Date nightEndTime;
}
