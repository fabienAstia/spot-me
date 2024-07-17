package co.simplon.spotmebusiness.exceptions;

import co.simplon.spotmebusiness.controllers.CustomFieldError;
import co.simplon.spotmebusiness.controllers.CustomGlobalError;

import java.util.List;

public class FileSizeException extends RuntimeException {

	private String name;
	private String code;

	public FileSizeException() {
		this.name = "image";
		this.code = "FileSize!!!!!";
	}

}
