package org.launchcode.launchcart.data;

import org.launchcode.launchcart.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByName(String name);

}
