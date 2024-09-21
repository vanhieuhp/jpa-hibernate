package hieu.nv.jpa.order.controller;

import hieu.nv.jpa.order.entity.Order;
import hieu.nv.jpa.order.service.OrderService;
import hieu.nv.jpa.payment.entity.Payment;
import hieu.nv.jpa.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createPayment(@RequestBody Order order) {
        Order newPayment = orderService.createOrder(order);
        return ResponseEntity.ok(newPayment);
    }

    @GetMapping
    public ResponseEntity<Iterable<Order>> getAllPayments() {
        Iterable<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getPaymentById(@PathVariable String id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalAmount() {
        BigDecimal totalAmount = orderService.getTotal();
        return ResponseEntity.ok(totalAmount);
    }
}
