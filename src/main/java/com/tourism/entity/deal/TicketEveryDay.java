package com.tourism.entity.deal;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class TicketEveryDay {

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty("日期")
	private Date useTime;

	@ApiModelProperty(value = "单价",example = "999999999")
	private Integer price;

	@ApiModelProperty(value = "余量",example = "0")
	private Integer balance;

}
