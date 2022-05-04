package br.com.meta3group.productservice.services;

import br.com.meta3group.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product createProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product updateProduct(Product product);
    public Product deleteProduct(Product product);
}
