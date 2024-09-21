package hieu.nv.jpa.order.repository;

import hieu.nv.jpa.order.entity.Order;
import hieu.nv.jpa.order.projection.TotalPriceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query("""
        SELECT SUM(o.price) as totalPrice
        FROM Order o
        WHERE o.createdAt BETWEEN :startDate AND :endDate
        """)
    TotalPriceProjection sumTotalPriceBetweenDates(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}