package wordle;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		ServerSocket servidor;
		String []palabras= {"PLATO","PISAR","PLANO","MAREO","LISTA","LISTO",
				"SUCIO","PERRO","MIXTO","BULTO","CASTO","PRADO","MOSCA","PISTO",
				"TURCO","BRAVO","VISTO","QUESO","GUISO","USADO"};
		int random = (int)(Math.random() * 20);
		String palabraSecreta = palabras[random];
		
		try {
			servidor = new ServerSocket(6000);
			System.out.println("Servidor iniciado");
			
			while (true) {
				Socket cliente = servidor.accept();
				HiloServidor h = new HiloServidor(cliente, palabraSecreta);
				h.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
