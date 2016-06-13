package com.exercism;

public class InvalidRobotNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidRobotNameException(String string) {
		super(string);
	}
}
