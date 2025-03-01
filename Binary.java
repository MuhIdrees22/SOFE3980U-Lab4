package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 */
public class Binary {
	private String number = "0";  // string containing the binary value '0' or '1'

	/**
	 * A constructor that generates a binary object.
	 *
	 * @param number a String of binary values. It should contain only zeros or ones. Otherwise, it defaults to "0".
	 *               Leading zeros are removed, and an empty string is considered "0".
	 */
	public Binary(String number) {
		if (number == null || number.isEmpty() || !number.matches("[01]+")) {
			this.number = "0"; // Default to "0" for null, empty, or invalid input
			return;
		}

		// Remove leading zeros
		this.number = number.replaceFirst("^0+(?!$)", "");
	}

	/**
	 * Return the binary value of the variable.
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue() {
		return this.number;
	}

	/**
	 * Adding two binary numbers.
	 *
	 * @param num1 The first binary number
	 * @param num2 The second binary number
	 * @return A binary variable with a value of num1 + num2
	 */
	public static Binary add(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		int carry = 0;
		StringBuilder num3 = new StringBuilder();

		while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
			int sum = carry;
			if (ind1 >= 0) sum += num1.number.charAt(ind1--) - '0';
			if (ind2 >= 0) sum += num2.number.charAt(ind2--) - '0';

			carry = sum / 2;
			num3.insert(0, sum % 2);
		}

		return new Binary(num3.toString());
	}

	/**
	 * Multiplying two binary numbers.
	 *
	 * @param num1 The first binary number
	 * @param num2 The second binary number
	 * @return A binary variable with a value of num1 * num2
	 */
	public static Binary multiply(Binary num1, Binary num2) {
		int result = Integer.parseInt(num1.number, 2) * Integer.parseInt(num2.number, 2);
		return new Binary(Integer.toBinaryString(result));
	}

	/**
	 * Bitwise AND operation between two binary numbers.
	 *
	 * @param num1 The first binary number
	 * @param num2 The second binary number
	 * @return A binary variable with a value of num1 & num2
	 */
	public static Binary and(Binary num1, Binary num2) {
		int result = Integer.parseInt(num1.number, 2) & Integer.parseInt(num2.number, 2);
		return new Binary(Integer.toBinaryString(result));
	}

	/**
	 * Bitwise OR operation between two binary numbers.
	 *
	 * @param num1 The first binary number
	 * @param num2 The second binary number
	 * @return A binary variable with a value of num1 | num2
	 */
	public static Binary or(Binary num1, Binary num2) {
		int result = Integer.parseInt(num1.number, 2) | Integer.parseInt(num2.number, 2);
		return new Binary(Integer.toBinaryString(result));
	}
}
