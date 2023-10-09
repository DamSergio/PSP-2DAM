package procesos;

import java.util.Scanner;

public class CadenaArgs {
	public static void main(String[] args) {
		if (args.length == 1) {
			for (int i = 0; i < 3; i++) {
				System.out.println((i + 1) + " " + args[0]);
			}
		}
	}
}
