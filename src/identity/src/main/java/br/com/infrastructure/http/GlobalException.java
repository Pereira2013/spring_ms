package br.com.infrastructure.http;

import br.com.domain._share.ApiException;
import br.com.domain._share.ExceptionMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ExceptionMessage> apiExceptionMessage(ApiException e){

		ExceptionMessage err = new ExceptionMessage(e.getErros());
		return ResponseEntity.status(e.getStatusCode()).body(err);
	}
}
