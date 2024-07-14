package co.simplon.spotmebusiness.controllers;

import java.util.ArrayList;
import java.util.List;

import co.simplon.spotmebusiness.exceptions.HandlerErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		System.out.println("ControllerAdvice.handleMethodArgumentNotValid()");
		List<FieldError> errors = ex.getFieldErrors();
		List<ObjectError> globalErrors = ex.getGlobalErrors();
		List<CustomFieldError> customErrors = new ArrayList<>();
		List<CustomGlobalError> customGlobalErrors = new ArrayList<>();

		for (FieldError error : errors) {
			String fieldName = error.getField();
			String code = error.getCode();
			CustomFieldError customFieldError = new CustomFieldError(fieldName, code);
			customErrors.add(customFieldError);
		}
		for (ObjectError globalError : globalErrors) {
			String code = globalError.getCode();
			CustomGlobalError customGlobalError = new CustomGlobalError(code);
			customGlobalErrors.add(customGlobalError);
		}

		HandlerErrors handlerErrors = new HandlerErrors(customErrors, customGlobalErrors);

		return handleExceptionInternal(ex, handlerErrors, headers, status, request);
	}

	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
															 HttpStatusCode statusCode, WebRequest request) {
		System.out.println("ControllerAdvice.handleExceptionInternal()");
		return super.handleExceptionInternal(ex, body, headers, statusCode, request);
	}
	@ResponseBody
	@ExceptionHandler(value = GlobalErrors.class)
	public ResponseEntity<?> handleSpotAlreadyExistsException(GlobalErrors exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

}
