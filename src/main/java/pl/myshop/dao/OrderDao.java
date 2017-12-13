package pl.myshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.myshop.entiti.Order;



@Component
@Transactional

public class OrderDao {
	
	@PersistenceContext
	EntityManager entityManager;

	public void saveOrder(Order entity) {
		entityManager.persist(entity);
	}
	
	public Order findById(long id) {
		return entityManager.find(Order.class, id);
	}
	
	public void update(Order entity) {
		entityManager.merge(entity);
	}

	public void delete(Order entity) {
		entityManager.remove(entityManager.contains(entity) ?
		entity : entityManager.merge(entity));
	}
	
	public List<Order> getList() {
		Query query = entityManager.createQuery("SELECT a FROM Order a");
		List<Order> orders = query.getResultList();
		return orders;
	
	}	
	

}
