package com.example.happyFamily.controller;

import com.example.happyFamily.request.BuyProductRequest;
import com.example.happyFamily.request.QueryStockRequest;
import com.example.happyFamily.service.ShopService;
import com.example.happyFamily.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = {"/shop"})
public class ShopController {

    @Autowired
    private ShopService shopService;

    /**
     * query product's stock
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryStock", method = RequestMethod.POST)
    public BaseResponse queryStock(@Valid @RequestBody QueryStockRequest request) {
        return BaseResponse.newSuccessResponse().result(shopService.getStockByName(request.getProduct())).build();
    }

    /**
     * buy certain product
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/buyProduct", method = RequestMethod.POST)
    public BaseResponse buyProduct(@Valid @RequestBody BuyProductRequest request) {
        return BaseResponse.newSuccessResponse().result(shopService.buyProduct(request.getProduct(), request.getAmount())).build();
    }
}
