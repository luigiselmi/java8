package chapter5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileSource {

	public static void main(String[] args) throws IOException, URISyntaxException {
		String filePath = "data.txt";	
		FileSource source = new FileSource();
		long count = source.countUniqueWords(filePath);
		System.out.println("Number of unique words in \"" + filePath + "\" = " + count);
	}
	
	public long countUniqueWords(String filePath) throws IOException, URISyntaxException {
	  URI uri = getClass().getClassLoader().getResource(filePath).toURI();
		long numUniqueWords = Files.lines(Paths.get(uri))
				.flatMap(line -> Arrays.stream(line.split(" ")))
				.distinct()
				.count();
		
		return numUniqueWords;
	}

}
