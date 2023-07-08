package com.antrevs.model.products;

import com.antrevs.model.base.BaseResponseModel;
import com.antrevs.model.entity.ProductModel;

public class GetProductResponseModel extends BaseResponseModel {

    private ProductModel product;

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
