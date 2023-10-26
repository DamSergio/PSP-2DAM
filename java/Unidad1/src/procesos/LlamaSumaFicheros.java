package procesos;

import java.io.File;
import java.io.IOException;

public class LlamaSumaFicheros {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java", "procesos.Suma");
		pb.directory(new File(".\\bin"));
		
		pb.redirectInput(new File("numeros.txt"));
		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("error.txt"));
		
		Process p = pb.start();
	}

}
