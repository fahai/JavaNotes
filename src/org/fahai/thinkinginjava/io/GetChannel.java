package org.fahai.thinkinginjava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.imageio.stream.FileImageInputStream;

public class GetChannel {

	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception {
		// Write files
		FileChannel fc = new FileOutputStream("./log/log.out").getChannel();
		fc.write(ByteBuffer.wrap("write by FileChannel".getBytes()));
		fc.close();
		
		// add to the end of file
		fc = new RandomAccessFile("./log/log.out", "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("write by RandomAccessFile Channel".getBytes()));
		fc.close();
		
		// read the files
		fc = new FileInputStream("./log/log.out").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		while(buff.hasRemaining()){
			System.out.print((char)buff.get());
		}
	}

}
