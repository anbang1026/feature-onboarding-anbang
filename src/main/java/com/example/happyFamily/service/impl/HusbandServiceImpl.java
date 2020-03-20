package com.example.happyFamily.service.impl;

import com.example.happyFamily.enums.ProductEnum;
import com.example.happyFamily.service.HusbandService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HusbandServiceImpl implements HusbandService {

    @Override
    public Map<String, Long> shopProducts(Long milk, Long eggs) {
        Map<String, Long> result = new HashMap<>();
        if (milk < 0) {
            throw new IllegalArgumentException("milk amount is less than 0, please input positive number");
        } else if (eggs < 0) {
            throw new IllegalArgumentException("egg amount is less than 0, please input positive number");
        }
        result.put(ProductEnum.MILK.getName(), milk);
        result.put(ProductEnum.EGG.getName(), eggs);
        return result;
    }
}
