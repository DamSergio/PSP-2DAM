package wordle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
			// Me conecto al al servidor
			cliente = new Socket(host, puerto);
			
			int intentos = 6;
			
			//Flujo de salida al servidor
			PrintWriter fSalida = new PrintWriter(cliente.getOutputStream(), true);
			//Flujo de entrada del servidor
			BufferedReader fEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String respuestaServidor = "_____";
			
			// Se ejecuta mientras le queden intentos y lo que te devuelve el servidor no contiene el caracter '_'
			while (intentos > 0 && respuestaServidor.contains("_")) {
				String usuario = "";
				do {
					System.out.println("Dime una palabra de 5 letras");
					usuario = sc.next();
				} while (!usuario.matches("^[A-Z]{5}$")); // no sale del bucle hasta que lo que escribe el usuario es una palabra mayusculas de 5 letras
				
				//1. Le paso la palabra al hilo
				fSalida.println(usuario);
				
				respuestaServidor = fEntrada.readLine();
				System.out.println(respuestaServidor);
				
				if (respuestaServidor.contains("_")) {
					intentos--;
				}
			}
			
			if (intentos > 0) {
				System.out.println("Has ganado");
			} else {
				System.out.println("has perdido");
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
