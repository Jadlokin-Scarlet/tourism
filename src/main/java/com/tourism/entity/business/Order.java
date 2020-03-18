package com.tourism.entity.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tourism.entity.User;
import com.tourism.entity.deal.OrderDetail;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ApiModel(value = "路线订单实体类")
@Getter
@Setter
@ToString
public class Order {
    private Integer id;

    @JsonIgnore
    private Integer userId;

    private User user;

    private List<OrderDetail> orderDetails;

    public Order(){}

    public Order(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
    }
}