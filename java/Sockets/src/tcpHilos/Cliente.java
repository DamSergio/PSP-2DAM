package tcpHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String host = "localhost";
		int puerto = 6000;
		
		Socket cliente;
		
		try {
			cliente = new Socket(host, puerto);
			
			//Flujo de salida al servidor
			PrintWriter fSalida = new PrintWriter(cliente.getOutputStream(), true);
			//Flujo de entrada del servidor
			BufferedReader fEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
			System.out.println("Dame un texto: ");
			String cadena = " ";
			
			while(!cadena.equals("*")) {
				cadena = sc.nextLine();
				// envio la cadena al hilo
				fSalida.println(cadena);
				
				if (cadena.equals("*")) {
					continue;
				}
				// recibo la cadena
				String cadenaMayusculas = fEntrada.readLine();
				System.out.println(cadenaMayusculas);
			}
			
			fSalida.close();
			fEntrada.close();
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
