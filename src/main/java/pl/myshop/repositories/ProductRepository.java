package pl.myshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.myshop.entiti.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByName(String name);

}
