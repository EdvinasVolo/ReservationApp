package lt.codeacademy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		
		public Client getClient(String username) {		
			return clietnRepository.findByUsername(username);
		}
	//}
	   public List<Client> getClients() {
			return clietnRepository.findAll();
	   }
			
	   public Role save(Role role) {
			return roleRepo.save(role);
		}
	   public void addRoleToUser(String username, String roleName) {
			Client client = clietnRepository.findByUsername(username);
			Role role = roleRepo.findByName(roleName);
			client.getRoles().add(role);	
			clietnRepository.save(client);
		}
	   public UserDetails loadUserByEmail (String username) throws UsernameNotFoundException {
			//To get UserDetails we have to get a user from DB first
			Client user = getClient(username);
			if(user == null) {

				throw new UsernameNotFoundException(username);
			}
			
			//We will return User from spring security package
			//so we need to get Authorities list from the user first
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
			//getting roles from our user and adding them to authorities list
			user.getRoles().forEach( role -> {
				authorities.add(new SimpleGrantedAuthority( role.getName()));
			});
			
			//Next we have to create special User for Spring security
			var resultUser = new org.springframework.security.core.userdetails  //package name here
					.User(
						user.getName(),
						user.getPassword(),
						authorities						
					);
			//We have to return special type of User here
			return resultUser;
		}
	
		public void updatePassword(String username, String newPassword) {
			Client user = getClient(username);
			user.setPassword(newPassword);
			clietnRepository.save(user);
		}
		
}