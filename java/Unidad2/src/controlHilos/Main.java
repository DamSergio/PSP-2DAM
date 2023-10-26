package controlHilos;

public class Main {

	public static void main(String[] args) {
		Compartido c = new Compartido();
		HiloCadena h1 = new HiloCadena(c, "A");
		HiloCadena h2 = new HiloCadena(c, "B");
		
		h1.start();
		h2.start();
	}

}
