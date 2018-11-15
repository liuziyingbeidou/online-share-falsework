package com.venux.exception;

public class NotFoundException extends RuntimeException {
	public NotFoundException(int i, String s) {
		super(s);
	}
}
