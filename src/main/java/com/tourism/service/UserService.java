package com.tourism.service;

import com.tourism.entity.User;
import com.tourism.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class UserService {

	private UserMapper userMapper;

	@Autowired
	public UserService(UserMapper userMapper){
		this.userMapper = userMapper;
	}

	private Logger logger = LoggerFactory.getLogger(UserService.class);

//	@Transactional
//	public User login(User user){
//		List<User> users = userMapper.selectByUserSelective(user);
//		assert users.size()<2;
//		if(users.size() == 0){
//			logger.info(user.getUserName()+"   "+user.getUserPassword() + "登陆失败，用户名密码不存在");
//			return null;
//		}
//		return users.get(0);
//	}

//	@Transactional
//	public User getUser(int userId){
//		return userMapper.selectByUserId(userId);
//	}

	@Transactional
	public List<User> getUsers(int limit){
		List<User> userList = IntStream.range(1, limit).boxed()
				.map(userId -> userMapper.selectByPrimaryKey(userId))
				.collect(Collectors.toList());
		return userList;
	}

}
