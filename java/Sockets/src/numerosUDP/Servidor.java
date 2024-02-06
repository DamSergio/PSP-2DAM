package numerosUDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
	static final int PORT = 9876;
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {
            DatagramSocket socket = new DatagramSocket(PORT);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer));
                Numero numeros = (Numero) in.readObject();

                int numero = numeros.getNumero();
                if (numero <= 0) {
                    break;
                }

                Numero resultado = new Numero(numero);
                resultado.setCuadrado((long) numero * numero);
                resultado.setCubo((long) numero * numero * numero);

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(bos);
                out.writeObject(resultado);

                byte[] sendBuffer = bos.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());

                socket.send(sendPacket);
            }

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

}
