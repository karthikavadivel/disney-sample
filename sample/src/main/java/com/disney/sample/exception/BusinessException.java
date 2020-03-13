package com.disney.sample.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 5464674272010206696L;

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}
}
