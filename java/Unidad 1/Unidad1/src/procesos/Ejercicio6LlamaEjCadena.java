package procesos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio6LlamaEjCadena {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File workspace = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "procesos.Ejercicio5Cadena");
		pb.directory(workspace);
		try {
			Process p = pb.start();
			
			OutputStream name = p.getOutputStream();
			String namee = sc.next() + "\n";
			name.write(namee.getBytes());
			name.flush();
			
			InputStream is = p.getInputStream();
			int c = 0;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
