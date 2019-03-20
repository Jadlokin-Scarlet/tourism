package com.tourism.api;

import com.tourism.entity.Order;
import com.tourism.entity.User;
import com.tourism.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
	@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "Integer",paramType = "path")
	public ResponseEntity<User> getUserByPhone(@PathVariable Integer userId){
		return ResponseEntity.ok(userService.getUserByUserId(userId));
	}

	@GetMapping("/{userId}/calender")
	@ApiOperation("获取用户行程表")
	@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "Integer",paramType = "path")
	public ResponseEntity<List<Order>> getUserCalender(@PathVariable String userId){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}



	@PutMapping("/userCode")
	@ApiOperation("用userCode更新用户信息")
	@ApiImplicitParam(name = "code",value = "用户code",required = true,dataType = "String",paramType = "body")
	public ResponseEntity<User> updateUserByCode(@RequestBody String code){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@PostMapping("/userCode")
	@ApiOperation("存入用户openID和sessionKey通过code")
	@ApiImplicitParam(name = "code",value = "用户code",required = true,dataType = "String",paramType = "body")
	public ResponseEntity<User> createUserByCode(@RequestBody String code){
		return ResponseEntity.ok(userService.createUserByCode(code));
//		System.out.println(code);
//		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
//		User user = new User();
//		user.setId(123);
//		return ResponseEntity.ok(user);
	}

}
