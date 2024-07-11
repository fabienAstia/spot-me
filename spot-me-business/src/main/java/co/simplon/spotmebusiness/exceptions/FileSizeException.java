package co.simplon.spotmebusiness.exceptions;

public class FileSizeException extends FieldErrors {

	private String name;
	private String code;

	public FileSizeException() {
		this.name = "image";
		this.code = "FileSize";
	}
}
