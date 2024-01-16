package ejercicio3;

public class Comprador extends Thread{

	private Lonja lalonja=null;
	private int numComp=0;
    
    public Comprador(Lonja l,int num){
           lalonja=l;
           numComp=num;
    }
    public void run(){
    	int comprador;
            while (true){
                   comprador=lalonja.sacardelalonja(numComp);
                   try {
   					Thread.sleep(500);
   				} catch (InterruptedException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				}
            }
    }
	
}