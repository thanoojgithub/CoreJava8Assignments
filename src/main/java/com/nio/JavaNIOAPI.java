package com.nio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaNIOAPI {

	public static void main(String[] args) throws IOException {
		long SIZE_5KB = (5 * 1024);
		String fileName = "C:\\Users\\thanooj\\OneDrive\\Documents\\GitHub\\CoreJava8Assignments\\src\\main\\resources\\JavaIOAPIFile.txt";
		List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		int count = lines.toString().getBytes().length / (5 * 1024);
		for (int i = 1; i <= count; i++) {
			String pathI = "C:\\Users\\thanooj\\OneDrive\\Documents\\GitHub\\CoreJava8Assignments\\src\\main\\resources\\JavaIOAPIFile"
					+ i + ".txt";
			byte[] bytes1 = {};
			long length = bytes1.length;
			for (String line : lines) {
				if (length < SIZE_5KB) {
					length += line.getBytes().length;
					BufferedWriter writer = new BufferedWriter(new FileWriter(pathI, true));
				    writer.append(line);
				}
			}
		}
	}
}
