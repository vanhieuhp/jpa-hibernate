package hieu.nv.jpa.product.repository;

import hieu.nv.jpa.product.entity.Product;
import hieu.nv.jpa.product.entity.ProductId;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, ProductId> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Product> findByIdLocked(ProductId id);
}
