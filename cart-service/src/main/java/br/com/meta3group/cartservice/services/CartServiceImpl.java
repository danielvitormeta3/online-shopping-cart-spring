package br.com.meta3group.cartservice.services;

import br.com.meta3group.cartservice.models.Cart;
import br.com.meta3group.cartservice.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllItemsByUser(Long userId) {
        return cartRepository.findAllCartsByUserId(userId);
    }

    @Override
    public Cart addItemToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeItemFromCart(Long cartId) {
        Cart cartToBeRemoved = cartRepository.findById(cartId).orElse(null);
        if(cartToBeRemoved == null){
            return null;
        }
        cartRepository.delete(cartToBeRemoved);
        return cartToBeRemoved;
    }

    @Override
    public Cart incrementCartItem(Long cartId) {
        Cart cartToBeIncremented = cartRepository.findById(cartId).orElse(null);
        if(cartToBeIncremented == null){
            return null;
        }

        cartToBeIncremented.setQuantity(cartToBeIncremented.getQuantity() + 1);
        return cartRepository.save(cartToBeIncremented);
    }

    @Override
    public Cart decrementCartItem(Long cartId) {
        Cart cartToBeDecremented = cartRepository.findById(cartId).orElse(null);
        if(cartToBeDecremented == null){
            return null;
        }

        if(cartToBeDecremented.getQuantity() == 1){
            cartRepository.delete(cartToBeDecremented);
            return cartToBeDecremented;
        }

        cartToBeDecremented.setQuantity(cartToBeDecremented.getQuantity() - 1);
        return cartRepository.save(cartToBeDecremented);
    }
}
