package lt.codeacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.entity.ServiceProvider;
import lt.codeacademy.repository.ServiceProviderRepository;

@Service
public class ServiceProviderService {
	
	@Autowired
	ServiceProviderRepository providerRepository;
	
	
	
	public ServiceProvider save(ServiceProvider serviceProvider) {
		return providerRepository.save(serviceProvider);

	}
	
	
	public List<ServiceProvider> findAllProvider() {
		return providerRepository.findAll();

	}


	public ServiceProvider findById(int id) {
		ServiceProvider serviceProvider =  providerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + id));
		return serviceProvider;
	}

}
