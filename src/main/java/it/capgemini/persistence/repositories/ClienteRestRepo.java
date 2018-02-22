package it.capgemini.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.*;


import it.capgemini.persistence.entity.Cliente;

@RepositoryRestResource(collectionResourceRel="clienti" ,path = "clienti")
public interface ClienteRestRepo extends  JpaRepository<Cliente, Long> {
	
	@RestResource(exported = false)
	List<Cliente>  findByNome(@Param(value = "nome") String name);
	List<Cliente>  findByCognome(@Param(value = "cognome")String cognome);
	
	@Override
	@RestResource(exported = false)
	void deleteAll();

	
}
