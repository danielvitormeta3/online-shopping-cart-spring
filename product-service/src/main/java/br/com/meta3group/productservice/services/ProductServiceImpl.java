package br.com.meta3group.productservice.services;

import br.com.meta3group.productservice.models.Product;
import br.com.meta3group.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {

        Product beforeUpdate = getProductById(product.getId());

        if(beforeUpdate == null){
            return null;
        }

        beforeUpdate.setName(product.getName());
        beforeUpdate.setImage(product.getImage());
        beforeUpdate.setPrice(product.getPrice());

        return productRepository.save(beforeUpdate);
    }

    @Override
    public Product deleteProduct(Product product) {

        if(getProductById(product.getId()) == null){
            return null;
        }

        productRepository.delete(product);

        return product;
    }
}
