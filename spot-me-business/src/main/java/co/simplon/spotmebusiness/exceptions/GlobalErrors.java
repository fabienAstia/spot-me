package co.simplon.spotmebusiness.exceptions;

public class  GlobalErrors extends RuntimeException {

	String code;

	public GlobalErrors() {
		super("SpotUnique");
//		code = "SpotUnique";
	}

//	public GlobalErrors(String code) {
//		this.code = code;
//	}
}
