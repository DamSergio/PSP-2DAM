package numerosTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int port = 6000;
		
		Socket client = null;
		try {
			client = new Socket(host, port);
			
			ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(client.getInputStream());
			int num = 0;
			
			do {
				num = sc.nextInt();
				Numero n = new Numero(num);
				if (num == 0) {
					n = new Numero();
					output.writeObject(n);
					output.flush();
					
					continue;
				}
				
				output.writeObject(n);
				output.flush();
				
				Numero n2 = (Numero) input.readObject();
				
				System.out.println("Cuadrado: " + n2.getCuadrado());
				System.out.println("Cubo: " + n2.getCubo());
				
				//output.reset();
			} while (num != 0);
			
			input.close();
			output.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
