package contador;

public class Main {

	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloACont h1 = new HiloACont("A", cont);
		HiloBCont h2 = new HiloBCont("B", cont);
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(cont.getCont());
	}

}
