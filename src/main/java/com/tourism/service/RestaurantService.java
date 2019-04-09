package com.tourism.service;

import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.business.Restaurant;
import com.tourism.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RestaurantService {

	private RestaurantMapper restaurantMapper;

	@Autowired
	public RestaurantService(RestaurantMapper restaurantMapper) {
		this.restaurantMapper = restaurantMapper;
	}

	@Transactional
	public List<Restaurant> getRestaurantsByKey(Integer page, Integer pageSize, String sortKey) {
		return restaurantMapper.selectByOrderPage(sortKey,page,pageSize);
	}
	@Transactional
	public Restaurant getRestaurantById(Integer restaurantId) {
		return restaurantMapper.selectByPrimaryKey(restaurantId);
	}
	@Transactional
	public Restaurant createOrUpdateRestaurant(Restaurant restaurant) {
		if(restaurant.getId() == 0){
			restaurantMapper.insertSelective(restaurant);
		}else {
			restaurantMapper.updateByPrimaryKeySelective(restaurant);
		}
		return getRestaurantById(restaurant.getId());
	}
	@Transactional
	public Integer deleteScenic(Integer restaurantId) {
		Restaurant restaurant = getRestaurantById(restaurantId);
		restaurant.setClose(true);
		restaurantMapper.updateByPrimaryKeySelective(restaurant);
		return null;
	}
}
