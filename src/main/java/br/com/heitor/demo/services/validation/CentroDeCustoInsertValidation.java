package br.com.heitor.demo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.heitor.demo.entities.CentroDeCusto;
import br.com.heitor.demo.entities.dto.CentroDeCustoNewDTO;
import br.com.heitor.demo.repositories.CentroDeCustoRepository;
import br.com.heitor.demo.resources.exceptions.FieldMessage;

public class CentroDeCustoInsertValidation implements ConstraintValidator<CentroDeCustoInsert, CentroDeCustoNewDTO> {

	@Autowired
	private CentroDeCustoRepository centroDeCustoRepository;

	@Override
	public void initialize(CentroDeCustoInsert ann) {
	}

	@Override
	public boolean isValid(CentroDeCustoNewDTO centroDeCustoNewDto, ConstraintValidatorContext context) {

		List<FieldMessage> listFieldMessage = new ArrayList<>();

		CentroDeCusto centroDeCusto = centroDeCustoRepository.findByCc(centroDeCustoNewDto.getCc());
		if (centroDeCusto != null) {
			listFieldMessage.add(new FieldMessage("cc", "Centro de Custo " + centroDeCusto.getCc() + " já existente!"));
		}

		for (FieldMessage e : listFieldMessage) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return listFieldMessage.isEmpty();
	}

}