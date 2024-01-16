package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BinarioServior {

	public static void main(String[] args) {
		int puerto = 6000;
		//String host = "localhost";
		
		ServerSocket servidor;
		String binario = ""; 
		
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Escuchando...");
			
			Socket cliente = servidor.accept();
			System.out.println("Cliente aceptado");
			System.out.println("Cliente: " + cliente.getInetAddress());
			
			DataInputStream flujoEntrada = null;
			DataOutputStream flujoSalida = null;
			
			while (!binario.equals("0")) {
				//Flujo de entrada -> lee
				flujoEntrada = new DataInputStream(cliente.getInputStream());
				binario = Integer.toBinaryString(Integer.parseInt(flujoEntrada.readUTF()));
				
				//Flujo de salida al cliente -> escribe
				flujoSalida = new DataOutputStream(cliente.getOutputStream());
				//1. Envio al cliente
				if (binario.equals("0")) {
					flujoSalida.writeUTF(" ");
				} else {
					flujoSalida.writeUTF(binario);
				}
			}
			
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
