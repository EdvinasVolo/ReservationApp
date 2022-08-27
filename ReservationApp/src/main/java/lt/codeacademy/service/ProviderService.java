package lt.codeacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.entity.Provider;
import lt.codeacademy.repository.ProviderRepository;

@Service
public class ProviderService {
	
	@Autowired
	ProviderRepository providerRepository;
	
	
	
	public Provider save(Provider serviceProvider) {
		return providerRepository.save(serviceProvider);

	}
	
	
	public List<Provider> findAllProvider() {
		return providerRepository.findAll();

	}


	public Provider findById(int id) {
		Provider serviceProvider =  providerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + id));
		return serviceProvider;
	}

}
