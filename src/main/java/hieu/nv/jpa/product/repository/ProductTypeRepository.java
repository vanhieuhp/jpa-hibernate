package hieu.nv.jpa.product.repository;

import hieu.nv.jpa.product.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, String> {
}