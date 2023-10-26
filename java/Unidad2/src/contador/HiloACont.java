package contador;

public class HiloACont extends Thread{
	private Contador cont;
	
	public HiloACont(String name, Contador cont) {
		this.cont = cont;
		this.setName(name);
	}
	
	public void run() {
		for (int i = 0; i < 300; i++) {
			cont.increase();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println(this.getName() + " " + cont.getCont());
		}
		
		System.out.println(this.getName() + " " + cont.getCont());
	}
}
