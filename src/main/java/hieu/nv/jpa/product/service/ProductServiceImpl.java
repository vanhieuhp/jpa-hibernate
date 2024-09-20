package hieu.nv.jpa.product.service;

import hieu.nv.jpa.product.dto.ProductRequest;
import hieu.nv.jpa.product.entity.Product;
import hieu.nv.jpa.product.entity.ProductId;
import hieu.nv.jpa.product.entity.ProductType;
import hieu.nv.jpa.product.repository.ProductRepository;
import hieu.nv.jpa.product.repository.ProductTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	private final ProductRepository productRepository;
	private final ProductTypeRepository productTypeRepository;

	@Override
	@Transactional
	public Product createProduct(ProductRequest productRequest) {
		Product product = new Product();
		product.setId(new ProductId(productRequest.getName(), productRequest.getPrice()));
		product.setDescription(productRequest.getDescription());
		return productRepository.save(product);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> getProductById(ProductId id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

    @Transactional
	@Override
	public Product updateProduct(ProductId id, ProductRequest productRequest) {

		Product product = productRepository.findByIdLocked(id).orElseThrow(EntityNotFoundException::new);
		product.getId().setName(productRequest.getName());
		product.getId().setPrice(productRequest.getPrice());
		product.setVersion(product.getVersion() + 1);
//		return productRepository.save(product);
		return product;
	}


	@Override
	public void deleteProduct(ProductId id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		productRepository.delete(product); // Here, the entity is marked for removal and will be deleted from the database at
		// the end of the transaction.
	}

	@Override
	public ProductType createProductType(ProductType productType) {
		return productTypeRepository.save(productType);
	}

	@Override
	public Optional<ProductType> getProductTypeById(String id) {
		return productTypeRepository.findById(id);
	}

	@Override
	@Transactional
	public ProductType updateProductType(String id, ProductType productType) {
		ProductType existingProductType = productTypeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		existingProductType.setName(productType.getName());
		return existingProductType;
	}
}

