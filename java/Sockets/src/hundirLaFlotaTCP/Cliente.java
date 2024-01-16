package hundirLaFlotaTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;
		
		Socket cliente = null;
		try {
			cliente = new Socket(host, puerto);
			
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());;
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
			
			String respuestaServidor = "";
			int barcosHundidos = 0;
			
			while (!respuestaServidor.contains("Intentos restantes: 0") && barcosHundidos < 10) {
				System.out.println("Dime unas coordenadas ej: 2,7");
				String coord = sc.next();
				
				flujoSalida.writeUTF(coord);
				
				respuestaServidor = flujoEntrada.readUTF();
				System.out.println(respuestaServidor);
				
				if (respuestaServidor.contains("HUNDIDO")) {
					barcosHundidos++;
				}
			}
			
			flujoEntrada = new DataInputStream(cliente.getInputStream());
			System.out.println(flujoEntrada.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
