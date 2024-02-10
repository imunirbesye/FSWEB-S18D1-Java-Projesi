package tr.com.workintech.burger.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tr.com.workintech.burger.entity.BreadType;
import tr.com.workintech.burger.entity.Burger;
import tr.com.workintech.burger.util.BurgerValidation;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao {

    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Burger save(Burger burger) {
        BurgerValidation.checkBurger(burger);
        this.entityManager.persist(burger);
        return null;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b from Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public Burger findById(long id) {
        Burger b = entityManager.find(Burger.class, id);
        BurgerValidation.checkBurgerNull(b, id);
        return b;
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        BurgerValidation.checkBurger(burger);
        return entityManager.merge(burger);
    }

    @Override
    public Burger remove(long id){
        Burger foundBurger = findById(id);
        entityManager.remove(foundBurger);
        return foundBurger;
    }

    @Override
    public List<Burger> findByPrice(int price) {
        BurgerValidation.checkPrice(price);

        TypedQuery<Burger> query = entityManager.createQuery("SELECT b from Burger b Where b.price ORDER BY b.price DESC", Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        BurgerValidation.checkBreadTypeNull(breadType);

        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b Where b.bread_type = :breadType ORDER BY b.name DESC", Burger.class);
        query.setParameter("breadType", breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b Where b.contents LIKE CONCAT('%', :content, '%') ORDER BY b.name DESC", Burger.class);
        query.setParameter("content", content);
        return query.getResultList();
    }
}
