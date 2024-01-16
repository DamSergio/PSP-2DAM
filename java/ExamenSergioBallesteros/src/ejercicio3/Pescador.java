package ejercicio3;

public class Pescador extends Thread{

private Lonja lalonja=null;
    
    public Pescador(Lonja l){
           lalonja=l;
    }
    public void run(){
    	int atun=0;
            while (true){
                lalonja.echarAlalonja(++atun);
                 try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
            }
    }
	
	
	
}
