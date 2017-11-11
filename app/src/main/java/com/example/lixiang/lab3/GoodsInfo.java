package com.example.lixiang.lab3;


public class GoodsInfo {
    private String name;
    private String info;
    private String price;
    public GoodsInfo(String name, String info, String price){
        this.name=name;
        this.info=info;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public String getInfo(){
        return info;
    }
    public String getPrice(){
        return price;
    }
}
