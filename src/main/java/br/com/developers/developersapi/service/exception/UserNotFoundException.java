package br.com.developers.developersapi.service.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5839901915727977421L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
