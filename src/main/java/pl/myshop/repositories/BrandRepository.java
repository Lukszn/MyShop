package pl.myshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.myshop.entiti.Brand;



public interface BrandRepository extends JpaRepository<Brand, Long> {
	
	@Query("SELECT DISTINCT brand FROM Brand brand LEFT JOIN FETCH brand.products")
	List<Brand> getFullList();

}
