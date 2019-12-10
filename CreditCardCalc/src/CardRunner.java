import java.io.File;

import java.util.Scanner;

public class CardRunner {
	static int fileLength = 99;
	static int validNum;
	static int invalidNum;
	static long cNumb;
	static int cTotal;

	public static void main(String[] args) {
		Calculate();
	}
public static void Calculate() {
		Scanner file = new Scanner(new File("CCNumbers"));		
		for (int fl = 0; fl < fileLength; fl++) {
			cNumb = file.nextLong();

			int cNumbA[] = new int[16];
			long size = (long) 1000000000000000.;

			for (int c = 0; c < 16; c++) {
				cNumbA[c] = (int) (cNumb / size);
				cNumb = cNumb - cNumbA[c] * size;
				size = size / 10;

			}

			for (int c = 0; c < 16; c = c + 2) {
				cNumbA[c] = cNumbA[c] * 2;
				cNumbA[c] = cNumbA[c] % 10 + cNumbA[c] / 10;

			}

			for (int c = 0; c < 16; c++) {
				cTotal = cTotal + cNumbA[c];
			}

			if (cTotal % 10 == 0) {
				validNum = validNum + 1;
			} else {
				invalidNum = invalidNum + 1;
			}
		}
		System.out.println("Valid numbers: " + validNum);
		System.out.println("Invalid numbers: " + invalidNum);

	
}
}