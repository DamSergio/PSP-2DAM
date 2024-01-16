package misioneros;

import java.util.ArrayList;

public class Olla {
	private int numero;
	private ArrayList<Integer> olla;
	
	public Olla(int numero) {
		this.numero = numero;
		this.olla = new ArrayList<>();
	}
	
	public synchronized void meter(int mis) {
		while (olla.size() == numero) {
			System.out.println("olla llena");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		olla.add(mis);
		System.out.println("cocinando al: " + mis);
		mis++;
		notifyAll();
		
	}
	
	public synchronized int sacar(int n) {
		int mis;
		while (olla.size() == 0) {
			System.out.println("olla vacia");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mis = olla.remove(0);
		System.out.println(n + " comiendo " + mis);
		notifyAll();
		return mis;
	}
}
