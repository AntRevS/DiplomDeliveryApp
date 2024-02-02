package com.antrevs.api.privateservice.products.mapper;

import com.antrevs.api.domain.entity.Product;
import com.antrevs.api.mapper.BaseMapper;
import com.antrevs.model.entity.ProductModel;

public class ProductMapper implements BaseMapper<Product, ProductModel> {

    @Override
    public ProductModel map(Product product) {
        ProductModel model = new ProductModel();
        model.setId(product.getId());
        model.setName(product.getName());
        model.setPrice(product.getPrice());
        model.setImageUrl(product.getImageUrl());
        return model;
    }
}
