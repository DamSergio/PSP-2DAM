package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorObjeto {
	public static void main(String[] args) {
		int port = 6000;
		
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("Servidor esperando...");
			
			Socket cliente = server.accept();
			System.out.println("Cliente aceptado");
			
			//Flujo de salida para objetos
			ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());
			
			//1. Enviamos un objeto al cliente
			Persona p = new Persona("Luisa", 22);
			output.writeObject(p);
			output.flush();
			
			//Flujo de entrada para objetos
			ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());
			
			//4. Recibimos el objeto modificado
			Persona p2 = (Persona) input.readObject();
			System.out.println("Recibido modificado: " + p2);
			
			//Cerrar
			input.close();
			output.close();
			cliente.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
