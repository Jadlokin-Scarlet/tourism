package com.tourism.entity.deal;

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

	private Date useTime;

	private Integer price;

	private Integer balance;

}
