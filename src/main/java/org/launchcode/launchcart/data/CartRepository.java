package org.launchcode.launchcart.data;

import org.launchcode.launchcart.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LaunchCode
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
