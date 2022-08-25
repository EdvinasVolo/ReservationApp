package lt.codeacademy.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import lt.codeacademy.repository.ServiceProviderRepository;
import lt.codeacademy.service.ServiceProviderService;

@Entity
@Table(name="providers")
public class ServiceProvider implements ServiceProviderRepository {
	
	
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

	@Override
	public List<ServiceProvider> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceProvider> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceProvider> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ServiceProvider> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends ServiceProvider> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ServiceProvider> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<ServiceProvider> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServiceProvider getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceProvider getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceProvider getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ServiceProvider> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ServiceProvider> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ServiceProvider> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ServiceProvider> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ServiceProvider> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ServiceProvider entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ServiceProvider> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends ServiceProvider> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ServiceProvider> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ServiceProvider> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends ServiceProvider> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends ServiceProvider, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
}
