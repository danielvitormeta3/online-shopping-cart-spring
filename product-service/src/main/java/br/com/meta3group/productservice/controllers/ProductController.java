package br.com.meta3group.productservice.controllers;

import br.com.meta3group.productservice.models.Product;
import br.com.meta3group.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody  Product product){
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAllProducts();

        if(products.isEmpty()){
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);

        if(product == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(product);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody  Product product){
        Product updatedProduct = productService.updateProduct(product);

        if(product == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);

        if(product == null){
            return ResponseEntity.notFound().build();
        }

        productService.deleteProduct(product);

        return ResponseEntity.ok(product);
    }
}
