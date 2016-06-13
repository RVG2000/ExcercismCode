package com.exercism;

public class Binary {

	private String inputString;

	public Binary(String input) {
		this.inputString = input;
	}

	public int getDecimal() throws InvalidBooleanStringException {
		int decimalResult = 0;
		int power = 0;
		String binaryString = inputString;
		while (binaryString.length() > 0) {
			char nChar = binaryString.charAt((binaryString.length()) - 1);
			if (nChar != '0' && nChar != '1')
				throw new InvalidBooleanStringException("Boolean String is invalid: " + inputString);
			if (decimalResult >= Integer.MAX_VALUE) {
				throw new InvalidBooleanStringException(
						"Input String too long to be represented in integer : " + inputString);
			}
			decimalResult += nChar * Math.pow(2, power++);
			binaryString = binaryString.substring(0, binaryString.length() - 1);
		}
		return decimalResult;
	}

	public static void main(String[] args) {

		String inputString = "11100";
		try {
			Binary binary = new Binary(inputString);
			System.out.println(binary.getDecimal());
		} catch (InvalidBooleanStringException e) {
			System.out.println(e);
		}
	}

}
