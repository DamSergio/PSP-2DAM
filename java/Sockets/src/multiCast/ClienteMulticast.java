package multiCast;

import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class ClienteMulticast extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;
	static MulticastSocket ms=null;
	static byte[] buf = new byte[1000];
	static InetAddress grupo = null;
	static int Puerto = 12345;//Puerto multicast	
	
	String nombre;
	

	private JScrollPane scrollpane1;
	static JTextArea textarea1;
	JButton boton = new JButton("Enviar");
	JButton desconectar = new JButton("Salir");
	boolean repetir = true;

	// constructor
	public ClienteMulticast (String nombre, MulticastSocket ms2, InetAddress grupo2) {
		super(" CONEXI�N DEL CLIENTE MULTICAST: " + nombre);
		setLayout(null);
		ms=ms2;
		grupo=grupo2;
		
		textarea1 = new JTextArea();
		scrollpane1 = new JScrollPane(textarea1);
		scrollpane1.setBounds(10, 10, 400, 300);
		add(scrollpane1);		
		
		desconectar.setBounds(420, 50, 100, 30);
		add(desconectar);

		textarea1.setEditable(false);
		boton.addActionListener(this);
		desconectar.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
		this.nombre = nombre;
		
	}// fin constructor

	// accion cuando pulsamos botones
	public void actionPerformed(ActionEvent e) {	
		if (e.getSource() == desconectar) { // SE PULSA DESCONECTAR	    
			 try {
				ms.leaveGroup (grupo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 ms.close (); 
			 System.out.println ("Socket CLIENTE MULTICAST cerrado...");
			 System.exit(0);						
		}
	}//

	//
	public void run() {		
		while (repetir) {	
				buf = new byte[1000];
				DatagramPacket paquete = new DatagramPacket(buf, buf.length);
			    try {
					ms.receive(paquete); //recibo algo del servidor
			
					
				} catch (IOException e) {
					System.out.println(e.getMessage());					
					System.exit(0);
				}
				String msg = new String(paquete.getData());
				System.out.println ("Recibo cliente: " + msg.trim());	
				textarea1.append("Recibiendo >> ");
				textarea1.append(msg.trim());				
				textarea1.append("\n");		
		}//while
			
	}// ejecutar

	public static void main(String args[]) throws IOException {
	
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");		
	    //Se crea el socket multicast 
		MulticastSocket ms = new MulticastSocket(Puerto);
		InetAddress grupo=InetAddress.getByName("225.0.0.1");//Grupo	    
	    //Nos unimos al grupo
	    ms.joinGroup (grupo);    
		
		if (!nombre.trim().equals("")) {
			ClienteMulticast  cliente = new ClienteMulticast (nombre, ms, grupo);
			cliente.setBounds(0, 0, 540, 400);
			cliente.setVisible(true);
			new Thread(cliente).start();
			
		} else {
			System.out.println("El nombre est� vac�o....");
		}
	}//main
}// ..ClienteChat



