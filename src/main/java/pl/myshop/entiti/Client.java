package pl.myshop.entiti;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "clients")

public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Size(min=2,max=30)
	private String firstName;
	
	@Size(min=2,max=128)
	@Pattern(regexp = "[a-zA-z\\-]+")
	private String lastName;
	
	@Email
	@Size(min=2,max=128)
	private String email;
	private String[] skills;
	
	public Client(){};
	
	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	};
	
	@OneToMany(mappedBy="client",
			cascade=CascadeType.ALL)
	private List<Order> orders;
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ",lastName=" + lastName + "]";
	}
	
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
