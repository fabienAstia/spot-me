package co.simplon.spotmebusiness.exceptions;


import java.util.List;

public class HandlerErrors extends RuntimeException {

	List<FieldErrors> fieldErrorsList;
	List<GlobalErrors> globalErrorsList;


	public HandlerErrors(List<GlobalErrors> globalErrorsList, List<FieldErrors> fieldErrorsList) {
		this.globalErrorsList = globalErrorsList;
		this.fieldErrorsList = fieldErrorsList;
	}

	public static class FieldErrors {

		private final static Exception [] fieldExceptions = {new FileSizeException(),  new FileTypeException()};


		public FieldErrors(String fieldException){
//
//			stream.of(fieldExceptions).anyMatch
		}

	}
}
