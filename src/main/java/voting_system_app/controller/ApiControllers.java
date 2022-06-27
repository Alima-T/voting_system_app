package voting_system_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import voting_system_app.model.Dish;
import voting_system_app.model.Restaurant;
import voting_system_app.model.User;
import voting_system_app.repository.DishRepo;
import voting_system_app.repository.RestaurantRepo;
import voting_system_app.repository.UserRepo;

import java.util.List;

/**
 * @Alima-T 27.06.2022
 */
@RestController
public class ApiControllers {
    @Autowired
    private DishRepo dishRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome to the restaurant's voting system";
    }
    @GetMapping(value = "/dish")
    public List<Dish> getDishRepo() {
        return dishRepo.findAll();
    }

    @GetMapping(value = "/restaurant")
    public List<Restaurant> getRestaurantRepo() {
        return restaurantRepo.findAll();
    }
    @GetMapping(value = "/user")
    public List<User> getUserRepo() {
        return userRepo.findAll();
    }


}
