package com.example.happyFamily.repository;

public interface ProductRepository {

    Long getProductAmount(String productName);

    Long buyProduct(String productName, Long amount);

    Long replenish(String productName, Long amount);

    void setProductAmount(String productName, Long amount);

}
