package com.test.babel.siniestro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.test.babel.siniestro.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionController {

	@SuppressWarnings("static-access")
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(
			ResourceNotFoundException resourceNotFoundException) {

		String mensaje = resourceNotFoundException.getMessage();

		ApiResponse response = new ApiResponse().builder().message(mensaje).success(true).status(HttpStatus.NOT_FOUND)
				.build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Object> handleNoHandlerFound404() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
