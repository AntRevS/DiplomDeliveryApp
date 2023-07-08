package com.antrevs.api.privateservice.orders;

import com.antrevs.api.common.ErrorCode;
import com.antrevs.api.common.HttpHeaders;
import com.antrevs.api.domain.entity.Address;
import com.antrevs.api.domain.entity.Order;
import com.antrevs.api.domain.entity.Product;
import com.antrevs.api.domain.entity.User;
import com.antrevs.api.domain.repository.AddressRepository;
import com.antrevs.api.domain.repository.OrderRepository;
import com.antrevs.api.domain.repository.ProductsRepository;
import com.antrevs.api.domain.repository.UserRepository;
import com.antrevs.api.privateservice.orders.mapper.OrderMapper;
import com.antrevs.api.privateservice.products.mapper.ProductMapper;
import com.antrevs.api.privateservice.user.mapper.AddressMapper;
import com.antrevs.model.error.ErrorModel;
import com.antrevs.model.orders.CreateOrderResponseModel;
import com.antrevs.model.orders.GetOrdersResponseModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/private/orders")
public class OrdersController {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final ProductsRepository productsRepository;

    private final AddressRepository addressRepository;

    private final OrderMapper orderMapper;

    @Autowired
    public OrdersController(
            OrderRepository orderRepository,
            UserRepository userRepository,
            ProductsRepository productsRepository,
            AddressRepository addressRepository
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productsRepository = productsRepository;
        this.addressRepository = addressRepository;
        this.orderMapper = new OrderMapper(
                new ProductMapper(),
                new AddressMapper()
        );
    }

    @GetMapping("/all")
    @ResponseBody
    public GetOrdersResponseModel getOrders(
            @RequestHeader(HttpHeaders.SESSION_ID) String sessionId
    ) {
        User user = userRepository.findBySessionId(sessionId);
        List<Order> orders = orderRepository.findByCustomerId(user.getId());
        GetOrdersResponseModel response = new GetOrdersResponseModel();
        if (orders.isEmpty()) {
            ErrorModel error = new ErrorModel();
            error.setErrorCode(ErrorCode.EMPTY_LIST);
            response.setError(error);
        } else {
            response.setOrders(orders.stream().map(orderMapper::map).collect(Collectors.toList()));
        }
        return response;
    }

    @PostMapping("/create")
    @ResponseBody
    public CreateOrderResponseModel createOrder(
            @RequestHeader(HttpHeaders.SESSION_ID) String sessionId,
            @RequestBody CreateOrderRequestBody body
    ) {
        User user = userRepository.findBySessionId(sessionId);
        CreateOrderResponseModel response = new CreateOrderResponseModel();
        if (body.products.isEmpty()) {
            ErrorModel error = new ErrorModel();
            error.setErrorCode(ErrorCode.EMPTY_LIST);
            response.setError(error);
        } else {
            Optional<Address> address = addressRepository.findById(body.getAddress());
            if (address.isPresent()) {
                List<Product> products = productsRepository.findAllById(body.products);
                Order order = Order
                        .builder()
                        .products(products)
                        .customer(user)
                        .dateMillis(new Date().getTime())
                        .address(address.get())
                        .build();
                orderRepository.save(order);
            } else {
                ErrorModel error = new ErrorModel();
                error.setErrorCode(ErrorCode.INVALID_ARGUMENTS);
                response.setError(error);
            }
        }
        return response;
    }

    @Data
    private static class CreateOrderRequestBody {

        private List<Long> products;

        private Long address;
    }
}
