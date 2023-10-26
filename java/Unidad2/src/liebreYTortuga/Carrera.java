package liebreYTortuga;

public class Carrera {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Liebre(i).start();
			new Tortuga(i).start();
		}
//		Liebre l1 = new Liebre(1);
//		Liebre l2 = new Liebre(2);
//		Liebre l3 = new Liebre(3);
//		
//		Tortuga t1 = new Tortuga(1);
//		Tortuga t2 = new Tortuga(2);
//		Tortuga t3 = new Tortuga(3);
//		
//		l1.start();
//		l2.start();
//		l3.start();
//		
//		t1.start();
//		t2.start();
//		t3.start();
		
		System.out.println("FIN");
	}

}
