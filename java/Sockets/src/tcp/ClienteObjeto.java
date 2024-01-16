package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteObjeto {
	public static void main(String[] args) {
		String host = "localhost";
		int port = 6000;
		
		try {
			Socket cliente = new Socket(host, port);
			
			//Flujo de entrada para objetos
			ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());
			
			//2. Recibo el objeto del servidor
			Persona p = (Persona) input.readObject();
			System.out.println("Recibo: " + p);
			
			//Flujo de salida para objetos
			ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());
			
			//3. Modificamos el objetos
			p.setEdad(56);
			output.writeObject(p);
			//output.flush();
			
			//Cerrar
			input.close();
			output.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
