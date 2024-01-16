package ejercicio2;

import java.util.Scanner;

public class Primo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime un numero y te dire si es primo");
		int num = sc.nextInt();
		System.out.println("Has seleccionado el numero:" + num);
		
		boolean esPrimo = true;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				esPrimo = false;
				break;
			}
		}
		
		if (esPrimo) {
			System.out.println("El numero " + num + " es primo");
		} else {
			System.out.println("El numero " + num + " no es primo");
		}
	}

}
