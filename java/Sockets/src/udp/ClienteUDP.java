package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUDP {
	public static void main(String[] args) {
		int puerto = 12345; // puerto por el que escucha el servidor
		
		try {
			InetAddress ipDestino = InetAddress.getLocalHost(); // para enviarlo por la red: InetAddress.getByName("192.168.21.100")
			byte mensaje[] = new byte[1024];
			
			String saludo = "Hola Servidor! Soy el Cliente";
			mensaje = saludo.getBytes();
			
			//1. Creo el datagrama y el socket
			DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, ipDestino, puerto);
			DatagramSocket socket = new DatagramSocket(34567); // puerto del cliente por el que sale el datagrama
			
			socket.send(envio);
			
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
