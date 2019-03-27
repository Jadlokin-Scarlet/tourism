package com.tourism.mapper;

import com.tourism.entity.business.Hotel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    Hotel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKey(Hotel record);

    List<Hotel> selectBySelectiveAndPage(
            @Param("fuzzyKey") String fuzzyKey,
            @Param("leverMin")Integer leverMin,
            @Param("leverMax")Integer leverMax,
            @Param("moneyMin")Integer moneyMin,
            @Param("moneyMax")Integer moneyMax,
            @Param("currPage")Integer page,
            @Param("pageSize")Integer pageSize);
}