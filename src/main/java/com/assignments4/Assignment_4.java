package com.assignments4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment_4 {

	static final Logger LOGGER = LoggerFactory.getLogger(Assignment_4.class);
	
	public static void main(String[] args) {
		String precedingWithEorO = precedingWithEorO(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		LOGGER.info("precedingWithEorO : {}",precedingWithEorO); // o1,e2,o3,e4,o5,e6,o7,e8,o9
	}

	public static String precedingWithEorO(List<Integer> list) {
		String collect = list.stream().map(n -> (n % 2 == 0) ? "e".concat(n.toString()) : "o".concat(n.toString()))
				.collect(Collectors.joining(","));
		return collect;
	}

}
