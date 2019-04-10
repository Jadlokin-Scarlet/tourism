package com.tourism.service;

import com.tourism.entity.business.CarShop;
import com.tourism.entity.deal.Car;
import com.tourism.mapper.CarMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarService {

	private CarMapper carMapper;

	@Autowired
	public CarService(CarMapper carMapper) {
		this.carMapper = carMapper;
	}
	@Transactional
	public List<Car> getAllCarByCarShopId(Integer carShopId){
		return carMapper.selectByCarShopId(carShopId);
	}
	@Transactional
	public List<Car> createOrUpdateCar(Integer carShopId,List<Car> cars) {
		cars.forEach(car-> {
			car.setUpdateTime(new Date());
			car.setCreateTime(null);
			if (car.getId() == 0) {
				carMapper.insertSelective(car);
			} else {
				carMapper.updateByPrimaryKeySelective(car);
			}
		});
		return getAllCarByCarShopId(carShopId);
	}
	@Transactional
	public Integer deleteCarById(Integer carId) {
		return 1-carMapper.deleteByPrimaryKey(carId);
	}
}
