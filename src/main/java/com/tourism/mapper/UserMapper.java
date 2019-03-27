package com.tourism.mapper;

import com.tourism.entity.User;
import com.tourism.util.wxtool.dto.WxCodeResultDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByOpenId(WxCodeResultDto openId);

}