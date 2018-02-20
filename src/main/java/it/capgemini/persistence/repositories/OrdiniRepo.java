package it.capgemini.persistence.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.capgemini.persistence.entity.Ordine;


public interface OrdiniRepo extends PagingAndSortingRepository<Ordine, Long> {

}
