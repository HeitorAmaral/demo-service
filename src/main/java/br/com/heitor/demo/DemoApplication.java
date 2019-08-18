package br.com.heitor.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.heitor.demo.entities.Categoria;
import br.com.heitor.demo.entities.CentroDeCusto;
import br.com.heitor.demo.entities.Produto;
import br.com.heitor.demo.repositories.CategoriaRepository;
import br.com.heitor.demo.repositories.CentroDeCustoRepository;
import br.com.heitor.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CentroDeCustoRepository centroDeCustoRepository;;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Mouse", 25.90);
		Produto p2 = new Produto(null, "Teclado", 59.90);
		Produto p3 = new Produto(null, "Cadeira", 255.99);
		Produto p4 = new Produto(null, "Mesa", 599.99);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p3, p4));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2));

		CentroDeCusto cc1 = new CentroDeCusto(null, "22.12", "TesteCc1");
		CentroDeCusto cc2 = new CentroDeCusto(null, "25.15", "TesteCc2");

		centroDeCustoRepository.saveAll(Arrays.asList(cc1, cc2));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}

}
