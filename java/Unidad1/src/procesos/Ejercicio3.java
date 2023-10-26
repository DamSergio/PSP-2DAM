package procesos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DATE");
		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		os.write("2-10-2023".getBytes());
		os.flush();
		os.close();
		
		InputStream is = p.getInputStream();
		int c = 0;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
	}

}
