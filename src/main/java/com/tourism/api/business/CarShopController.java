package com.tourism.api.business;

import com.tourism.service.CarShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(value = "CarShopApi",produces = "application/json")
@RequestMapping(value = "api/carShop",produces = "application/json")
@Validated
@Slf4j
public class CarShopController {

	private CarShopService carShopService;

	@Autowired
	public CarShopController(CarShopService carShopService) {
		this.carShopService = carShopService;
	}

	@GetMapping("")
	@ApiOperation("")
	public ResponseEntity<String> getCarShop(){

		return ResponseEntity.ok("");
	}

}
