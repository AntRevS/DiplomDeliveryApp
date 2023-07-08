package com.antrevs.model.products;

import com.antrevs.model.base.BaseResponseModel;
import com.antrevs.model.entity.CategoryModel;

import java.util.List;

public class GetProductsResponseModel extends BaseResponseModel {

    private List<CategoryModel> categories;

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryModel> categories) {
        this.categories = categories;
    }
}
