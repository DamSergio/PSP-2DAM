package multiCast;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ServidorMulticast extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static MulticastSocket ms=null;
	static byte[] buf = new byte[1000];
	static InetAddress grupo = null;
	static int Puerto = 12345;//Puerto multicast
	
	static JTextField mensaje = new JTextField();

	private JScrollPane scrollpane1;
	static JTextArea textarea1;
	JButton boton = new JButton("Enviar");
	JButton desconectar = new JButton("Salir");
	boolean repetir = true;

	// constructor
	public ServidorMulticast () {
		super(" SERVIDOR MULTICAST");
		setLayout(null);

		mensaje.setBounds(10, 10, 400, 30);
		add(mensaje);

		textarea1 = new JTextArea();
		scrollpane1 = new JScrollPane(textarea1);
		scrollpane1.setBounds(10, 50, 400, 300);
		add(scrollpane1);
		boton.setBounds(420, 10, 100, 30);
		add(boton);
		desconectar.setBounds(420, 50, 100, 30);
		add(desconectar);

		textarea1.setEditable(false);
		boton.addActionListener(this);
		desconectar.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
	}// fin constructor

	// accion cuando pulsamos botones
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton) { // SE PULSA EL ENVIAR
			textarea1.append("Enviando>> ");
			textarea1.append(mensaje.getText()+"\n");
			String texto=mensaje.getText();
			try {
				
				// ENVIANDO AL GRUPO
				DatagramPacket paquete = new DatagramPacket
				    (texto.getBytes(), texto.length(), grupo, Puerto);
			    ms.send (paquete); 
			  mensaje.setText("");   
   
			} catch (IOException e1) {
				e1.printStackTrace();
			
			}
		}
		if (e.getSource() == desconectar) { // SE PULSA DESCONECTAR			
			 ms.close (); 
			 repetir=false;
			 System.out.println ("Servidor multicast cerrado...");	
			 System.exit(0);
		}
		
	}//
	
	

	public static void main(String args[]) throws IOException {		
		 ms = new MulticastSocket();  		
		 grupo = InetAddress.getByName("225.0.0.1");//Grupo
		  //ms.joinGroup (grupo);    
	   	 ServidorMulticast server = new ServidorMulticast ();
		 server.setBounds(0, 0, 540, 400);
		 server.setVisible(true);
	
			
		
	}//main
}// ..ClienteChat

