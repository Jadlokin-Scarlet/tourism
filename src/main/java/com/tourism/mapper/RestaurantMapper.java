package com.tourism.mapper;

import com.tourism.entity.business.Restaurant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Restaurant record);

    int insertSelective(Restaurant record);

    Restaurant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Restaurant record);

    int updateByPrimaryKey(Restaurant record);

    List<Restaurant> selectByOrderPage(
            @Param("sortKey") String sortKey,
            @Param("currPage") Integer page,
            @Param("pageSize") Integer pageSize);
}