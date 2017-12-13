package pl.myshop.entiti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;




@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Size(min=2, max=40)
	@Pattern(regexp="[a-zA-Z0-9]+ ")
	private String name;
	private double price;
	private String description;
	private String unitsInStock;
	
	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	private Byte[] image;

	

	public String getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(String unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	private Brand brand;
	
	@OneToOne
	private Adnotation adnotation;

	Product(String name, double price){
		this.name = name;
		this.price = price;
		
	}
		
	public Product() {
		
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	} 
	
	public static Product genRand() {
		Random rand = new Random();
		
		Product result = new Product("prod" + rand.nextInt(10), rand.nextDouble()*200);
		return result;
	}
	
	public static List<Product> getRandList(int amount){
		List<Product> resultList = new ArrayList<>();
		for(int i=0; i<amount; i++) {
			resultList.add(Product.genRand());
		}
		return resultList;
	}
	
	public String toString() {
		return name + ", cena: " + price;
	}
}
