package chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileSource {

	public static void main(String[] args) throws IOException {
		String filePath = "resources/data.txt";
		FileSource source = new FileSource();
		long count = source.uniqueWords(filePath);
		System.out.println("Number of unique words in \"" + filePath + "\" = " + count);
	}
	
	public long uniqueWords(String filePath) throws IOException {
		long uniqueWords = Files.lines(Paths.get(filePath), Charset.defaultCharset())
				.flatMap(line -> Arrays.stream(line.split(" ")))
				.distinct()
				.count();
		
		return uniqueWords;
	}

}
