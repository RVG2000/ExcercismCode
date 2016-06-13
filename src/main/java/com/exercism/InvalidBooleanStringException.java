package com.exercism;

public class InvalidBooleanStringException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidBooleanStringException(String string) {
		super(string);
	}
}
