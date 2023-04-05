package fileOps;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Service;

@Service
public class FileOperation {
	public static void write(Object obj, String filepath) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("obj.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(obj);
	}
	
	public void read() {
		
		
	}
}
