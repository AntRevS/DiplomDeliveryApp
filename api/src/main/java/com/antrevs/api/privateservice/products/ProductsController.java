package com.antrevs.api.privateservice.products;

import com.antrevs.api.common.ErrorCode;
import com.antrevs.api.domain.entity.Category;
import com.antrevs.api.domain.entity.Product;
import com.antrevs.api.domain.repository.CategoryRepository;
import com.antrevs.api.domain.repository.ProductsRepository;
import com.antrevs.api.privateservice.products.mapper.CategoryMapper;
import com.antrevs.api.privateservice.products.mapper.ProductMapper;
import com.antrevs.model.error.ErrorModel;
import com.antrevs.model.products.GetProductResponseModel;
import com.antrevs.model.products.GetProductsResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/private/products")
public class ProductsController {

    private final CategoryRepository categoryRepository;
    private final ProductsRepository productsRepository;
    private final CategoryMapper categoryMapper;
    private final ProductMapper productMapper;

    @Autowired
    public ProductsController(
            CategoryRepository categoryRepository,
            ProductsRepository productsRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.productsRepository = productsRepository;
        this.productMapper = new ProductMapper();
        this.categoryMapper = new CategoryMapper(productMapper);
    }

    @GetMapping("/test")
    @ResponseBody
    public void test() {
        Product product1 = Product.builder().name("Burger").price(BigDecimal.ONE).build();
        Product product2 = Product.builder().name("Milk shake").price(BigDecimal.ONE).build();

        List<Product> products1 = new ArrayList<>();
        List<Product> products2 = new ArrayList<>();
        products1.add(product1);
        products2.add(product1);
        products2.add(product2);

        Category fastFood = Category.builder().name("Fast food").products(products1).build();
        Category milk = Category.builder().name("Milk products").products(products2).build();


        categoryRepository.save(fastFood);
        categoryRepository.save(milk);
    }

    @GetMapping("/all")
    @ResponseBody
    public GetProductsResponseModel getProducts(
            @RequestParam(required = false, name = "categoryId") Long categoryId
    ) {
        GetProductsResponseModel response = new GetProductsResponseModel();
        List<Category> categories = new ArrayList<>();
        if (categoryId == null) {
            categories = categoryRepository.findAll();
        } else {
            Optional<Category> category = categoryRepository.findById(categoryId);
            if (category.isPresent()) {
                categories.add(category.get());
            }
        }

        if (categories.isEmpty()) {
            ErrorModel error = new ErrorModel();
            error.setErrorCode(ErrorCode.EMPTY_LIST);
            response.setError(error);
        } else {
            response.setCategories(categories.stream().map(categoryMapper::map).collect(Collectors.toList()));
        }

        return response;
    }

    @GetMapping
    @ResponseBody
    public GetProductResponseModel getProduct(
            @RequestParam(name = "productId") Long productId
    ) {
        GetProductResponseModel response = new GetProductResponseModel();
        Optional<Product> product = productsRepository.findById(productId);
        if (product.isPresent()) {
            response.setProduct(productMapper.map(product.get()));
        } else {
            ErrorModel error = new ErrorModel();
            error.setErrorCode(ErrorCode.NOT_EXIST);
            response.setError(error);
        }
        return response;
    }
}
