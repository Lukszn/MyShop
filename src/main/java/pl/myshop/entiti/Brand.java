package pl.myshop.entiti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;



@Entity
@Table(name = "brands")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	@OneToMany(mappedBy = "brand",
			cascade =CascadeType.REMOVE)
	private List<Product> products =new ArrayList<>();

	@Size(min=2,max=50)
	
	private String name;


	Brand(String name){
		this.name = name;

	}

	public Brand() {

	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public static Brand genRand() {
		Random rand = new Random();
		Brand result = new Brand("brand" + rand.nextInt(10));
		return result;
	}

	@Override
	public String toString() {
		return name;
	}
}
