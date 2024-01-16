package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		int puerto = 6000;
		String host = "localhost";
		
		ServerSocket servidor;
		
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Escuchando...");
			
			Socket cliente = servidor.accept();
			System.out.println("Cliente aceptado");
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
