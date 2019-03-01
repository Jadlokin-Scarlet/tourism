package com.tourism.mapper;

import com.tourism.entity.User;
import org.springframework.stereotype.Repository;
//import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> selectByUserSelective(User user);

    User selectByUserId(int userId);

//    User selectByUser(int id);

}
