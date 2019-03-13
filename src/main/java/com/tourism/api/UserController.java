package com.tourism.api;

import com.tourism.entity.User;
import com.tourism.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.List;

@Api("userApi")
@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		Assert.notNull(userService,userService.getClass()+"userService in "+this.getClass()+" is null");
		this.userService = userService;
	}

	@GetMapping("")
	@ApiOperation(value = "获取用户数据样例",notes = "只会返回前5个用户")
	public ResponseEntity<List<User>> getUserExample(){
		List<User> users = userService.getUsers(5);
		if(users == null||users.isEmpty()){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{userId}")
	@ApiOperation(value = "根据uid获取用户信息")
	@ApiImplicitParam(paramType = "path",name = "userId",value = "用户id",required = true,dataType = "Integer")
	public ResponseEntity<User> getUserByPhone(@PathVariable Integer userId){
		return ResponseEntity.ok(userService.getUserByUserId(userId));
	}

	@GetMapping("/id/{phone}")
	@ApiOperation("根据手机号获取uid")
	@ApiImplicitParam(paramType = "path",name = "phone",value = "用户手机号",required = true,dataType = "Long")
	public ResponseEntity<User> getUserById(@PathVariable Long phone){
		//TODO
		return null;
	}

}
