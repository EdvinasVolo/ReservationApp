package lt.codeacademy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="providers")
public class ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	String email;
	long phoneNumber;
	String addres;
	String description;
	
	@OneToMany( cascade = CascadeType.ALL)
	List<ServiceProvider> providers = new ArrayList<ServiceProvider>();
	
	public ServiceProvider() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceProvider(int id, String email, long phoneNumber, String addres, String description) {
		super();
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.addres = addres;
		this.description = description;
	}

	public ServiceProvider(String email, long phoneNumber, String addres, String description) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.addres = addres;
		this.description = description;
	}

	@Override
	public String toString() {
		return "ServiceProvider [id=" + id + ", email=" + email + ", phoneNumber=" + phoneNumber + ", addres=" + addres
				+ ", description=" + description + "]";
	}
	
	
}
