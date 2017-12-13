package pl.myshop.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import pl.myshop.entiti.Client;


public class ClientRepositoryImpl implements CustomClientRepo {
	
	@PersistenceUnit
	private EntityManagerFactory emFactory;
	public ClientRepositoryImpl() { 
		
	}

	@Override
	public Client myCustomFindById(Long id) {
		EntityManager entityManager = emFactory.createEntityManager();
		Client client = entityManager.find(Client.class, id);
		entityManager.close();
		return client; 
		} 

}
