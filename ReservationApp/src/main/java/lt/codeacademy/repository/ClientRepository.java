package lt.codeacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import lt.codeacademy.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository <Client, Long>{

	UserDetails findByEmail(String email);
}
