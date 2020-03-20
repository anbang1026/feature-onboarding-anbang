package com.example.happyFamily.controller;

import com.example.happyFamily.service.HusbandService;
import com.example.happyFamily.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/husband"})
public class HusbandController {

    @Autowired
    private HusbandService husbandService;

    /**
     * husband shop milk and eggs
     *
     * @return
     */
    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public BaseResponse shop() {
        return BaseResponse.newSuccessResponse().result(husbandService.shopProducts(1L, 12L)).build();
    }
}
