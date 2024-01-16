package pruebaUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int puerto = 12345; // puerto por el que escucha el servidor
		
		try {
			InetAddress ipDestino = InetAddress.getLocalHost(); // para enviarlo por la red: InetAddress.getByName("192.168.21.100")
			byte mensaje[] = new byte[1024];
			
			String saludo = sc.nextLine();
			mensaje = saludo.getBytes();
			
			//1. Creo el datagrama y el socket
			DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, ipDestino, puerto);
			DatagramSocket socket = new DatagramSocket(34567); // puerto del cliente por el que sale el datagrama
			
			socket.send(envio);
			
			byte buffer[] = new byte[1024];
			DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
			
			socket.receive(recibo);
			
			String msg = new String(recibo.getData()).trim();
			System.out.println("hay " + msg + " a");
			
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
