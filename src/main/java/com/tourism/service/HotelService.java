package com.tourism.service;

import com.tourism.entity.business.Hotel;
import com.tourism.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

	private HotelMapper hotelMapper;

	@Autowired
	public HotelService(HotelMapper hotelMapper) {
		this.hotelMapper = hotelMapper;
	}

	public List<Hotel> getHotelsByKey(Integer page, Integer pageSize, String fuzzyKey, Integer moneyMax, Integer moneyMin, Integer leverMax, Integer leverMin) {
		return hotelMapper.selectBySelectiveAndPage(fuzzyKey,leverMin,leverMax,moneyMin,moneyMax,page,pageSize);
	}

	public Hotel getHotelById(Integer hotelId){
		return hotelMapper.selectByPrimaryKey(hotelId);
	}

}
