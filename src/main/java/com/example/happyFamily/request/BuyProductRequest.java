package com.example.happyFamily.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BuyProductRequest implements Serializable {

    @NotBlank(message = "product name can not be blank")
    private String product;

    @NotNull
    @Min(value = 1, message = "amount can not be less than 1")
    private Long amount;

    public BuyProductRequest() {
    }

    public BuyProductRequest(@NotBlank(message = "product name can not be blank") String product,
                             @NotNull @Min(value = 1, message = "amount can not be less than 1") Long amount) {
        this.product = product;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public Long getAmount() {
        return amount;
    }
}
