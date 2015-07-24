package radittya.labs.classess;

public class StackOverflowException extends RuntimeException {
	public StackOverflowException() {
		super();
	}

	public StackOverflowException(String message) {
		super(message);
	}

	public StackOverflowException(String message, Throwable cause) {
		super(message, cause);
	}
}

