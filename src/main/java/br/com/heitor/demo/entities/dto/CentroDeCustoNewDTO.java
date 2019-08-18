package br.com.heitor.demo.entities.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import br.com.heitor.demo.services.validation.CentroDeCustoInsert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@CentroDeCustoInsert
public class CentroDeCustoNewDTO {

	@NotBlank(message = "É obrigatório inserir o Centro de Custo")
	@Length(min = 5, max = 5, message = "O total de caracteres deve ser igual á 5! (Exemplo 22.12)")
	@Pattern(regexp = "(^\\d{2}\\.\\d{2}$)", message = "O texto deve corresponder ao padrão de Centros de Custo! (Exemplo 22.12)")
	private String cc;

	@NotBlank(message = "É obrigatório inserir o Nome do Centro de Custo")
	@Length(min = 1, max = 255, message = "O total de caracteres deve ser até 255!")
	private String nome;
}
