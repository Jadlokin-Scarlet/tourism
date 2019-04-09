package com.tourism.api;

import com.tourism.api.business.HotelController;
import com.tourism.entity.User;
import com.tourism.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

//@Api("userApi")
@RestController
@RequestMapping("/api/user")
@Validated
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
	@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "int",paramType = "path")
	public ResponseEntity<User> getUserByPhone(@PathVariable Integer userId){
		LoggerFactory.getLogger(HotelController.class).warn(userId.toString());
		return ResponseEntity.ok(userService.getUserByUserId(userId));
	}

	@PutMapping("/userCode")
	@ApiOperation("用userCode更新用户信息")
	@ApiImplicitParam(name = "code",value = "用户code",required = true,dataType = "int",paramType = "body")
	public ResponseEntity<User> updateUserByCode(@RequestBody@NotBlank(message = "code不得为空") String code){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@PostMapping("/userCode")
	@ApiOperation("存入用户openID和sessionKey通过code")
	@ApiImplicitParam(name = "code",value = "用户code",required = true,dataType = "int",paramType = "body")
	public ResponseEntity<User> createUserByCode(@RequestBody@NotNull String code){
		return ResponseEntity.ok(userService.createUserByCode(code));
//		System.out.println(code);
//		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
//		User user = new User();
//		user.setId(123);
//		return ResponseEntity.ok(user);
	}

}
