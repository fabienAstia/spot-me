package co.simplon.spotmebusiness.exceptions;

public class FieldErrors extends RuntimeException {

	private String name;
	private String code;

	public FieldErrors(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public FieldErrors() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
