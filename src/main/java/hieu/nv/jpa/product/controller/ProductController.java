package hieu.nv.jpa.product.controller;

import hieu.nv.jpa.product.dto.ProductRequest;
import hieu.nv.jpa.product.entity.Product;
import hieu.nv.jpa.product.entity.ProductId;
import hieu.nv.jpa.product.entity.ProductType;
import hieu.nv.jpa.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
		Product product = productService.createProduct(productRequest);
		return ResponseEntity.ok(product);
	}

	@GetMapping("/id")
	public ResponseEntity<Product> getProductById( ProductId id) {
		Optional<Product> product = productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@PutMapping("/id")
	public ResponseEntity<Product> updateProduct(@PathVariable ProductId id, @RequestBody ProductRequest productRequest) {
		Product product = productService.updateProduct(id, productRequest);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/id")
	public ResponseEntity<Void> deleteProduct(@PathVariable ProductId id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/types")
	public ResponseEntity<ProductType> createProductType(@RequestBody ProductType productType) {
		ProductType product = productService.createProductType(productType);
		return ResponseEntity.ok(product);
	}

	@GetMapping("/types/{id}")
	public ResponseEntity<ProductType> getProductTypeById(@PathVariable String id) {
		Optional<ProductType> productType = productService.getProductTypeById(id);
		return productType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/types/{id}")
	public ResponseEntity<ProductType> updateProductType(@PathVariable String id, @RequestBody ProductType productType) {
		ProductType product = productService.updateProductType(id, productType);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

}
