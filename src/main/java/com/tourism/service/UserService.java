package com.tourism.service;

import com.tourism.entity.User;
import com.tourism.mapper.UserMapper;
import com.tourism.util.wxtool.WXTool;
import com.tourism.util.wxtool.dto.WxCodeResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {

	private UserMapper userMapper;
	private WXTool wxTool;

	@Autowired
	public UserService(UserMapper userMapper, WXTool wxTool) {
		this.userMapper = userMapper;
		this.wxTool = wxTool;
	}

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Transactional
	public User getUserByUserId(int userId){
		return userMapper.selectByPrimaryKey(userId);
	}

	@Transactional
	public List<User> getUsers(int limit){
		return IntStream.range(1, limit).boxed()
				.map(userId -> userMapper.selectByPrimaryKey(userId))
				.collect(Collectors.toList());
	}

	public User createUserByCode(String code) {
		WxCodeResultDto openId = wxTool.getUserOpenIdAndSessionKeyByCode(code);
		return userMapper.selectByOpenId(openId);
	}
}
