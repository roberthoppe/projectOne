package pl.sda.gda15.project.service;

import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.Order;
import pl.sda.gda15.project.domain.repository.OrderRepository;
import pl.sda.gda15.project.model.OrderPOJO;

import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductsService productsService;
    private final UserService userService;

    public OrderService(OrderRepository orderRepository, ProductsService productsService, UserService userService) {
        this.orderRepository = orderRepository;
        this.productsService = productsService;
        this.userService = userService;

    }
    public Order map(OrderPOJO orderPOJO){
        Order order = new Order(orderPOJO.getOrderId(),null,orderPOJO.getUser());
        order.setProductsList(orderPOJO.getProductsList().stream().map(productsService::map).collect(Collectors.toList()));
        return order;
    }
    public OrderPOJO map(Order order){
        OrderPOJO orderPOJO = new OrderPOJO(order.getOrderId(),null,order.getUser());
        orderPOJO.setProductsList(order.getProductsList().stream().map(productsService::map).collect(Collectors.toList()));
        return orderPOJO;
    }
}
