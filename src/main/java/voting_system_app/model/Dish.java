package voting_system_app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Alima-T 6/26/2022
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Dish {

    private String name;
    private int price;
    private Menu menu;

}
