package ftp;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ClienteFTP {

	public static void main(String[] args) {
		try {
			FTPClient cliente = new FTPClient();
			String servidor = "localhost";
			System.out.println("Nos conectamos al servidor ftp " + servidor);
			
			String user = "usuario1";
			String psw = "usu1";
			String carpeta = "/sergio2";
			
			cliente.connect(servidor);
			
			boolean logged = cliente.login(user, psw);
			if (logged) {
				System.out.println("Usuario autenticado");
				System.out.println("El directorio actual es: " + cliente.printWorkingDirectory());
				
				cliente.makeDirectory(carpeta);
				cliente.changeWorkingDirectory(carpeta);
				System.out.println("El directorio actual es: " + cliente.printWorkingDirectory());
				
				//Listar ficheros
				String tipos[] = {"fichero", "directorio", "enlace"}; //getType devuelve el tipo de fichero: 0 = fichero / 1 = directorio / 2 = enlace
				FTPFile files[] = cliente.listFiles();
				for (FTPFile f : files) {
					System.out.println(f.getName() + " => Es del tipo: " + tipos[f.getType()]);
				}
				
				cliente.setFileType(FTP.BINARY_FILE_TYPE);
				BufferedInputStream in = new BufferedInputStream(new FileInputStream("silencio.txt"));
				
				if (cliente.storeFile("silencioNombreModificado.txt", in)) {
					System.out.println("Fichero subido");
				} else  {
					System.out.println("Error");
				}
				
				in.close();
				cliente.logout();
			} else  {
				System.out.println("Error");
			}
			cliente.disconnect();
//			System.out.println("Texto: " + cliente.getReplyString());
//			System.out.println("Codigo: " + cliente.getReplyCode());
		} catch (Exception e) {
			
		}
	}

}
