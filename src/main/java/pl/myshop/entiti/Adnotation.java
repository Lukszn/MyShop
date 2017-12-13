package pl.myshop.entiti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adnotation")

public class Adnotation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	
	
	private String description;

}
