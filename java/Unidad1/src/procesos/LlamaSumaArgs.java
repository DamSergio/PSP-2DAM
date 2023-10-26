package procesos;

import java.io.File;
import java.io.IOException;

public class LlamaSumaArgs {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java", "procesos.SumaArgs", "10", "10");
		pb.directory(new File(".\\bin"));
		
		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("error.txt"));
		
		Process p = pb.start();
	}

}
