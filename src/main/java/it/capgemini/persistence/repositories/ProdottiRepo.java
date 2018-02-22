package it.capgemini.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.capgemini.persistence.entity.Prodotto;



public interface ProdottiRepo extends JpaRepository<Prodotto, Long>{

	
	@Query("Select p from Prodotto p where   upper(p.descrizione) like %:desc% and p.prezzo<=:prezzo and p.quantita >=:qty")
	public List<Prodotto> queryEsercizio2(@Param("desc") String desc, @Param("prezzo") Double prezzo, @Param("qty")Integer qty);
	
	List<Prodotto>findByDescrizioneContainingIgnoreCaseAndPrezzoIsLessThanEqualAndQuantitaIsGreaterThanEqual(String desc,Double prezzo, Integer qty);
	
	
	

}
