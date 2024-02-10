package tr.com.workintech.burger.dao;

import tr.com.workintech.burger.entity.BreadType;
import tr.com.workintech.burger.entity.Burger;

import java.util.List;

public interface BurgerDao {

    Burger save(Burger burger);

    List<Burger> findAll();

    Burger findById(long id);

    Burger update(Burger burger);

    Burger remove(long id);

    List<Burger> findByPrice(int price);

    List<Burger> findByBreadType(BreadType breadType);

    List<Burger> findByContent(String content);

}
