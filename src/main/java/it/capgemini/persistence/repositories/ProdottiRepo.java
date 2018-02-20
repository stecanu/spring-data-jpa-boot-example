package it.capgemini.persistence.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.capgemini.persistence.entity.Prodotto;



public interface ProdottiRepo extends PagingAndSortingRepository<Prodotto, Long>{

}
