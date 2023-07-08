package com.antrevs.api.privateservice.products.mapper;

import com.antrevs.api.domain.entity.Category;
import com.antrevs.api.domain.entity.Product;
import com.antrevs.api.mapper.BaseMapper;
import com.antrevs.model.entity.CategoryModel;
import com.antrevs.model.entity.ProductModel;

import java.util.stream.Collectors;

public class CategoryMapper implements BaseMapper<Category, CategoryModel> {

    private final ProductMapper productMapper;

    public CategoryMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public CategoryModel map(Category category) {
        CategoryModel model = new CategoryModel();
        model.setId(category.getId());
        model.setName(category.getName());
        model.setProducts(category.getProducts().stream().map(productMapper::map).collect(Collectors.toList()));
        return model;
    }
}
