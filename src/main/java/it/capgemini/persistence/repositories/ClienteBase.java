package it.capgemini.persistence.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import it.capgemini.persistence.entity.Cliente;

@org.springframework.stereotype.Repository
public interface ClienteBase extends Repository<Cliente, Long> {

	@Query("Select c from Cliente c ")
    public Set<Cliente> findAll();	
	
//	@Query(value = "SELECT * FROM CLIENTE c ", nativeQuery=true)
//	  public Set<Cliente> findAll();
	
	
	
  
 
}
