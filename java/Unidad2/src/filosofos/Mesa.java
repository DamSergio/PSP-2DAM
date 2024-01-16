package filosofos;

public class Mesa {
	
	private final static int PENSANDO=0;
	private final static int HAMBRIENTO=1;
	private final static int COMIENDO=2;
	
	private int[] estado = {PENSANDO,PENSANDO,PENSANDO,PENSANDO, PENSANDO};
	
	
	
	private void comer(int f) {
		System.out.println(f+" ESTA COMIENDO!!!!");
		try { Thread.sleep((int)(Math.random()*1000.0)+100); }
		catch (Exception e) { }
		
	}
	public void cena(int f) {
		cogerTenedor(f);
		comer(f);
		dejarTenedor(f);
	}
	
	
	private synchronized void cogerTenedor(int f) {
		 estado[f]=HAMBRIENTO;
		 System.out.println(f+" esta esperando y  hambriento ;-;");
		 
		 test(f);
		 while(estado[f]!=COMIENDO) {
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	     
		//Espera para comer	
		
	}
	private synchronized void dejarTenedor(int f) {
		estado[f]=PENSANDO;
		System.out.println(f+" DEJA EL TENEDOR");
        	//Informar de que otros pueden comer
		test((f+4)%5);
		test((f+1)%5);
	}
	
	private void test(int f) {

		/*Comprueba si f esta hambriento y si los filosofos
		de su derecha e izquierda no estan comiendo*/
		
          if(estado[f]==HAMBRIENTO && estado[(f+1)%5]!=COMIENDO && estado[(f+4)%5]!=COMIENDO) {
        	  estado[f]=COMIENDO;
        	  notifyAll();
          }


	 }
		
		
	}
	

