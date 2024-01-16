package tcpHilos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread{
	private Socket cliente;
	private BufferedReader fEntrada;
	private PrintWriter fSalida;

	public HiloServidor(Socket cliente){
		super();
		this.cliente = cliente;
		
		try {
			this.fSalida = new PrintWriter(cliente.getOutputStream(), true);
			this.fEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		} catch (IOException e) {
			System.err.println("Error de E/S");
		}
	}
	
	public void run() {
		try {
			String cadena = "";
			while (!cadena.equals("*")) {
				cadena = fEntrada.readLine();
				if (cadena.equals("*")) {
					continue;
				}
				
				String cadenaMayusculas = cadena.trim().toUpperCase();
				fSalida.println(cadenaMayusculas);
			}
			
			fEntrada.close();
			cliente.close();
			fSalida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Socket getCliente() {
		return cliente;
	}

	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}
}
