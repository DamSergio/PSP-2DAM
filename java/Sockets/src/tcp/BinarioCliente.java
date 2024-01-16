package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class BinarioCliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;
		
		Socket cliente = null;
		
		try {
			String num = "";
			cliente = new Socket(host, puerto);
			
			DataOutputStream flujoSalida = null;
			DataInputStream flujoEntrada = null;
			
			while (!num.equals("0")) {
				num = sc.next();
				
				//Flujo de salida al servidr -> escribe
				flujoSalida = new DataOutputStream(cliente.getOutputStream());
				flujoSalida.writeUTF(num);
				
				//Flujo de entrada -> lee
				flujoEntrada = new DataInputStream(cliente.getInputStream());
				//2. Leo el mensaje
				String msg = flujoEntrada.readUTF();
				System.out.println("Recibo del servidor: " + msg);
			}
			flujoSalida.close();
			flujoEntrada.close();
			
			//Cerrar streams y sockets
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
