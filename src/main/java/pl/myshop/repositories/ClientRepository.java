package pl.myshop.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.myshop.entiti.Client;




public interface ClientRepository extends JpaRepository<Client, Long>,CustomClientRepo{
	
	@Query("select u from Client u where u.firstName = :firstname or u.lastName = :lastname")
			List<Client> findByLastnameOrFirstname(@Param("lastname") String lastname,@Param("firstname") String firstname);
	
	@Query("SELECT DISTINCT client FROM Client client LEFT JOIN FETCH client.orders")
	List<Client> getAllCustomers();
	
	
	Client findByLastName(String name);
	
	
	
	
	

}
