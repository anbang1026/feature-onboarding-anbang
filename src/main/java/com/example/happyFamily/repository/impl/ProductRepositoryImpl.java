package com.example.happyFamily.repository.impl;

import com.example.happyFamily.enums.ProductEnum;
import com.example.happyFamily.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static Map<String, Long> productAmountMap = new ConcurrentHashMap<>();

    static {
        productAmountMap.put(ProductEnum.MILK.getName(), 1000L);
        productAmountMap.put(ProductEnum.EGG.getName(), 2000L);
    }

    @Override
    public Long getProductAmount(String productName) {
        return productAmountMap.getOrDefault(productName, 0L);
    }

    @Override
    public Long buyProduct(String productName, Long amount) {
        Long stock = productAmountMap.getOrDefault(productName, 0L);
        if (Objects.equals(stock, 0L)) {
            return 0L;
        }
        Long result = stock > amount ? amount : stock;
        productAmountMap.put(productName, stock - result);
        return result;
    }

    @Override
    public Long replenish(String productName, Long amount) {
        Long stock = productAmountMap.getOrDefault(productName, 0L);
        productAmountMap.put(productName, stock + amount);
        return productAmountMap.get(productName);
    }

    @Override
    public void setProductAmount(String productName, Long amount) {
        productAmountMap.put(productName, amount);
    }
}
