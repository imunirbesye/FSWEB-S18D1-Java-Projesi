package tr.com.workintech.burger.controller;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.workintech.burger.dao.BurgerDao;
import tr.com.workintech.burger.entity.BreadType;
import tr.com.workintech.burger.entity.Burger;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerDao;
    
    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger){
        return burgerDao.save(burger);
    }

    @GetMapping
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable long id) {
        return burgerDao.findById(id);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger) {
        return burgerDao.update(burger);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable int price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByContent/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }
}
