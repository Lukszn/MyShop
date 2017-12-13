package pl.myshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.myshop.entiti.Client;
import pl.myshop.entiti.Order;
import pl.myshop.entiti.Product;



public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByClient(Client client);
	int countByClient(Client client);
	int countByProduct(Product product);

}
