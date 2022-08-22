package lt.codeacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository <Client, Integer>{

}
