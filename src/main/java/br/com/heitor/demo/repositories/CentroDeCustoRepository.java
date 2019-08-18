package br.com.heitor.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heitor.demo.entities.CentroDeCusto;

public interface CentroDeCustoRepository extends JpaRepository<CentroDeCusto, Integer> {

	CentroDeCusto findByCc(String cc);

}
