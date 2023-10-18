package binario;

import java.io.File;
import java.io.IOException;

public class LlamaBinarioFicheros {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java", "binario.Binario");
		pb.directory(new File(".\\bin"));
		
		pb.redirectInput(new File("numero.txt"));
		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("error.txt"));
		
		Process p = pb.start();
	}

}
