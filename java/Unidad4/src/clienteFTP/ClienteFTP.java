package clienteFTP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JPasswordField;

public class ClienteFTP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtServer;
	private JTextField txtUser;
	private JPasswordField txtPsw;
	private FTPClient client;
	private boolean loggedIn;
	private JList listDir;
	private DefaultListModel<String> model;
	private JButton btnLoad;
	private JButton btnDownload;
	private JButton btnDel;
	private JButton btnMkdir;
	private JButton btnRm;
	private JButton btnClose;
	private FTPFile files[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteFTP frame = new ClienteFTP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteFTP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtServer = new JTextField();
		txtServer.setText("localhost");
		txtServer.setBounds(118, 10, 184, 19);
		contentPane.add(txtServer);
		txtServer.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Servidor FTP:");
		lblNewLabel.setBounds(10, 10, 108, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 39, 78, 19);
		contentPane.add(lblUsuario);
		
		txtUser = new JTextField();
		txtUser.setText("usuario1");
		txtUser.setColumns(10);
		txtUser.setBounds(118, 39, 159, 19);
		contentPane.add(txtUser);
		
		JLabel lblNewLabel_1_1 = new JLabel("Clave:");
		lblNewLabel_1_1.setBounds(287, 39, 78, 19);
		contentPane.add(lblNewLabel_1_1);
		
		txtPsw = new JPasswordField();
		txtPsw.setText("usu1");
		txtPsw.setColumns(10);
		txtPsw.setBounds(375, 39, 126, 19);
		contentPane.add(txtPsw);
		
		JButton btnLogin = new JButton("Conectar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loggedIn) {
					try {
						client.logout();
						client.disconnect();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					btnLogin.setText("Conectar");
					model.clear();
					
					btnLoad.setEnabled(false);
					btnDownload.setEnabled(false);
					btnMkdir.setEnabled(false);
					btnRm.setEnabled(false);
					btnDel.setEnabled(false);
					
					JOptionPane.showMessageDialog(null, "Desconectado", "desconexion", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				String server = txtServer.getText();
				String user = txtUser.getText();
				String psw = txtPsw.getText();
				
				try {
					client.connect(server);
					loggedIn = client.login(user, psw);
					
					if (!loggedIn) {
						JOptionPane.showMessageDialog(null, "Usuario/contraseña incorrectos", "error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Conexion realizada con exito", "exito", JOptionPane.INFORMATION_MESSAGE);
					btnLogin.setText("Descontectar");
					
					btnLoad.setEnabled(true);
					btnDownload.setEnabled(true);
					btnMkdir.setEnabled(true);
					btnRm.setEnabled(true);
					btnDel.setEnabled(true);
					
					cargarLista();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al conectarse al servidor", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(312, 9, 189, 21);
		contentPane.add(btnLogin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 355, 441);
		contentPane.add(scrollPane);
		
		model = new DefaultListModel<>();
		listDir = new JList(model);
		scrollPane.setViewportView(listDir);
		
		btnLoad = new JButton("SUBIR FICHERO");
		btnLoad.setEnabled(false);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
                    // Obtener el archivo seleccionado
                    try {
                    	File selectedFile = fileChooser.getSelectedFile();
						
                    	client.setFileType(FTP.BINARY_FILE_TYPE);
						BufferedInputStream is = new BufferedInputStream(new FileInputStream(selectedFile));
						if (client.storeFile(selectedFile.getName(), is)) {
							JOptionPane.showMessageDialog(null, "Fichero subido", "upload", JOptionPane.INFORMATION_MESSAGE);
							cargarLista();
						} else  {
							JOptionPane.showMessageDialog(null, "Error al subir archivo", "error", JOptionPane.ERROR_MESSAGE);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnLoad.setBounds(375, 88, 126, 38);
		contentPane.add(btnLoad);
		
		btnDownload = new JButton("DESCARGAR FICHERO");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = client.printWorkingDirectory().equals("/") ? listDir.getSelectedIndex() : listDir.getSelectedIndex() - 1;
					if (files[index].getType() == 0) {
						client.setFileType(FTP.BINARY_FILE_TYPE);
						
						BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(files[index].getName()));
						client.retrieveFile(files[index].getName(), os);
						
						File f = new File(files[index].getName());
						os.close();
						
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setDialogTitle("Guardar archivo");
						fileChooser.setSelectedFile(f);
						
						int result = fileChooser.showOpenDialog(null);
						if (result == JFileChooser.APPROVE_OPTION) {
							File saveFile = fileChooser.getSelectedFile();
							Files.move(f.toPath(), saveFile.toPath());
							
							JOptionPane.showMessageDialog(null, "Fichero descargado", "download", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                	JOptionPane.showMessageDialog(null, "Error al descargar archivo", "error", JOptionPane.ERROR_MESSAGE);
		                }
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDownload.setEnabled(false);
		btnDownload.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnDownload.setBounds(375, 136, 126, 38);
		contentPane.add(btnDownload);
		
		btnDel = new JButton("ELIMINAR FICHERO");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ELIMINAR FICHERO
				try {
					int index = client.printWorkingDirectory().equals("/") ? listDir.getSelectedIndex() : listDir.getSelectedIndex() - 1;
					if (files[index].getType() == 0) {
						File f = new File(files[index].getName());
						if (client.deleteFile(f.getPath())) {
							JOptionPane.showMessageDialog(null, "Fichero borrado", "borrar", JOptionPane.INFORMATION_MESSAGE);
							cargarLista();
		                } else {
		                	JOptionPane.showMessageDialog(null, "Error al borrar archivo", "error", JOptionPane.ERROR_MESSAGE);
		                }
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDel.setEnabled(false);
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnDel.setBounds(375, 184, 126, 38);
		contentPane.add(btnDel);
		
		btnMkdir = new JButton("CREAR CARPETA");
		btnMkdir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CREAR CARPETA
				String nombre = JOptionPane.showInputDialog(null, "Escribe el nombre de la carpeta");
				if (nombre == null || nombre.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Error, nombre null", "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					client.makeDirectory(nombre);
					JOptionPane.showMessageDialog(null, "Carpeta creada", "Crear", JOptionPane.INFORMATION_MESSAGE);
					cargarLista();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMkdir.setEnabled(false);
		btnMkdir.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnMkdir.setBounds(375, 232, 126, 38);
		contentPane.add(btnMkdir);
		
		btnRm = new JButton("ELIMINAR CARPETA");
		btnRm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ELIMINAR CARPETA
				String nombre = JOptionPane.showInputDialog(null, "Escribe el nombre de la carpeta a eliminar");
				if (nombre == null || nombre.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Error, nombre null", "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					client.removeDirectory(nombre);
					JOptionPane.showMessageDialog(null, "Carpeta borrada", "borrar", JOptionPane.INFORMATION_MESSAGE);
					cargarLista();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRm.setEnabled(false);
		btnRm.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnRm.setBounds(375, 280, 126, 38);
		contentPane.add(btnRm);
		
		btnClose = new JButton("SALIR");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnClose.setBounds(375, 328, 126, 38);
		contentPane.add(btnClose);
		
		client = new FTPClient();
		loggedIn = false;
		
		listDir.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					String selectedValue = (String) listDir.getSelectedValue();
					if (selectedValue == null) {
						return;
					}
					
					if (selectedValue.equals("..")) {
						client.changeWorkingDirectory("..");
						cargarLista();
						return;
					}
					
					int index = client.printWorkingDirectory().equals("/") ? listDir.getSelectedIndex() : listDir.getSelectedIndex() - 1;
					if (files[index].getType() != 1) {
						return;
					}
					
					String dirName = selectedValue.substring(6);
					client.changeWorkingDirectory(dirName);
					
					cargarLista();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void cargarLista() {
		try {
			model.clear();
			
			if (!client.printWorkingDirectory().equals("/")) {
				model.addElement("..");
			}
			
			files = client.listFiles();
			for (FTPFile f : files) {
				switch (f.getType()) {
				case 0:
					model.addElement("(FIC) " + f.getName());
					break;
				case 1:
					model.addElement("(DIR) " + f.getName());
					break;
				case 2:
					model.addElement("(URL) " + f.getName());
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
