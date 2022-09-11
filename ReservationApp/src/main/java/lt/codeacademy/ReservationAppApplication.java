package lt.codeacademy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static lt.codeacademy.utils.Utils.*;

import java.util.ArrayList;
import java.util.Collection;

import lt.codeacademy.entity.Client;
import lt.codeacademy.entity.Role;
import lt.codeacademy.service.ClientService;

@SpringBootApplication
public class ReservationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationAppApplication.class, args);
	}

	
	
	
	
	
	

	
	@Bean
	CommandLineRunner run(ClientService clientService) {
		return args -> {
			
			if(!clientService.getClients().isEmpty()) return;
			
			clientService.save(new Role(null, USER));
			clientService.save(new Role(null, ADMIN));

			clientService.save(new Client("Tomas Tomaitis", "tomukasss", "tomas@gmail.com",745363, "1234", new ArrayList<>()));
			clientService.save(new Client("Laura Lauryte", "laurax", "lauraLauryte@gmail.com", 54564645, "1234", new ArrayList<>()));
			clientService.save(new Client("Petras Petraitis", "petriux","petrasp@gmail.com",7543577, "1234", new ArrayList<>()));
			
			clientService.addRoleToUser("tomukasss", USER);
			clientService.addRoleToUser("laurax", USER);
			clientService.addRoleToUser("laurax", ADMIN);
			clientService.addRoleToUser("petriux", USER);		
			
			clientService.updatePassword("petriux", new BCryptPasswordEncoder().encode("1234") );
			clientService.updatePassword("tomukasss", new BCryptPasswordEncoder().encode("1234") );
			clientService.updatePassword("laurax", new BCryptPasswordEncoder().encode("1234") );
		};
	}
}
