package br.com.heitor.demo.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.heitor.demo.entities.CentroDeCusto;
import br.com.heitor.demo.entities.dto.CentroDeCustoNewDTO;
import br.com.heitor.demo.entities.dto.listvalidation.CentroDeCustoInsertList;
import br.com.heitor.demo.services.CentroDeCustoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/cc")
@Api
@Validated
public class CentroDeCustoController {

	@Autowired
	private CentroDeCustoService centroDeCustoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<CentroDeCusto> listCentroDeCusto = centroDeCustoService.findAll();
		return ResponseEntity.ok(listCentroDeCusto);
	}

	@ApiOperation(value = "Save")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Valid CentroDeCustoInsertList listCentroDeCustoNewDTO) {
		ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.CREATED);
		for (CentroDeCustoNewDTO cc : listCentroDeCustoNewDTO.getListCentroDeCustoNewDTO()) {
			CentroDeCusto centroDeCusto = centroDeCustoService.fromDTO(cc);
			centroDeCusto = centroDeCustoService.insert(centroDeCusto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(centroDeCusto.getId()).toUri();
			responseEntity = ResponseEntity.created(uri).build();
		}
		return responseEntity;
	}
}
