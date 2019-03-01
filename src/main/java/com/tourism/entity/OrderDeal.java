package com.tourism.entity;

public class OrderDeal {
    private int orderDealNumber;
    private Deal deal;
    private Order order;

    public int getOrderDealNumber() {
        return orderDealNumber;
    }
    public void setOrderDealNumber(int orderDealNumber) {
        this.orderDealNumber = orderDealNumber;
    }

    public Deal getDeal() {
        return deal;
    }
    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDealMapper{" +
                "orderDealNumber=" + orderDealNumber +
                ", deal=" + deal +
                ", order=" + order +
                '}';
    }
}
/**
[OrderDealMapper {
    orderDealNumber = 1,
    deal = Deal {
        dealName = '迪士尼门票', area = Area {
            areaName = '上海',
            areaIntroduce = '上海是一座大都市',
            areaFolkCustom = '上海的消费很高'
        },
        type = Type {
            typeName = '门票'
        }
    },
    order = Order {
        orderCreateTime = Tue Jan 29 17: 30: 53 CST 2019, user = User {
            userName = '黄克凡'
        }
    }
}]
 **/