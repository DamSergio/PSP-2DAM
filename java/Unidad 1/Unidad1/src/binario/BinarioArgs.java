package binario;

public class BinarioArgs {

	public static void main(String[] args) {
		if (args.length == 1) {
			int numberToBin = Integer.parseInt(args[0]);
			
			System.out.println(Integer.toBinaryString(numberToBin));
		}
	}

}
