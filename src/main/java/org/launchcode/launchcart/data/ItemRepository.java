package org.launchcode.launchcart.data;

import org.launchcode.launchcart.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LaunchCode
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
