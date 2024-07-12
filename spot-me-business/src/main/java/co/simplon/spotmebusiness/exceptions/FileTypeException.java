package co.simplon.spotmebusiness.exceptions;

public class FileTypeException extends HandlerErrors {

	private String name;
	private String code;

	public FileTypeException() {
		this.name = "image";
		this.code = "FileType";
	}

}
