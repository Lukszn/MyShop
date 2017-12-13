package pl.myshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.myshop.entiti.Product;



@Component
@Transactional
public class ProductDao {

	@PersistenceContext
	EntityManager entityManager;

	public void saveProduct(Product entity) {
		entityManager.persist(entity);
	}
	
	public Product findById(long id) {
		return entityManager.find(Product.class, id);
	}
	
	public void update(Product entity) {
		entityManager.merge(entity);
	}

	public void delete(Product entity) {
		entityManager.remove(entityManager.contains(entity) ?
		entity : entityManager.merge(entity));
	}
	
	public List<Product> getList() {
		Query query = entityManager.createQuery("SELECT a FROM Product a ");
		List<Product> products = query.getResultList();
		return products;
	}
}
