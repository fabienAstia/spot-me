package co.simplon.spotmebusiness.exceptions;

public class GlobalErrors extends RuntimeException {

	public GlobalErrors(String message) {
		super(message);
	}

	public GlobalErrors() {
		super("SpotUnique");
	}

}
