package numerosUDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	private final static int SERVER_PORT = 9876;
	
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		try {
            DatagramSocket socket = new DatagramSocket();

            while (true) {
                System.out.print("Introduce un número: ");
                int numero = sc.nextInt();
                
                Numero numeros = new Numero(numero);

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(bos);
                out.writeObject(numeros);
                
                byte[] buffer = bos.toByteArray();

                InetAddress serverAddress = InetAddress.getByName("localhost");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, SERVER_PORT);

                socket.send(packet);
                
                if (numero <= 0) {
                    break;
                }

                // Recibir la respuesta del servidor
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(receiveBuffer));
                Numero resultado = (Numero) in.readObject();

                System.out.println("Cuadrado: " + resultado.getCuadrado());
                System.out.println("Cubo: " + resultado.getCubo());
            }

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

}
