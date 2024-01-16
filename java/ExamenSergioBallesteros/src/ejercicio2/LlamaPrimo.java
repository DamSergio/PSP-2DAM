package ejercicio2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamaPrimo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicio2.Primo");
		pb.directory(new File(".\\bin"));
		
		try {
			Process p = pb.start();
			
			OutputStream os = p.getOutputStream();
			os.write((num + "\n").getBytes());
			os.flush();
			
			InputStream is = p.getInputStream();
			int c;
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
