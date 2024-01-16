package ejercicio3;

public class DiaMercado {
	public static void main(String[] args) {
		int tam=6;
		//crear la lonja y los hilos
		Lonja l = new Lonja(tam);
		Pescador p = new Pescador(l);
		
		p.start();
		for (int i = 0; i < 3; i++) {
			new Comprador(l, i + 1).start();
		}
		
	}
}
