package com.nio;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class JavaNIOAPIone {

	public static void main(String[] args) {

		List<String> lines = Arrays.asList("1st line", "2nd line");

		final OpenOption[] options = { StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW,
				StandardOpenOption.SPARSE };
		final Path hugeFile = Paths.get("hugefile.txt");
		SeekableByteChannel channel = null;
		try {
			channel = Files.newByteChannel(hugeFile, options);
			channel.position(1L);
		} catch (IOException e1) {
			if (null != channel) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			e1.printStackTrace();
		}
		try {
			Files.write(Paths.get("file6.txt"), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
