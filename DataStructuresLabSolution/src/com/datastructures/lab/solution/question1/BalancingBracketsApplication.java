package com.datastructures.lab.solution.question1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BalancingBracketsApplication {

	private static List<Character> OPENING_BRACKETS = Arrays.asList('(', '[', '{');

	public static void main(String[] args) {

		Scanner inputScan = new Scanner(System.in);
		System.out.println("Enter the input String\r\n");
		String inputString = inputScan.nextLine();
		if (areBracketsBalanced(inputString)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		inputScan.close();
	}

	private static boolean areBracketsBalanced(final String inputString) {
		if (inputString.length() == 0 || inputString.length() % 2 != 0)
			return false;
		Stack<Character> openingBracketStack = new Stack<>();
		for (int i = 0; i < inputString.length(); i++) {
			char checkChar = inputString.charAt(i);

			if (OPENING_BRACKETS.contains(checkChar)) {
				openingBracketStack.push(checkChar);
				continue;
			}

			if (openingBracketStack.isEmpty())
				return false;

			char checkInStack;
			switch (checkChar) {
			case ')':
				checkInStack = openingBracketStack.pop();
				if (checkOpeningBracket(checkInStack, '{', '['))
					return false;
				break;
			case '}':
				checkInStack = openingBracketStack.pop();
				if (checkOpeningBracket(checkInStack, '(', '['))
					return false;
				break;
			case ']':
				checkInStack = openingBracketStack.pop();
				if (checkOpeningBracket(checkInStack, '{', '('))
					return false;
				break;
			}
		}
		return openingBracketStack.isEmpty();
	}

	private static boolean checkOpeningBracket(final char checkChar, final char input1, final char input2) {
		return (checkChar == input1 || checkChar == input2);
	}

}
