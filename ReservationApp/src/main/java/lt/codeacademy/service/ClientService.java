package lt.codeacademy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lt.codeacademy.entity.Client;
import lt.codeacademy.entity.Role;
import lt.codeacademy.repository.ClientRepository;
import lt.codeacademy.repository.RoleRepository;

@Lazy
@Service
public class ClientService implements UserDetailsService{
	@Autowired
	ClientRepository clietnRepository;
	@Autowired 
	RoleRepository roleRepo;

	public Client save(Client client) {
		return clietnRepository.save(client);

	}

	public List<Client> getAll() {
		return clietnRepository.findAll();
		
	}

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		return clietnRepository.findByEmail(email);
	}
	   public void registerDefaultUser(Client client) {
	        Role roleUser = roleRepo.findByName("User");
	        client.addRole(roleUser);
	 
	        clietnRepository.save(client);
	    }
	//public String register(RegistrationRequest request) {
		
	//}
}