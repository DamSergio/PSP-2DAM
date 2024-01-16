 	package ejercicio2;

import java.io.File;
import java.io.IOException;

public class PrimoFicheros {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicio2.Primo");
		pb.directory(new File(".\\bin"));
		
		pb.redirectInput(new File("Nuevo documento de texto.txt"));
		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("error.txt"));
		
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
