package voting_system_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import voting_system_app.model.Restaurant;

import java.util.List;

/**
 * @Alima-T 6/26/2022
 */
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
//
//
//    Restaurant save(Restaurant restaurant);
//
//    void delete(Restaurant restaurant);
//
//    List<Restaurant> findAll();
}
