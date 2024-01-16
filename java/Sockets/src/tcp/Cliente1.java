package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente1 {

	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6002;
		InetAddress ip = null;
		try {
			ip = InetAddress.getByName("192.168.21.100");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Socket cliente;
		
		try {
			cliente = new Socket(ip, puerto);
			
			//Flujo de salida al servidr -> escribe
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
			
			//Flujo de entrada -> lee
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
			//2. Leo el mensaje
			String salida = flujoEntrada.readUTF();
			System.out.println("Recibo del servidor: " + salida);
			
			//Cerrar streams y sockets
			flujoSalida.close();
			flujoEntrada.close();
			cliente.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
