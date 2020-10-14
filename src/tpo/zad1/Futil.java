package tpo.zad1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil 
{

	static void processDir(String dirName, String resultFileName)
	{
		try {
			Charset inputCharset = Charset.forName("Cp1250");
			Charset outputCharset = Charset.forName("UTF-8");
			FileChannel destination = FileChannel.open(Paths.get(resultFileName), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
			Files.walkFileTree(Paths.get(dirName), new SimpleFileVisitor<Path>(){

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException 
				{
					FileChannel otwartyPlik = FileChannel.open(file);
					ByteBuffer bb = ByteBuffer.allocateDirect(1024);
					while(otwartyPlik.read(bb) != -1)
					{
						bb.flip();
						CharBuffer decoded = inputCharset.decode(bb);
						bb = outputCharset.encode(decoded);
						destination.write(bb);
						bb.rewind();
					}
					otwartyPlik.close();
					return FileVisitResult.CONTINUE;
				}
			
			});
			destination.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
