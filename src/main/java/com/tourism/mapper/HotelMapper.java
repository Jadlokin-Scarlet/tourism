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
			@Param("sortKey") String sortKey,
			@Param("leverList") List<Integer> leverList,
			@Param("moneyMin") Integer moneyMin,
			@Param("moneyMax") Integer moneyMax,
			@Param("latitude") Double latitude,
			@Param("longitude") Double longitude,
			@Param("currPage") Integer page,
			@Param("pageSize") Integer pageSize);

//	List<Hotel> selectBySelectiveSortDefaultAndPage(
//			@Param("fuzzyKey") String fuzzyKey,
//			@Param("leverList") List<Integer> leverList,
//			@Param("moneyMin") Integer moneyMin,
//			@Param("moneyMax") Integer moneyMax,
//			@Param("latitude") Double latitude,
//			@Param("longitude") Double longitude,
//			@Param("currPage") Integer page,
//			@Param("pageSize") Integer pageSize);
}