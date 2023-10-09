package procesos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejercicio4 {
	public static void main(String[] args) throws IOException {
		File workspace = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "procesos.Ejercicio1");
		pb.directory(workspace);
		Process p = pb.start();
		
		InputStream err = p.getErrorStream();
		int e = 0;
		while ((e = err.read()) != -1) {
			System.out.print((char) e);
		}
		err.close();
	}
}