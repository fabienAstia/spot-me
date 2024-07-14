package co.simplon.spotmebusiness.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.simplon.spotmebusiness.exceptions.GlobalErrors;

@RestControllerAdvice
public class SpotControllerAdvice extends ResponseEntityExceptionHandler {

//Exception to be thrown when validation on an argument annotated with @Valid fails
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		System.out.println("ControllerAdvice.handleMethodArgumentNotValid()");
		List<FieldError> errors = ex.getFieldErrors();
		List<CustomFieldError> customErrors = new ArrayList<>();
		for (FieldError error : errors) {
			String fieldName = error.getField();
			String code = error.getCode();
			CustomFieldError customFieldError = new CustomFieldError(fieldName, code);
			customErrors.add(customFieldError);
		}
		return handleExceptionInternal(ex, customErrors, headers, status, request);
	}

	@ResponseBody
	@ExceptionHandler(value = GlobalErrors.class)
	public ResponseEntity<?> handleSpotAlreadyExistsException(GlobalErrors exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

//	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
//			HttpStatusCode statusCode, WebRequest request) {
//		System.out.println("ControllerAdvice.handleExceptionInternal()");
//		return super.handleExceptionInternal(ex, body, headers, statusCode, request);
//	}

}
