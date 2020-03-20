package com.example.happyFamily.service;

public interface ShopService {

    Long getStockByName(String productName);

    Long buyProduct(String productName, Long amount);

    Long replenishProduct(String productName, Long amount);

    void setProductAmount(String productName, Long amount);
}
