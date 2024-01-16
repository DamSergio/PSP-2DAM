package aparcamiento;

class Aparcamiento {
	private int plazas ;
 
	public Aparcamiento ( int plazas ) {
		if ( plazas < 0 )
			plazas = 0 ;
		
		this.plazas = plazas ;
	}
 
	public synchronized void entra (String matricula ) { // coche entra en el parking
		while (plazas == 10) {
			try {
				System.out.println("Esperando, parking lleno." ) ;
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		plazas++;
		System.out.println (matricula + ": entra en el parking" ) ;
		notifyAll();
	}
 
	public synchronized void sale ( String matricula ) { // el coche deja el parking
		plazas--;
		notifyAll();
		
		System.out.println (matricula + ": sale del parking" ) ;
	
	}
}