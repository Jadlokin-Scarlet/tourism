package com.tourism.service;

import com.tourism.entity.Deal;
import com.tourism.entity.business.Order;
import com.tourism.entity.deal.OrderDetail;
import com.tourism.mapper.OrderDetailMapper;
import com.tourism.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {

	private OrderMapper orderMapper;
	private OrderDetailMapper orderDetailMapper;

	private TripService tripService;
	private UserService userService;

	@Autowired
	public OrderService(OrderMapper orderMapper, OrderDetailMapper orderDetailMapper, TripService tripService, UserService userService) {
		this.orderMapper = orderMapper;
		this.orderDetailMapper = orderDetailMapper;
		this.tripService = tripService;
		this.userService = userService;
	}

	public List<Order> getAllByUserId(Integer userId){
		List<Order> orders = userId == 0? orderMapper.selectAll(): orderMapper.selectAllByUserId(userId);
		orders.forEach(order -> {
			order.setUser(userService.getUserByUserId(order.getUserId()));
			order.setOrderDetails(orderDetailMapper.selectAllByOrderId(order.getId()));
			order.getOrderDetails().forEach(orderDetail -> {
				orderDetail.setBusiness(tripService.getBusiness(orderDetail.getBusinessType(),orderDetail.getBusinessId()));
				orderDetail.setDeal(orderDetail.getDealId() != 0? tripService.getDeal(orderDetail.getBusinessType(),orderDetail.getDealId()):new Deal());
				orderDetail.setUser(order.getUser());
			});
		});
		return orders;
	}

	public List<OrderDetail> getAllOrderByKey(String dealName, String dealType, String deliverType, String deliverState, Date startDate, Date endDate, String userName, Integer userId, String phone, String ticketBusiness, Integer page, Integer pageSize) {
		List<Order> orders = getAllByUserId(userId);
		log.warn(orders.toString());
		orders.forEach(order -> order.getOrderDetails().forEach(orderDetail -> log.warn(orderDetail.getBusiness().toString())));
		orders.forEach(order -> order.getOrderDetails().forEach(orderDetail -> log.warn(orderDetail.getBusiness().getType() +" " + dealType + ":" + (orderDetail.getBusiness().getType().contains(dealType)?"true":"false"))));
		return orders.stream()
				.filter(order -> userId == 0 || order.getUserId().equals(userId))
				.filter(order -> order.getUser().getNickName().contains(userName))
				.filter(order -> order.getUser().getPhone().contains(phone))
				.flatMap(order -> order.getOrderDetails().stream())
				.filter(orderDetail -> orderDetail.getDeliverType().contains(deliverType))
				.filter(orderDetail -> orderDetail.getDeliverState().contains(deliverState))
				.filter(orderDetail -> orderDetail.getUseTime().after(startDate))
				.filter(orderDetail -> orderDetail.getUseTime().before(endDate))

				.filter(orderDetail -> orderDetail.getBusiness().getName().contains(dealName) || orderDetail.getDeal().getName().contains(dealName))
				.filter(orderDetail -> orderDetail.getBusiness().getType().contains(dealType) || orderDetail.getDeal().getType().contains(dealType))

				.sorted(Comparator.comparing(OrderDetail::getUseTime))
				.skip(pageSize*page -pageSize)
				.limit(pageSize)
				.collect(Collectors.toList());
	}
}
