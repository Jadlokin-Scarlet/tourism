package com.tourism.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ServletRequestOutOfBoundsException extends Exception {

	public ServletRequestOutOfBoundsException() {
		super();
	}

	public ServletRequestOutOfBoundsException(String message) {
		super(message);
	}
}
