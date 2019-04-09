package com.tourism.service;

import com.tourism.entity.business.CarShop;
import com.tourism.entity.business.CarShop;
import com.tourism.mapper.CarShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarShopService {
	
	CarShopMapper carShopMapper;

	@Autowired
	public CarShopService(CarShopMapper carShopMapper) {
		this.carShopMapper = carShopMapper;
	}
	@Transactional
	public List<CarShop> getCarShopByKey(Integer page, Integer pageSize, String address, String sortKey) {
		return carShopMapper.selectByKeyAndPage(address,sortKey,page,pageSize);
	}

	@Transactional
	public CarShop getCarShopById(Integer carShopId) {
		return carShopMapper.selectByPrimaryKey(carShopId);
	}

	@Transactional
	public CarShop createOrUpdateCarShop(CarShop carShop) {
		if(carShop.getId() == 0){
			carShopMapper.insertSelective(carShop);
		}else {
			carShopMapper.updateByPrimaryKeySelective(carShop);
		}
		return carShopMapper.selectByPrimaryKey(carShop.getId());
	}
	@Transactional
	public Integer deleteScenic(Integer scenicId) {
		CarShop carShop = carShopMapper.selectByPrimaryKey(scenicId);
		if(carShop == null){
			return 1;
		}
		carShop.setClose(true);
		carShopMapper.updateByPrimaryKeySelective(carShop);
		return 0;
	}
}
