package procesos;

import java.io.File;
import java.io.IOException;

public class LlamaCadenaFicheros {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java", "procesos.Cadena");
		pb.directory(new File(".\\bin"));
		
		pb.redirectInput(new File("cadena.txt"));
		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("error.txt"));
		
		Process p = pb.start();
	}

}
