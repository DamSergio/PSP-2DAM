package SMTP;

import java.io.IOException;
import java.io.Writer;
import java.net.SocketException;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class ClienteSMTP {
	public static void main(String[] args) {
		SMTPClient cliente = new SMTPClient();
		try {
			cliente.connect("localhost");
			System.out.println(cliente.getReplyString());
			
			int responseCode = cliente.getReplyCode();
			if (!SMTPReply.isPositiveCompletion(responseCode)) {
				System.out.println("Error al conectar");
				cliente.disconnect();
				
				return;
			}
			
			cliente.login();
			
			String origen = "sergioballesterospsp@outlook.es";
			String destinatarios[] = {"sergio.ballesteroscedenilla@riberadeltajo.es", "mariaperez@riberadeltajo.es"};
			String asunto = "Prueba de SMTP JAVA";
			String msg = "Hola, a ver si llegas...";
			
//			if (!cliente.sendSimpleMessage(origen, destino, msg)) {
//				System.out.println("No se ha podido enviar");
//				cliente.disconnect();
//				
//				return;
//			}
//			
//			System.out.println("Mensaje enviado");
			
			// CABECERA
			SimpleSMTPHeader header = new SimpleSMTPHeader(origen, destinatarios[0], asunto);
			header.addCC(destinatarios[1]);
			
			// MAIL FROM
			cliente.setSender(origen);
			
			// RCPT TO
			cliente.addRecipient(destinatarios[0]);
			cliente.addRecipient(destinatarios[1]);
			
			// DATA
			Writer writer = cliente.sendMessageData();
			if (writer == null) {
				System.err.println("Error en el correo");
				return;
			}
			
			writer.write(header.toString());
			writer.write(msg);
			
			writer.close();
			
			if (!cliente.completePendingCommand()) {
				System.out.println("Fallo al enviar el correo");
				return;
			}
			
			System.out.println("Correo enviado");
			cliente.logout();
			cliente.disconnect();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
