package com.exercism;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Robot {

	private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final Set<String> usedNames = new HashSet();
	private static final int MAX_NO_NAME = 676000;

	private String name;

	public String getName() {
		if (name == null) {
			do {
				if (usedNames.size() >= MAX_NO_NAME) {
					throw new InvalidRobotNameException(
							"All the robot names have used for the 5 letter naming convention. Please initialize robot again");
				}
				name = generateName();
			} while (usedNames.contains(name));
			usedNames.add(name);
		}
		return name;
	}

	public void reset() {
		name = null;
	}

	public void initialize() {
		name = null;
		usedNames.clear();
	}

	private String generateName() {
		StringBuilder builder = new StringBuilder(5);
		for (int alpha = 0; alpha < 2; alpha++) {
			builder.append(ALPHABETS.charAt(getRandon(0, 25)));
		}
		for (int alpha = 0; alpha < 3; alpha++) {
			builder.append(getRandon(0, 9));
		}
		return builder.toString();
	}

	private int getRandon(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static void main(String[] args) {
		Robot robot = new Robot();
		try {
			System.out.println(robot.getName());
		} catch (InvalidRobotNameException e) {
			System.out.println(e);
		}
	}

}
