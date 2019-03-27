package com.tourism.entity.deal;

import com.tourism.entity.Deal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "酒店房间实体类",parent = Deal.class)
@Getter
@Setter
@ToString(callSuper = true)
public class Room extends Deal{

	@ApiModelProperty("酒店id")
	private int hotelId;

}