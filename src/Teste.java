import java.util.Arrays;
import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Quantos numeros deseja gerar: ");

		// Variavel que receberá quantidade de numeros a serem gerados
		int qtdNumbers = entrada.nextInt();

		System.out.println("");

		// Array que recebera os numeros
		int[] arrayNumbers = new int[qtdNumbers];

		// Variavel que receberá o numero aleatorio pra ser validado
		int auxRandom = 0;

		int repeatedNumbers = 0;

		for (int i = 0; i < arrayNumbers.length; i++) {
			int count = 0;

			auxRandom = generateRandomNumber();

			// arrayNumbers[i] = generateRandomNumber();

			// Compara se já existe o numero no array
 			for (int j : arrayNumbers) {
				if (auxRandom == j && j != 0) {
					count++;
				}

				if (count >= 2 && j != 0) {
					arrayNumbers[i] = 0;
					repeatedNumbers++;
					break;
					// System.out.println(j + " é um numero repetido " + count + " vezes");
				} else {

					arrayNumbers[i] = auxRandom;
				}
			}

		}
		int[] noRepeatNumbers = new int[arrayNumbers.length  - repeatedNumbers];
		int y = 0;
		for (int k : arrayNumbers) {
			if (k != 0) {
				noRepeatNumbers[y] = k;
				y++;
			}
		}

		System.out.println(Arrays.toString(arrayNumbers));
		System.out.println(Arrays.toString(noRepeatNumbers));

	}

	// Gera numeros aleatorios de 1 a 100
	public static int generateRandomNumber() {
		int numberRandom = (int) Math.round((100 * Math.random()) + 1);
		return numberRandom;
	}
}
