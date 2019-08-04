package br.com.heitor.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.heitor.demo.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
