package co.simplon.spotmebusiness.exceptions;


import java.util.List;

public class HandlerErrors extends RuntimeException {

	List<FieldErrors> fieldErrorsList;
	List<GlobalErrors> globalErrorsList;


	public HandlerErrors(List<GlobalErrors> globalErrorsList, List<FieldErrors> fieldErrorsList) {
		this.globalErrorsList = globalErrorsList;
		this.fieldErrorsList = fieldErrorsList;
	}

	public HandlerErrors() {
	}

	public List<FieldErrors> getFieldErrorsList() {
		return fieldErrorsList;
	}

	public void setFieldErrorsList(List<FieldErrors> fieldErrorsList) {
		this.fieldErrorsList = fieldErrorsList;
	}

	public List<GlobalErrors> getGlobalErrorsList() {
		return globalErrorsList;
	}

	public void setGlobalErrorsList(List<GlobalErrors> globalErrorsList) {
		this.globalErrorsList = globalErrorsList;
	}

	public static class FieldErrors {

		private final static Exception FILESIZE = new FileSizeException();
		private final static Exception FILETYPE = new FileTypeException();

		public FieldErrors() {
		}
	}
}
