package br.com.meta3group.cartservice.repositories;

import br.com.meta3group.cartservice.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    public List<Cart> findAllCartsByUserId(Long userId);
}
