package himedia.myportal.exceptions;

//	RuntimeException보다 구체적인 예외
public class MainControllerException extends RuntimeException {
	public MainControllerException() {
		super("MainControllerException occurs;;");
	}
	
	public MainControllerException(String message) {
		super(message);
	}
}
