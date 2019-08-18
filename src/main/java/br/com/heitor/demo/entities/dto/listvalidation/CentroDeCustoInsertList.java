package br.com.heitor.demo.entities.dto.listvalidation;

import java.util.List;

import javax.validation.Valid;

import br.com.heitor.demo.entities.dto.CentroDeCustoNewDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CentroDeCustoInsertList {

	@Valid
	List<CentroDeCustoNewDTO> listCentroDeCustoNewDTO;

	// getters and setters....
}
