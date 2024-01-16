package pruebaUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		byte buffer[] = new byte[1024];
		try {
			DatagramSocket socket = new DatagramSocket(12345);
			System.out.println("Esperando datagrama...");
			
			//2. Recibimos el datagrama de cliente
			DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
			socket.receive(recibo);
			
			//3. Mostramos la informacion del datagrama
			String msg = new String(recibo.getData()).trim().toLowerCase();
			System.out.println("Enviado desde el puerto: " + recibo.getPort());
			System.out.println("Ip de origen: " + recibo.getAddress().getHostAddress());
			System.out.println("Nombre del host de origen: " + recibo.getAddress().getHostName());
			System.out.println("Mensaje: " + msg);
			
			int numeroDeA = 0;
			for (int i = 0; i < msg.length(); i++) {
				if (msg.charAt(i) == 'a') {
					numeroDeA++;
				}
			}
			
			byte byteMsg[] = new byte[1024];
			String nuevoMsg = numeroDeA + "";
			byteMsg = nuevoMsg.getBytes();
			
			InetAddress ip = recibo.getAddress();
			
			DatagramPacket envio = new DatagramPacket(byteMsg, nuevoMsg.length(), ip, recibo.getPort());
			
			socket.send(envio);
			
			socket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
