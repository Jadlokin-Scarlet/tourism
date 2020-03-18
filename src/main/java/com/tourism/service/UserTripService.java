package com.tourism.service;

import com.tourism.entity.Business;
import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.DaoDto.TripDetail;
import com.tourism.entity.business.Order;
import com.tourism.entity.deal.OrderDetail;
import com.tourism.mapper.OrderDetailMapper;
import com.tourism.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserTripService {

	private OrderMapper orderMapper;
	private OrderDetailMapper orderDetailMapper;

	private TripService tripService;
	private OrderService orderService;
	private UserService userService;

	public UserTripService(OrderMapper orderMapper, OrderDetailMapper orderDetailMapper, TripService tripService, OrderService orderService, UserService userService) {
		this.orderMapper = orderMapper;
		this.orderDetailMapper = orderDetailMapper;
		this.tripService = tripService;
		this.orderService = orderService;
		this.userService = userService;
	}

	public List<Order> getTripByKey(Integer page, Integer pageSize, Integer userId) {
		return orderService.getAllByUserId(userId).stream()
				.skip(pageSize*page -pageSize)
				.limit(pageSize)
				.collect(Collectors.toList());
	}

	public Order getUserTrip(Integer userId) {
		List<Order> orders = orderService.getAllByUserId(userId).stream()
				.filter(order -> order.getOrderDetails().stream().
						anyMatch(orderDetail -> orderDetail.getUseTime().after(new Date())))
				.collect(Collectors.toList());
		if(orders.size() > 1){
			throw new NullPointerException();
		}else if(orders.size() == 0){
			log.warn(orders.toString());
			return null;
		}
		return orders.get(0);

	}

	public Order changeTripToUserTrip(Integer userId, int tripId, Date useDay) {
		Trip trip = tripService.getTripById(tripId);
		final Date tripStartTime = trip.getTripItems().size()!=0?trip.getTripItems().get(0).getUseTime():new Date();
		final long dDay = useDay.getTime() - (tripStartTime.getTime() - (tripStartTime.getTime() % (1000*60*60*24)));
		Order userOrder = getUserTrip(userId);
		if(userOrder != null){
			deleteUserTrip(userId);
		}
		Order newOrder = new Order(0, userId);
		orderMapper.insertSelective(newOrder);
		trip.getTripItems().forEach(tripDetail -> {
			orderDetailMapper.insertSelective(new OrderDetail(newOrder.getId(),tripDetail.getBusinessId(),tripDetail.getBusinessType(),new Date(tripDetail.getUseTime().getTime() + dDay)));
		});
		return getUserTrip(userId);
	}

	public Integer deleteUserTrip(Integer userId) {
		Order userOrder = getUserTrip(userId);
		if(userOrder != null){
			orderMapper.deleteByPrimaryKey(userOrder.getId());
			userOrder.getOrderDetails().forEach(orderDetail -> {
				orderDetailMapper.deleteByPrimaryKey(orderDetail.getId());
			});
		}
		return 0;
	}

	public Order addTripItemToUserTrip(Integer userId,String businessType, Integer businessId, Integer dealId,Date useTime) {
		Order userOrder = getUserTrip(userId);
		if(userOrder == null){
			userOrder = new Order();
			orderMapper.insertSelective(userOrder);
		}
//		Business business = tripService.getBusiness(businessType, businessId);
		orderDetailMapper.insertSelective(new OrderDetail(userOrder.getId(),businessId,businessType,useTime));
		return getUserTrip(userId);
	}

	public Order deleteItemToUserTrip(Integer userId, Integer orderDetailId) {
		orderDetailMapper.deleteByPrimaryKey(orderDetailId);
		return getUserTrip(userId);
	}
}
