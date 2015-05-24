package org.fahai.thinkinginjava.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * read from memory files
 * @author fahai
 *
 */
public class MemoryInput {

	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(BufferedInputFile.read("./src/org/fahai/thinkinginjava/io/MemoryInput.java"));
		int c = 0;
		while((c=in.read()) != -1){
			System.out.print((char)c);
		}
	}

}
