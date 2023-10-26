package procesos;

import java.io.IOException;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
		try {
			Process p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
