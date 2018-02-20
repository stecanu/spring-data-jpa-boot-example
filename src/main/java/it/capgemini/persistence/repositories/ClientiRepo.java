package it.capgemini.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.capgemini.persistence.entity.Cliente;
import java.lang.String;


public interface ClientiRepo extends JpaRepository<Cliente, Long> {
	
	
	 List<Cliente> findByCognome(String cognome);
	List<Cliente> findByIgnoreCaseCognomeIsContaining(@Param("cognome")String cognome);
	
	
	List<Cliente> findByNomeOrCognomeAndTelefono(String nome, String Cognome, String telefono);
	
   List<Cliente> findByCognomeIsNullOrNomeIsNotLike(String nome);
   
   List<Cliente> findByNomeStartingWithOrNomeIsNullAndCognomeIsNotNullOrTelefonoLike(String param1,String telefono);
	

   


}