package lt.codeacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.entity.ServiceProvider;


@Repository
public interface ServiceProviderRepository extends JpaRepository <ServiceProvider, Integer>{

}
