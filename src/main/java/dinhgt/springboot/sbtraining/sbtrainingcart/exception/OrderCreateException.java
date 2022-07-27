package dinhgt.springboot.sbtraining.sbtrainingcart.exception;

public class OrderCreateException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public OrderCreateException(String message, Throwable cause) {
		super(message, cause);

	}

	public OrderCreateException(String message) {
		super(message);

	}

	public OrderCreateException(Throwable cause) {
		super(cause);

	}
}
