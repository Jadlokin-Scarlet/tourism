package com.tourism.mapper;

import com.tourism.entity.deal.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

	List<Car> selectByCarShopId(Integer carShopId);
}