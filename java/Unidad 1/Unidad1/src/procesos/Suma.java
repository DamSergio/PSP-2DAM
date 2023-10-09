package procesos;

import java.util.Scanner;

public class Suma {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		System.out.println("La suma es: " + (Integer.parseInt(a) + Integer.parseInt(b)));
	}

}
