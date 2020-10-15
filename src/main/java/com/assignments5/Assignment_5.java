package com.assignments5;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment_5 {

	static final Logger LOGGER = LoggerFactory.getLogger(Assignment_5.class);

	public static void main(String[] args) {

		IsOdd isOdd = (n) -> n % 2 != 0;
		IsPrime isPrime = (n) -> n > 2 && IntStream.rangeClosed(2, n - 1).noneMatch(n1 -> (n % n1 == 0));
		IsPalindrome ispalindrome = (num) -> {
			int reversedInteger = 0, remainder = 0, originalInteger = 0;
			originalInteger = num;
			while (num != 0) {
				remainder = num % 10;
				reversedInteger = reversedInteger * 10 + remainder;
				num /= 10;
			}
			if (originalInteger == reversedInteger)
				return true;
			else
				return false;
		};
		int[] intArry = IntStream.rangeClosed(11, 33).toArray();
		for (int n : intArry) {
			LOGGER.info("is {} Odd number : {}", n, isOdd.isOdd(n));
			LOGGER.info("is {} Prime number : {}", n, isPrime.isPrime(n));
			LOGGER.info("is {} Palindrome : {}", n, ispalindrome.isPalindrome(n));
		}
	}

}

/**
 * Functional Interface - Single Abstract Method (SAM) A lambda expression can
 * be used through a functional interface in Java 8
 */
@FunctionalInterface
interface IsOdd {
	boolean isOdd(Integer i);
}

@FunctionalInterface
interface IsPalindrome {
	boolean isPalindrome(int str);
}

@FunctionalInterface
interface IsPrime {
	boolean isPrime(int i);
}
