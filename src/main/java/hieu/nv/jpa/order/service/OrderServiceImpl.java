package hieu.nv.jpa.order.service;

import hieu.nv.jpa.order.entity.Order;
import hieu.nv.jpa.order.projection.TotalPriceProjection;
import hieu.nv.jpa.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public BigDecimal getTotal() {
        LocalDateTime startDate = LocalDateTime.of(2024, 4, 1, 8, 30);
        LocalDateTime endDate = LocalDateTime.of(2024, 4, 10, 17, 45);
        TotalPriceProjection totalPriceProjection = orderRepository.sumTotalPriceBetweenDates(startDate, endDate);
        log.info("Total price between dates: {}", totalPriceProjection.getTotalPrice());
        return totalPriceProjection.getTotalPrice();
    }

    @Override
    public Order createOrder(Order order) {
        order.setCreatedAt(new Date());
        return orderRepository.save(order);
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }
}
