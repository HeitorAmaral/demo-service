package br.com.heitor.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heitor.demo.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
