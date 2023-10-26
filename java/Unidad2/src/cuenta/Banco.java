package cuenta;

public class Banco {

	public static void main(String[] args) {
		Cuenta c = new Cuenta(80);
		Persona per1 = new Persona(c, "Sara");
		Persona per2 = new Persona(c, "Mateo");
		
		per1.start();
		per2.start();
	}

}
