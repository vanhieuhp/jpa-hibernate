package hieu.nv.jpa.order.service;

import hieu.nv.jpa.order.entity.Order;

import java.math.BigDecimal;

public interface OrderService {
    BigDecimal getTotal();

    Order createOrder(Order order);

    Iterable<Order> getAllOrders();

    Order getOrderById(String id);
}
