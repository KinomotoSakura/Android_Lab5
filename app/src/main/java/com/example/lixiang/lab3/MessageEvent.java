package com.example.lixiang.lab3;

public class MessageEvent {
    private GoodsInfo goodsInfo;
    public MessageEvent(GoodsInfo shoppingItem){
        this.goodsInfo = shoppingItem;
    }
    public GoodsInfo getGoodsInfo(){
        return goodsInfo;
    }
}
