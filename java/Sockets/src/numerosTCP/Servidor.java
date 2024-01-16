package numerosTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		int port = 6000;
		
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(port);
			System.out.println("Esperando cliente...");
			
			client = server.accept();
			System.out.println("Cliente aceptado.");
			
			Numero n = null;
			ObjectInputStream input = new ObjectInputStream(client.getInputStream());
			ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
			
			do {
				n = (Numero) input.readObject();
				
				if (n.getNumero() == 0) {
					continue;
				}
				
				n.setCuadrado((long) Math.pow(n.getNumero(), 2));
				n.setCubo((long) Math.pow(n.getNumero(), 3));
				
				output.writeObject(n);
				output.flush();
				//output.reset();
			} while (n.getNumero() != 0);
			
			input.close();
			output.close();
			client.close();
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
