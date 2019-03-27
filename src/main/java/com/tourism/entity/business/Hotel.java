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

	@ApiModelProperty("酒店星级")
	private int lever;

	@ApiModelProperty("价格下限")
	private int moneyMin;

	@ApiModelProperty("价格上限")
	private int moneyMax;

}

