package ftpRecursivo;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class DirectorioRecursivo {
	public static int nivel = 0;

	public static void main(String[] args) {
		try {
			FTPClient cliente = new FTPClient();
			String servidor = "localhost";
			
			String user = "usuario1";
			String psw = "usu1";
			
			cliente.connect(servidor);
			boolean logged = cliente.login(user, psw);
			if (!logged) {
				System.out.println("Usuario/contraseña incorrectos");
				return;
			}
			System.out.println("Usuario autenticado");
			System.out.println("El directorio padre es: " + cliente.printWorkingDirectory());
			
			directorios(cliente);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void directorios(FTPClient cliente) {
		try {
			FTPFile files[] = cliente.listFiles();
			for (FTPFile f : files) {
				if (f.getType() == 1) {
					cliente.changeWorkingDirectory(f.getName());
					
					nivel++;
					for (int i = 0; i < nivel; i++) {
						System.out.print("\t");
					}
					System.out.println("↳" + f.getName());
					
					directorios(cliente);
				}
			}
			
			nivel--;
			cliente.changeWorkingDirectory("../");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
