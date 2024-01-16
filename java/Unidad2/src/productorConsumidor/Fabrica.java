package productorConsumidor;

public class Fabrica {

	public static void main(String[] args) {
		Cinta c = new Cinta();
		Productor p = new Productor(c, 1);
		Consumidor co = new Consumidor(c, 1);
		
		p.start();
		co.start();
	}

}
