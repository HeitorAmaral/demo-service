package br.com.heitor.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heitor.demo.entities.CentroDeCusto;
import br.com.heitor.demo.entities.dto.CentroDeCustoNewDTO;
import br.com.heitor.demo.repositories.CentroDeCustoRepository;

@Service
public class CentroDeCustoService {

	@Autowired
	private CentroDeCustoRepository centroDeCustoRepository;

	public List<CentroDeCusto> findAll() {
		return centroDeCustoRepository.findAll();
	}

	public CentroDeCusto insert(CentroDeCusto centroDeCusto) {
		return centroDeCustoRepository.save(centroDeCusto);
	}

	public CentroDeCusto fromDTO(CentroDeCustoNewDTO centroDeCustoNewDTO) {
		return new CentroDeCusto(null, centroDeCustoNewDTO.getCc(), centroDeCustoNewDTO.getNome());
	}
}
