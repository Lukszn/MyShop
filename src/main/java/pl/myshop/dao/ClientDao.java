package pl.myshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.myshop.entiti.Client;


@Component
@Transactional

public class ClientDao {
	
	@PersistenceContext
	EntityManager entityManager;

	public void saveClient(Client entity) {
		entityManager.persist(entity);
	}
	
	public Client findById(long id) {
		return entityManager.find(Client.class, id);
	}
	
	public void update(Client entity) {
		entityManager.merge(entity);
	}

	public void delete(Client entity) {
		entityManager.remove(entityManager.contains(entity) ?
		entity : entityManager.merge(entity));
	}
	
	public List<Client> getList() {
		Query query = entityManager.createQuery("SELECT a FROM Client a");
		List<Client> clients = query.getResultList();
		return clients;
	
	}	

}
