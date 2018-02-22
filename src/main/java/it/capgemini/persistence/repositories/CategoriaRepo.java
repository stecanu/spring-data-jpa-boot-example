package it.capgemini.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.capgemini.persistence.entity.Categoria;

public interface CategoriaRepo extends JpaRepository<Categoria, Long> {

}
