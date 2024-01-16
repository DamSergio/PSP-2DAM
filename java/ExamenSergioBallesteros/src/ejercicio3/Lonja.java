package ejercicio3;

import java.util.ArrayList;

public class Lonja {
	
	private int numero=0;
	//lonja puede ser una estructura estática, es decir un array, o dinámica un ArrayList
	private ArrayList<Integer> lonja;
	//Declara las variables que necesites
	
	
	public Lonja(int numero) {
		this.numero=numero;
		this.lonja= new ArrayList<>();
	}
	
	public synchronized void echarAlalonja(int numatun) {
		
		
		// mientras la lonja está llena
		while (lonja.size() == numero) {
			System.out.println("\tLONJA  LLENA: Esperando comprador ");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		//Si no está llena se ponen a la venta
		System.out.println("**********************************");
		System.out.println("************A la venta:  "+numatun+"********");
		System.out.println("**********************************");
		
		lonja.add(numatun);
		notifyAll();
	}
	public synchronized int sacardelalonja(int numerocomprador) {
		int numatun=0;
		
		//mientras lonja  vacía
		while (lonja.size() == 0) {
			System.out.println("*********************LONJA  VACÍA: Esperando pescador ");
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		//Si hay atunes en la lonja	se lleva 1, 2 o 3 si hay
		
		int compras = (int)(1 + Math.random() * 3);
		int pescadosDisponibles = lonja.size();
		
		if (pescadosDisponibles < compras) {
			compras = pescadosDisponibles;
		}
		
		System.out.println("**********************************");
		System.out.println("El comprador " + numerocomprador + " compra: " + compras);
		for (int i = 0; i < compras; i++) {
			System.out.println("\tEl atun " + lonja.remove(0));
		}
		System.out.println("**********************************");
		
		notifyAll();
		return numatun;
			
		}//

}
