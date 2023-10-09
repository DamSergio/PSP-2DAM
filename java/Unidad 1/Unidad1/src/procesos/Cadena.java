package procesos;

import java.util.Scanner;

public class Cadena {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("Dame un cadena de texto");
		String cadena = sc.next();
		
		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + " " + cadena);
		}
		
		sc.close();
	}

}
