package com.tourism.service;

import com.tourism.entity.business.Hotel;
import com.tourism.entity.business.Scenic;
import com.tourism.mapper.HotelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class HotelService {

	private HotelMapper hotelMapper;

	@Autowired
	public HotelService(HotelMapper hotelMapper) {
		this.hotelMapper = hotelMapper;
	}

	public List<Hotel> getHotelsByKey(
			Integer page,
			Integer pageSize,
			String fuzzyKey,
			String sortKey,
			Integer moneyMax,
			Integer moneyMin,
			List<Integer> leverList) {
		return hotelMapper.selectBySelectiveAndPage(
				fuzzyKey,
				sortKey,
				leverList,
				moneyMin,
				moneyMax,
				page,
				pageSize);
	}
	@Transactional
	public Hotel getHotelById(Integer hotelId){
		return hotelMapper.selectByPrimaryKey(hotelId);
	}

	@Transactional
	public Hotel createOrUpdateHotel(Hotel hotel) {
//		hotel.setType();
		if(hotel.getId() == 0){
			hotelMapper.insertSelective(hotel);
		}else {
			hotelMapper.updateByPrimaryKeySelective(hotel);
		}
		return hotelMapper.selectByPrimaryKey(hotel.getId());
	}
	@Transactional
	public Integer deleteScenic(Integer scenicId) {
		Hotel hotel = hotelMapper.selectByPrimaryKey(scenicId);
		if(hotel == null){
			return 1;
		}
		hotel.setClose(true);
		hotelMapper.updateByPrimaryKeySelective(hotel);
		return 0;
	}
}
