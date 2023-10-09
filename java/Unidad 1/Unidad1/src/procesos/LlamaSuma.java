package procesos;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class LlamaSuma {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java", "procesos.Suma");
		pb.directory(new File(".\\bin"));
		
		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("error.txt"));
		
		Process p = pb.start();
		
		OutputStream writer = p.getOutputStream();
		writer.write("6\n".getBytes());
		writer.write("18\n".getBytes());
		writer.flush();
	}

}
