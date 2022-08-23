package lt.codeacademy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.repository.ClientRepository;



@Entity
@Table(name="clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	String email;
	long phoneNumber;
	
	@OneToMany( cascade = CascadeType.ALL)
	List<Client> clients = new ArrayList<Client>();
	


	public Client() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}



	public Client(String name, String email, long phoneNumber, List<Client> clients) {
	
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.clients = clients;
	}

	public Client(int id, String name, String email, long phoneNumber, List<Client> clients) {
	
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", clients=" + clients + "]";
	}

	public Client(String name, String email, long phoneNumber) {
	
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	

}
