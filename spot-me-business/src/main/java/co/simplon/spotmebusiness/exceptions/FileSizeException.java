package co.simplon.spotmebusiness.exceptions;

public class FileSizeException extends HandlerErrors {

	private String name;
	private String code;

	public FileSizeException() {
		this.name = "image";
		this.code = "FileSize";
	}
}
