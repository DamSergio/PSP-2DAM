package tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6001;
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
			//cliente = new Socket(host, puerto);
			
			InetAddress ip2 = cliente.getInetAddress();
			//Puerto local
			System.out.println("Puerto local: " + cliente.getLocalPort());
			//Puerto remoto
			System.out.println("Puerto remoto: " + cliente.getPort());
			//IP servidor
			System.out.println("IP servidor: " + ip2.getHostAddress());
			//Nombre servidor
			System.out.println("Nombre servidor: " + ip2.getHostName());
			
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
