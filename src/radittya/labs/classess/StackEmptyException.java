package radittya.labs.classess;

public class StackEmptyException extends RuntimeException {
	public StackEmptyException() {
		super();
	}

	public StackEmptyException(String message) {
		super(message);
	}

	public StackEmptyException(String message, Throwable cause) {
		super(message, cause);
	}
}
