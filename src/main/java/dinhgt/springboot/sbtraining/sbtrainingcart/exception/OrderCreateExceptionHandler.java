package dinhgt.springboot.sbtraining.sbtrainingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dinhgt.springboot.sbtraining.sbtrainingcart.error.ErrorResponse;


@RestControllerAdvice
public class OrderCreateExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerException(OrderCreateException error) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setHttpCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(error.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}

}
