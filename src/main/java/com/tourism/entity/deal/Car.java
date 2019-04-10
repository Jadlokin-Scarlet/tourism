package com.tourism.entity.deal;

import com.tourism.entity.Deal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "汽车实体类",parent = Deal.class)
@Getter
@Setter
@ToString(callSuper = true)
public class Car extends Deal{

	@ApiModelProperty("租车店id")
	private Integer carShopId;

	@ApiModelProperty("座位数量")
	private Integer seatNumber;

	@ApiModelProperty("是否自动挡")
	private boolean isAutomaticaTransmission;

}
