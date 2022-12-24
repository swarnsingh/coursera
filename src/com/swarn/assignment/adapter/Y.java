package com.swarn.assignment.adapter;

import java.util.Date;

/**
 * @author Swarn Singh.
 */
public class Y {

    public ProductInfo getProduct() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(1);
        productInfo.setModelName("HP Pavilion");
        productInfo.setManufactureDate(new Date());
        productInfo.setName("Hp Pavilion Dv6");
        return productInfo;
    }
}
