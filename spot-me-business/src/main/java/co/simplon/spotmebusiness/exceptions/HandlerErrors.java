package co.simplon.spotmebusiness.exceptions;


import java.util.List;

public class HandlerErrors extends RuntimeException {

	List<FieldErrors> fieldErrors;
	List<GlobalErrors> globalErrors;



	public HandlerErrors(List<GlobalErrors> globalErrors, List<FieldErrors> fieldErrors) {
		this.globalErrors = globalErrors;
		this.fieldErrors = fieldErrors;
	}

	public HandlerErrors() {
	}


	public HandlerErrors(List<FieldErrors> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public List<FieldErrors> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrors> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public List<GlobalErrors> getGlobalErrors() {
		return globalErrors;
	}

	public void setGlobalErrors(List<GlobalErrors> globalErrors) {
		this.globalErrors = globalErrors;
	}

	public static class FieldErrors {

		private final static Exception FILESIZE = new FileSizeException();
		private final static Exception FILETYPE = new FileTypeException();

		public FieldErrors() {
		}
	}
}
