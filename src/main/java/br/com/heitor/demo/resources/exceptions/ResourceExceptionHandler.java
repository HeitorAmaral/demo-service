package br.com.heitor.demo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.heitor.demo.services.exceptions.DataIntegrityException;
import br.com.heitor.demo.services.exceptions.ObjectNotFoundException;

/**
 * Manipulador de excessões do recurso
 * 
 * @author heitor
 *
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		// StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),
		// e.getMessage(), System.currentTimeMillis());
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {

		// StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(),
		// e.getMessage(), System.currentTimeMillis());
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Integridade de dados", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

		// ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),
		// "Erro de validação", System.currentTimeMillis());
		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Erro de validação", e.getMessage(), request.getRequestURI());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
}