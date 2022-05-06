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
    private CartService cartService;

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable("id") Long userId){
        List<Cart> cartItemsByUser = cartService.getAllItemsByUser(userId);
        return ResponseEntity.ok(cartItemsByUser);
    }

    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody Cart cart){
        Cart createdCart = cartService.addItemToCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
    }

    @PutMapping("/increment")
    public ResponseEntity<Cart> incrementCartItem(@RequestBody Long cartId){
        Cart updatedCart = cartService.incrementCartItem(cartId);
        if(updatedCart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCart);
    }

    @PutMapping("/decrement")
    public ResponseEntity<Cart> decrementCartItem(@RequestBody Long productId){
        Cart updatedCart = cartService.decrementCartItem(productId);
        if(updatedCart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping
    public ResponseEntity<Cart> removeItemFromCart(@RequestBody Long cartId){
        Cart deletedCart = cartService.removeItemFromCart(cartId);

        if(deletedCart == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(deletedCart);
    }
}
