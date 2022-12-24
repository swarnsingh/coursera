package com.swarn.assignment.adapter;

/**
 * @author Swarn Singh.
 */
public class ProductAdapter implements Product {

    Y y = new Y();

    @Override
    public ProductDetails getProductDetails() {
        ProductInfo productInfo = y.getProduct();
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(productInfo.getId());
        productDetails.setProductName(productInfo.getName());
        productDetails.setModelName(productInfo.getModelName());
        productDetails.setManufactureDate(productInfo.getManufactureDate());
        return productDetails;
    }
}
