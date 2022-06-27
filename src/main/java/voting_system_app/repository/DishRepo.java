package voting_system_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;
import voting_system_app.model.Dish;

import java.util.List;

/**
 * @Alima-T 6/26/2022
 */
public interface DishRepo extends JpaRepository<Dish, Long> {
//    @Secured("admin")
//    Dish save(Dish dish);
//
//    void delete(Dish dish);
//
//    Dish findDishById (Long id);
//
//    List<Dish> findAll();


}
