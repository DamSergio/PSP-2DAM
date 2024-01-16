package filosofos;

public class CenaFilosofos {

	public static void main(String[] args) {
		Mesa m = new Mesa();
		Filosofo f0 = new Filosofo(0, m);
		Filosofo f1 = new Filosofo(1, m);
		Filosofo f2 = new Filosofo(2, m);
		Filosofo f3 = new Filosofo(3, m);
		Filosofo f4 = new Filosofo(4, m);
		
		Filosofo f[] = {f0, f1, f2, f3, f4};
		
		for (int i = 0; i < f.length; i++) {
			f[i].start();
		}
	}

}
