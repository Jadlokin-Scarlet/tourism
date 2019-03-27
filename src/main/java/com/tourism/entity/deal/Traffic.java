package com.tourism.entity.deal;

import com.tourism.entity.Deal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "交通实体类",parent = Deal.class)
public class Traffic extends Deal {

	@ApiModelProperty("交通类型")
	private String type;

	@ApiModelProperty("开始时间")
	private Date startTime;
	@ApiModelProperty("结束时间")
	private Date endTime;
	@ApiModelProperty("开始地点")
	private String startAddress;
	@ApiModelProperty("结束地点")
	private String endAddress;

}
