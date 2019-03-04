package com.tourism.service;

import com.tourism.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void login() {
		System.out.println(userService.login(new User()));
	}

}