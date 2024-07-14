package co.simplon.spotmebusiness.exceptions;


import co.simplon.spotmebusiness.controllers.CustomFieldError;
import co.simplon.spotmebusiness.controllers.CustomGlobalError;

import java.util.List;

public class HandlerErrors extends RuntimeException {

	List<CustomFieldError> fieldErrors;
	List<CustomGlobalError> globalErrors;


	public HandlerErrors(List<CustomFieldError> fieldErrors, List<CustomGlobalError> globalErrors) {
		this.fieldErrors = fieldErrors;
		this.globalErrors = globalErrors;
	}

	public List<CustomFieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<CustomFieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public List<CustomGlobalError> getGlobalErrors() {
		return globalErrors;
	}

	public void setGlobalErrors(List<CustomGlobalError> globalErrors) {
		this.globalErrors = globalErrors;
	}

//	public static class FieldErrors {
//
//		private final static Exception FILESIZE = new FileSizeException();
//		private final static Exception FILETYPE = new FileTypeException();
//
//		public FieldErrors() {
//		}
//	}
}
