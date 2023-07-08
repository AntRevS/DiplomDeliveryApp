package com.antrevs.model.orders;

import com.antrevs.model.base.BaseResponseModel;
import com.antrevs.model.entity.OrderModel;

import java.util.List;

public class GetOrdersResponseModel extends BaseResponseModel {

    private List<OrderModel> orders;

    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}
