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

import lt.codeacademy.service.ServiceProviderService;

@Entity
@Table(name="providers")
public class ServiceProvider {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name; 
	String email;
	long phoneNumber;
	String address;
	String description;
	double price;
	
	@OneToMany( cascade = CascadeType.ALL)
	List<ServiceProvider> providers = new ArrayList<ServiceProvider>();
	
	public List<ServiceProvider> getProviders() {
		return providers;
	}

	public void setProviders(List<ServiceProvider> providers) {
		this.providers = providers;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	

	public ServiceProvider(int id, String name, String email, long phoneNumber, String address, String description,
			double price, List<ServiceProvider> providers) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.description = description;
		this.price = price;
		this.providers = providers;
	}
	

	public ServiceProvider(String name, String email, long phoneNumber, String address, String description,
			double price, List<ServiceProvider> providers) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.description = description;
		this.price = price;
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "ServiceProvider [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", description=" + description + ", price=" + price + ", providers="
				+ providers + "]";
	}
	public ServiceProvider(String name) {
		this.name = name;
	}
	

	
	
	
}
