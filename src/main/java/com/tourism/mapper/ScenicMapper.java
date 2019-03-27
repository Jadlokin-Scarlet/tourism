package com.tourism.mapper;

import com.tourism.entity.business.Hotel;
import com.tourism.entity.business.Scenic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scenic record);

    int insertSelective(Scenic record);

    Scenic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scenic record);

    int updateByPrimaryKey(Scenic record);

    List<Scenic> selectBySelectiveAndPage(
            @Param("fuzzyKey") String fuzzyKey,
            @Param("currPage")Integer page,
            @Param("pageSize")Integer pageSize);
}