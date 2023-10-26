package contador;

public class HiloBCont extends Thread{
	private Contador cont;
	
	public HiloBCont(String name, Contador cont) {
		this.cont = cont;
		this.setName(name);
	}
	
	public void run() {
		for (int i = 0; i < 300; i++) {
			cont.decrease();
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
