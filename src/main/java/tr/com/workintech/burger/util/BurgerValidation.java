package tr.com.workintech.burger.util;

import org.springframework.http.HttpStatus;
import tr.com.workintech.burger.entity.BreadType;
import tr.com.workintech.burger.entity.Burger;
import tr.com.workintech.burger.exceptions.BurgerException;

public class BurgerValidation {
    public static void checkBurger(Burger burger) {
        if(burger.getName() == null || burger.getName().isEmpty())
            throw new BurgerException("name cannot be null or empty", HttpStatus.BAD_REQUEST);
    }

    public static void checkBurgerNull(Burger burger, long id) {
        if(burger == null){
            throw new BurgerException("burger with given id not exist: " + id, HttpStatus.NOT_FOUND);
        }
    }

    public static void checkPrice(int price) {
        if(price < 0) {
            throw new BurgerException("price cannot be less then zero! Price: " + price, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkBreadTypeNull(BreadType breadType) {
        if(breadType == null) {
            throw new BurgerException("breadType cannot be null!", HttpStatus.BAD_REQUEST);
        }
    }
}
