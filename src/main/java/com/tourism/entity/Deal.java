package com.tourism.entity;

public class Deal {
    private String dealName;
    private Area area;
    private Type type;
    /**
     * demo output :
     * [Deal{
     *      dealName='迪士尼门票',
     *      area=Area{
     *          areaName='上海',
     *          areaIntroduce='上海是一座大都市',
     *          areaFolkCustom='上海的消费很高'
     *          },
     *      type=Type{
     *          typeName='门票'
     *      }
     *  }]
     */

    public String getDealName() {
        return dealName;
    }
    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "dealName='" + dealName + '\'' +
                ", area=" + area +
                ", type=" + type +
                '}';
    }
}