package aparcamiento;

public class ControlAparcamiento {

	public static void main ( String [ ] args ) {
		Aparcamiento p = new Aparcamiento (0) ;
		for ( int y = 1 ; y <= 40 ; y ++ ) {
			Coche c = new Coche ( "Coche matrícula " + y, p ) ;
			c.start();
		}
	}
}