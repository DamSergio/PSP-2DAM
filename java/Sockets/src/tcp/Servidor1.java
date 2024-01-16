package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor1 {

	public static void main(String[] args) {
		int puerto = 6000;
		String host = "localhost";
		
		ServerSocket servidor;
		
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Escuchando...");
			
			Socket cliente = servidor.accept();
			System.out.println("Cliente aceptado");
			System.out.println("Cliente: " + cliente.getInetAddress());
			
			//Flujo de salida al cliente -> escribe
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
			//1. Envio al cliente
			flujoSalida.writeUTF("Hola desde el servidor!!!");
			
			//Flujo de entrada -> lee
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
			
			
			//cerramos streams y sockets
			flujoSalida.close();
			flujoEntrada.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
