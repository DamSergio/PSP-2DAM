package hundirLaFlotaTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		int puerto = 6000;
		ServerSocket servidor;
		Tablero board = new Tablero();
		System.out.println(board.toString());
		
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Escuchando...");
			
			Socket cliente = servidor.accept();
			System.out.println("Cliente aceptado");
			System.out.println("Cliente: " + cliente.getInetAddress());
			
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
			
			while (board.getBarcos() > board.getBarcosEncontrados() && board.getIntentos() > 0) {
				String pos[] = flujoEntrada.readUTF().split(",");
				int row = Integer.parseInt(pos[0]);
				int col = Integer.parseInt(pos[1]);
				
				String msg = board.buscarCasilla(row, col) + "\nQuedan: " + (board.getBarcos() - board.getBarcosEncontrados() + "\nIntentos restantes: " + board.getIntentos());
				
				flujoSalida.writeUTF(msg);
			}
			
			flujoSalida = new DataOutputStream(cliente.getOutputStream());
			if (board.getIntentos() > 0) {
				flujoSalida.writeUTF("Ganastes");
			} else {
				flujoSalida.writeUTF("Perdistes");
			}
			
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
