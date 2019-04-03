package com.tourism.service;

import com.tourism.entity.business.Restaurant;
import com.tourism.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantService {

	private RestaurantMapper restaurantMapper;

	@Autowired
	public RestaurantService(RestaurantMapper restaurantMapper) {
		this.restaurantMapper = restaurantMapper;
	}

	public List<Restaurant> getRestaurantServiceHotByPage(Integer page, Integer pageSize, String sortKey) {
		return restaurantMapper.selectByOrderPage(sortKey,page,pageSize);
	}

	public Restaurant getScenicById(Integer restaurantId) {
		return restaurantMapper.selectByPrimaryKey(restaurantId);
	}
}
