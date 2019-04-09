package com.tourism.entity.business;

import com.tourism.entity.Business;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "租车店实体类",parent = Business.class)
@Getter
@Setter
@ToString(callSuper = true)
public class CarShop extends Business {



}
