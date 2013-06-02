package net.minecrell.permissionsx.api.module;

public class InvalidModuleException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidModuleException() {
	}

	public InvalidModuleException(final String message) {
		super(message);
	}

	public InvalidModuleException(final Throwable cause) {
		super(cause);
	}

	public InvalidModuleException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
