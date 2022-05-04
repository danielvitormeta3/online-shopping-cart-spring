package br.com.meta3group.cartservice.controllers;

import br.com.meta3group.cartservice.models.Cart;
import br.com.meta3group.cartservice.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService productService;

    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody Cart cart){
        Cart createdCart = productService.addItemToCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
    }

    @PutMapping("/increment")
    public ResponseEntity<Cart> incrementCartItem(@RequestBody Long productId){
        Cart updatedCart = productService.incrementCartItem(productId);
        if(updatedCart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCart);
    }

    @PutMapping("/decrement")
    public ResponseEntity<Cart> decrementCartItem(@RequestBody Long productId){
        Cart updatedCart = productService.decrementCartItem(productId);
        if(updatedCart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping
    public ResponseEntity<Cart> removeItemFromCart(@RequestBody Long productId){
        Cart deletedCart = productService.removeItemFromCart(productId);

        if(deletedCart == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(deletedCart);
    }
}
