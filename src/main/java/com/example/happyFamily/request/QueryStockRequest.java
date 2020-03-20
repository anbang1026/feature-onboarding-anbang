package com.example.happyFamily.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import java.io.Serializable;

public class QueryStockRequest implements Serializable {

    @NotBlank(message = "product name can not be blank")
    private String product;

    public QueryStockRequest() {
    }

    public QueryStockRequest(@NotBlank(message = "product name can not be blank") String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }
}
