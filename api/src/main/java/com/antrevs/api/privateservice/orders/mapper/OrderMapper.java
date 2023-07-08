package com.antrevs.api.privateservice.orders.mapper;

import com.antrevs.api.domain.entity.Order;
import com.antrevs.api.mapper.BaseMapper;
import com.antrevs.api.privateservice.products.mapper.ProductMapper;
import com.antrevs.api.privateservice.user.mapper.AddressMapper;
import com.antrevs.model.entity.OrderModel;

import java.util.stream.Collectors;

public class OrderMapper implements BaseMapper<Order, OrderModel> {

    private final ProductMapper productMapper;

    private final AddressMapper addressMapper;

    public OrderMapper(
            ProductMapper productMapper,
            AddressMapper addressMapper
    ) {
        this.productMapper = productMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public OrderModel map(Order order) {
        OrderModel model = new OrderModel();
        model.setId(order.getId());
        model.setProducts(order.getProducts().stream().map(productMapper::map).collect(Collectors.toList()));
        model.setDateMillis(order.getDateMillis());
        model.setAddress(addressMapper.map(order.getAddress()));
        return model;
    }
}
