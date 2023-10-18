package binario;

import java.util.Scanner;

public class Binario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberToBin = Integer.parseInt(sc.next());
		
		System.out.println(Integer.toBinaryString(numberToBin));
	}

}
