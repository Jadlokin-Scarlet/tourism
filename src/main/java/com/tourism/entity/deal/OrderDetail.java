package com.tourism.entity.deal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.tourism.entity.Business;
import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.Deal;
import com.tourism.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@ApiModel(value = "订单实体类")
@Getter
@Setter
@ToString
public class OrderDetail {
    private Integer id;

    private Integer orderId;

    private User user = new User();

    @JsonIgnore
    private Integer businessId;

    @JsonIgnore
    private String businessType = "";

    private Business business = new Business();

    @JsonIgnore
    private Integer dealId;

    private Deal deal = new Deal();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;// = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2050-01-01 00:00:00",new ParsePosition(0));

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date useTime;// = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2050-01-01 00:00:00",new ParsePosition(0));

    private String deliverType = "";

    private String deliverState = "";

    private double star;

//    @ApiModelProperty(value = "状态",example = "待付款,待使用,已完成,已取消")
//    private String state = "";

    public OrderDetail(){}

    public OrderDetail(Integer orderId, Integer businessId, String businessType, Date useTime) {
        this.orderId = orderId;
        this.businessId = businessId;
        this.businessType = businessType;
        this.useTime = useTime;
    }

//    public String getState(){
//        String state = "待付款";
//        if(payTime.after(new Date())){
//            if(getUseTime().after(new Date())){
//                state = "待付款";
//            }else {
//                state = "已取消";
//            }
//        }else {
//            if(getUseTime().after(new Date())){
//                state = "待使用";
//            }else {
//                state = "已完成";
//            }
//        }
//        return state;
//    }

}