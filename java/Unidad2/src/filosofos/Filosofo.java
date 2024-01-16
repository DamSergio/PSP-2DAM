package filosofos;

public class Filosofo extends Thread{
	private int n;
	private Mesa m;
	
	public Filosofo(int n, Mesa m) {
		super();
		this.n = n;
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Mesa getM() {
		return m;
	}

	public void setM(Mesa m) {
		this.m = m;
	}
	
	public void pensar() {
		System.out.println(n + " esta pensando -_-");
		try {
			this.sleep((int)(Math.random() * 1000) + 100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			pensar();
			m.cena(n);
		}
	}
}
