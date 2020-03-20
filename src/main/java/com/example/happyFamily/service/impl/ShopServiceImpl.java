package com.example.happyFamily.service.impl;

import com.example.happyFamily.enums.ProductEnum;
import com.example.happyFamily.repository.ProductRepository;
import com.example.happyFamily.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Long getStockByName(String productName) {
        ProductEnum productEnum = ProductEnum.getByName(productName.trim().toLowerCase());
        if (Objects.isNull(productEnum)) {
            throw new IllegalArgumentException("no matching product name, please check product name");
        }
        return repository.getProductAmount(productEnum.getName());
    }

    @Override
    public Long buyProduct(String productName, Long amount) {
        ProductEnum productEnum = ProductEnum.getByName(productName.trim().toLowerCase());
        if (Objects.isNull(productEnum)) {
            throw new IllegalArgumentException("no matching product name, please check product name");
        }
        return repository.buyProduct(productEnum.getName(), amount);
    }

    @Override
    public Long replenishProduct(String productName, Long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("can not replenish negative amount, please check amount");
        }
        ProductEnum productEnum = ProductEnum.getByName(productName.trim().toLowerCase());
        if (Objects.isNull(productEnum)) {
            throw new IllegalArgumentException("no matching product name, please check product name");
        }
        return repository.replenish(productEnum.getName(), amount);
    }

    @Override
    public void setProductAmount(String productName, Long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("can not replenish negative amount, please check amount");
        }
        ProductEnum productEnum = ProductEnum.getByName(productName.trim().toLowerCase());
        if (Objects.isNull(productEnum)) {
            throw new IllegalArgumentException("no matching product name, please check product name");
        }
        repository.setProductAmount(productEnum.getName(), amount);
    }
}
