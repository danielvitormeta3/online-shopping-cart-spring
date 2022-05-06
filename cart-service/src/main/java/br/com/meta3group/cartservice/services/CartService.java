package br.com.meta3group.cartservice.services;

import br.com.meta3group.cartservice.models.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> getAllItemsByUser(Long userId);
    public Cart addItemToCart(Cart cart);
    public Cart removeItemFromCart(Long cartId);
    public Cart incrementCartItem(Long cartId);
    public Cart decrementCartItem(Long cartId);
}
