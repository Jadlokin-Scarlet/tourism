package com.tourism.entity.deal;

import com.tourism.entity.Deal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel("票实体类")
@Getter@Setter@ToString(callSuper = true)
public class Ticket extends Deal {

	@ApiModelProperty("所属景区id")
	private Integer scenicId;

}
