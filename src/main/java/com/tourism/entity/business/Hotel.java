package com.tourism.entity.business;

import com.tourism.entity.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "酒店旅馆实体类",parent = Business.class)
@Getter
@Setter
@ToString(callSuper = true)
public class Hotel extends Business {

	@ApiModelProperty("品牌")
	private String brand;

	@ApiModelProperty(value = "酒店星级",example = "0")
	private int lever;

	@ApiModelProperty(value = "价格下限",example = "0")
	private int moneyMin;

}

