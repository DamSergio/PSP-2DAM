package binario;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamaBinario {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		ProcessBuilder pb = new ProcessBuilder("java", "binario.Binario");
		pb.directory(new File(".\\bin"));
		
		Process p = pb.start();
		
		//esto para mandarle cosas al programa
		OutputStream os = p.getOutputStream();
		os.write((sc.next() + "\n").getBytes());
		os.flush();
		
		//esto para ver lo que devuelve el programa
		InputStream is = p.getInputStream();
		int c = 0;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
		
		//esto si el programa devuelve un error
		InputStream err = p.getErrorStream();
		int e = 0;
		while ((e = err.read()) != -1) {
			System.out.print((char) e);
		}
		err.close();
	}

}
