package lt.codeacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import lt.codeacademy.entity.Client;
import lt.codeacademy.repository.ClientRepository;

@Lazy
@Service
public class ClientService {
	@Autowired
	ClientRepository clietnRepository;

	public Client save(Client client) {
		return clietnRepository.save(client);

	}

	public List<Client> getAll() {
		return clietnRepository.findAll();
		
	}

}