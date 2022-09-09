package lt.codeacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import lt.codeacademy.entity.Privilege;
import lt.codeacademy.entity.Provider;

public interface PrivilegeRepository extends JpaRepository <Privilege, Long>{

	Privilege findByName(String name);
	
}
