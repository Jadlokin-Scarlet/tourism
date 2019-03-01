package com.tourism.entity;

import java.util.Date;

public class Order {
    private Date orderCreateTime;
    private User user;

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }
    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCreateTime=" + orderCreateTime +
                ", user=" + user +
                '}';
    }

}
