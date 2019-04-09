package com.tourism.mapper;

import com.tourism.entity.business.CarShop;
import com.tourism.entity.business.Hotel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarShopMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(CarShop record);

	int insertSelective(CarShop record);

	CarShop selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarShop record);

	int updateByPrimaryKey(CarShop record);

	List<CarShop> selectByKeyAndPage(
			@Param("address") String address,
			@Param("sortKey") String sortKey,
			@Param("currPage")Integer page,
			@Param("pageSize")Integer pageSize);
}
