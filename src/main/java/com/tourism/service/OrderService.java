package com.tourism.service;

import com.tourism.entity.Deal;
import com.tourism.entity.Order;
import com.tourism.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {

	private OrderMapper orderMapper;

	private TripService tripService;
	private UserService userService;
	@Autowired
	public OrderService(OrderMapper orderMapper, TripService tripService, UserService userService) {
		this.orderMapper = orderMapper;
		this.tripService = tripService;
		this.userService = userService;
	}

	public List<Order> getAllOrderByKey(String dealName, String dealType, String deliverType, String deliverState, Date startDate, Date endDate, String userName, String phone, String ticketBusiness, Integer page, Integer pageSize) {
		List<Order> orders = orderMapper.selectAllByKey(deliverType,deliverState,startDate,endDate,userName,phone,ticketBusiness);
		orders.forEach(tripDetail -> {
			tripDetail.setBusiness(tripService.getBusiness(tripDetail.getBusinessType(),tripDetail.getBusinessId()));
			tripDetail.setUser(userService.getUserByUserId(tripDetail.getUserId()));
			if(tripDetail.getDealId() != 0) {
				tripDetail.setDeal(tripService.getDeal(tripDetail.getBusinessType(), tripDetail.getDealId()));
			}else {
				tripDetail.setDeal(new Deal());
			}
		});
		log.warn(orders.toString());
		orders.forEach(order -> System.out.println(dealName + "  "+order.getBusiness().getName()+"  "+dealName.contains(order.getBusiness().getName()) +"   " +dealName.contains(order.getDeal().getName())));
		return orders.stream()
				.filter(order -> order.getBusiness().getName().contains(dealName) || (order.getDeal().getName() != null && order.getDeal().getName().contains(dealName)))
				.filter(order -> order.getBusiness().getType().contains(dealType) || (order.getDeal().getType() != null && order.getDeal().getType().contains(dealType)))
				.skip(pageSize*page -pageSize)
				.limit(pageSize)
				.collect(Collectors.toList());
	}
}
