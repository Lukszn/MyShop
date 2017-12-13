package pl.myshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.myshop.entiti.Brand;



@Component
@Transactional

public class BrandDao {
	
	@PersistenceContext
	EntityManager entityManager;

	public void saveBrand(Brand entity) {
		entityManager.persist(entity);
	}
	
	public Brand findById(long id) {
		return entityManager.find(Brand.class, id);
	}
	
	public void update(Brand entity) {
		entityManager.merge(entity);
	}

	public void delete(Brand entity) {
		entityManager.remove(entityManager.contains(entity) ?
		entity : entityManager.merge(entity));
	}
	
	public List<Brand> getList() {
		Query query = entityManager.createQuery("SELECT a FROM Brand a");
		List<Brand> brands = query.getResultList();
		return brands;
	
	}	
	
	public List<Brand> getFUllList() {
		Query query = entityManager.createQuery("SELECT brand FROM Brand brand LEFT JOIN FETCH brand.products");
		List<Brand> brands = query.getResultList();
		return brands;
	
	}	

}
