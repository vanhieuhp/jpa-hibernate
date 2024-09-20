package hieu.nv.jpa.product.service;

import hieu.nv.jpa.product.dto.ProductRequest;
import hieu.nv.jpa.product.entity.Product;
import hieu.nv.jpa.product.entity.ProductId;
import hieu.nv.jpa.product.entity.ProductType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(ProductRequest productRequest);

	@Transactional(readOnly = true)
	Optional<Product> getProductById(ProductId id);

	List<Product> getAllProducts();

    Product updateProduct(ProductId id, ProductRequest productRequest);

	void deleteProduct(ProductId id);

	ProductType createProductType(ProductType productType);

	Optional<ProductType> getProductTypeById(String id);

	ProductType updateProductType(String id, ProductType productType);
}
