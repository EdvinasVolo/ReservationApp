package lt.codeacademy.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name="clients")
public class Client implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String usernamer;
	private String name;
	private String email;
	private long phoneNumber;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role clientRole;
    
	
	@OneToMany( cascade = CascadeType.ALL)
	List<Client> clients = new ArrayList<Client>();
	


	public Client() {
	
	}

	public long getId() {
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



	public String getUsernamer() {
		return email;
	}

	public void setUsernamer(String usernamer) {
		this.usernamer = usernamer;
	}

	public Role getClientRole() {
		return clientRole;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setClientRole(Role clientRole) {
		this.clientRole = clientRole;
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
				+ ", password=" + password + ", clients=" + clients + "]";
	}
	

	public Client(String name, String email, long phoneNumber, String password, Role clientRole,
			List<Client> clients) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.clientRole = clientRole;
		this.clients = clients;
	}

	public Client(String name, String email, long phoneNumber) {
	
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	

	public Client(long id, String name, String email, long phoneNumber, String password, List<Client> clients) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.clients = clients;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(clientRole.name());
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		return  password;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		return null;
	}
	

}
