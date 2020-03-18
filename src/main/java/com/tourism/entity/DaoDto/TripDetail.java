package com.tourism.entity.DaoDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.tourism.entity.Business;
import com.tourism.service.HotelService;
import com.tourism.service.RestaurantService;
import com.tourism.service.ScenicService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@ApiModel(value = "酒店旅馆实体类",parent = Business.class)
@Getter
@Setter
@ToString(callSuper = true)
public class TripDetail {

//    public interface BaseDto {}
//    public interface TripDto extends BaseDto {}
//    public interface OrderDto extends BaseDto {}

//	@JsonView(Trip.BaseDto.class)
	@ApiModelProperty(example = "0")
	private Integer id;

//	@JsonView(Trip.BaseDto.class)
	@ApiModelProperty("行程id")
	private Integer tripId;

//	@JsonView(Trip.BaseDto.class)
	@ApiModelProperty(value = "商家类型",example = "hotel,scenic,restaurant")
	private String businessType;

//	@JsonView(Trip.BaseDto.class)
	@ApiModelProperty("商家id")
	private Integer businessId;

//	@JsonView(Trip.BaseDto.class)
//	@ApiModelProperty("商品id")
	@JsonIgnore
	private Integer dealId;

//	@JsonView(Trip.BaseDto.class)
	@ApiModelProperty("开始使用时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date useTime;

//	@JsonView(Trip.TripDto.class)
	@ApiModelProperty("介绍")
	private String recommendCause;

//	@JsonView(Trip.BaseDto.class)
	@ApiModelProperty(hidden = true,value = "商家对象")
	private Business business;
//
////	@JsonView(Trip.OrderDto.class)
//	@ApiModelProperty(value = "状态",example = "待付款,待使用,已完成,已取消")
//	private String state;
//
//	public String getState(){
//		String state = "待付款";
//		if(isPay()){
//			if(getUseTime().after(new Date())){
//				state = "待付款";
//			}else {
//				state = "已取消";
//			}
//		}else {
//			if(getUseTime().after(new Date())){
//				state = "待使用";
//			}else {
//				state = "已完成";
//			}
//		}
//		return state;
//	}

//	public Business getBusiness(){
//		return getBusiness(getBusinessType(),getBusinessId());
//	}

//	@JsonIgnore
//	private HotelService hotelService;
//	@JsonIgnore
//	private ScenicService scenicService;
//	@JsonIgnore
//	private RestaurantService restaurantService;
//
//	@Autowired
//	public void setHotelService(HotelService hotelService){
//		this.hotelService = hotelService;
//	}
//
//	@Autowired
//	public void setScenicService(ScenicService scenicService) {
//		this.scenicService = scenicService;
//	}
//
//	@Autowired
//	public void setRestaurantService(RestaurantService restaurantService) {
//		this.restaurantService = restaurantService;
//	}
//
//	private Business getBusiness(String businessType, Integer businessId){
//		Business business = null;
//		switch (businessType) {
//			case "scenic":
//				business = scenicService.getScenicById(businessId);
//				break;
//			case "hotel":
//				business = hotelService.getHotelById(businessId);
//				break;
//			case "restaurant":
//				business = restaurantService.getRestaurantById(businessId);
//				break;
//		}
//		return business;
//	}

}