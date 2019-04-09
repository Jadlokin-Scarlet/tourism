package com.tourism.entity.deal;

import com.tourism.entity.Deal;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "汽车实体类",parent = Deal.class)
@Getter
@Setter
@ToString(callSuper = true)
public class Car extends Deal{

	private Integer carShopId;


	private Integer seatNumber;

	private boolean isAutomaticaTransmission;

}
