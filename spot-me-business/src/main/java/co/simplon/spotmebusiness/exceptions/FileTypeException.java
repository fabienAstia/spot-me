package co.simplon.spotmebusiness.exceptions;

import co.simplon.spotmebusiness.controllers.CustomFieldError;
import co.simplon.spotmebusiness.controllers.CustomGlobalError;

import java.util.List;

public class FileTypeException extends RuntimeException {

	private String name;
	private String code;

	public FileTypeException() {
		this.name = "image";
		this.code = "FileType";
	}

}
