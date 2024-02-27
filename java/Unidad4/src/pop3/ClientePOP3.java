package pop3;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

public class ClientePOP3 {

	public static void main(String[] args) {
		final String SERVER = "localhost";
		final String USER = "usu1";
		final String PASS = "usu1";
		final int PORT = 110;
		
		POP3SClient clientPOP = new POP3SClient();
		try {
			clientPOP.connect(SERVER, PORT);
			if (!clientPOP.login(USER, PASS)) {
				System.out.println("ERROR");
				return;
			}
			
			POP3MessageInfo mails[] = clientPOP.listMessages();
			if (mails == null) {
				System.out.println("ERROR");
				return;
			}
			
			System.out.println("Tienes " + mails.length + " mensaje/s");
			
			Recuperarmesajes(mails, clientPOP);
			
			clientPOP.logout();
			clientPOP.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void Recuperarmesajes(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {
		for (int i = 0; i < men.length; i++) {//
			// POP3MessageInfo msginfo : messages) {
			System.out.println("Mensaje: " + (i + 1));
			POP3MessageInfo msginfo = men[i]; // lista de mensajes
			System.out.println("IDentificador: " + msginfo.identifier + ", Number: " + msginfo.number + ", Tamaño: " + msginfo.size);
			System.out.println("Prueba de listUniqueIdentifier: ");
			POP3MessageInfo pmi = pop3.listUniqueIdentifier(i + 1);// un mensaje
			System.out.println("\tIDentificador: " + pmi.identifier + ", Number: " + pmi.number + ", Tamaño: " + pmi.size);
			// solo recupera cabecera
			System.out.println("Cabecera del mensaje:");
			BufferedReader reader = (BufferedReader) pop3.retrieveMessageTop(msginfo.number, 0);
			String line;
			while ((line = reader.readLine()) != null)
				System.out.println(line.toString());
			reader.close();
			// recupera todo
			BufferedReader reader2 = (BufferedReader) pop3.retrieveMessage(msginfo.number);
			String linea;
			while ((linea = reader2.readLine()) != null)
				System.out.println(linea.toString());

			reader2.close();
		}
	}//
}
