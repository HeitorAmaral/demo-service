package br.com.heitor.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.heitor.demo.entities.Produto;
import br.com.heitor.demo.services.ProdutoService;

@RestController
@RequestMapping(value = "/api/user/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> listProduto = produtoService.findAll();
		return ResponseEntity.ok().body(listProduto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok().body(produto);
	}
}
