package wordle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread{
	private Socket cliente;
	private BufferedReader fEntrada;
	private PrintWriter fSalida;
	private String palabraSecreta;
	
	public HiloServidor(Socket cliente, String palabra){
		super();
		this.cliente = cliente;
		
		try {
			this.fSalida = new PrintWriter(cliente.getOutputStream(), true);
			this.fEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		} catch (IOException e) {
			System.err.println("Error de E/S");
		}
		
		this.palabraSecreta = palabra;
	}
	
	public void run() {
		int intentos = 6;
		
		try {
			String cadena = "";
			while (intentos > 0 && !cadena.equals(palabraSecreta)) { // ejecuto hasta que no queden intentos o haya adivinado la palabra
				//2. recibo la palabra del cliente
				cadena = fEntrada.readLine();
				String salida = "";
				
				for (int i = 0; i < 5; i++) {
					if (cadena.charAt(i) == palabraSecreta.charAt(i)) {
						salida += cadena.charAt(i);
					} else {
						salida += "_";
					}
				}
				
				intentos--;
				fSalida.println(salida);
			}
			
			fEntrada.close();
			cliente.close();
			fSalida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
