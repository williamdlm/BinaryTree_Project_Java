package arvoreBinaria;

import java.util.Arrays;
import java.util.Scanner;

public class GenerateNumbers {

	public static int[] generateArrayNoRepetedNumber(int[] arrayNumbers) {

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
					System.out.println("O numero " + j + " se repetiu, não será armazenado novamente ");
					break;
				} else {

					arrayNumbers[i] = auxRandom;
				}
			}

		}
		int[] noRepeatNumbers = new int[arrayNumbers.length - repeatedNumbers];
		int y = 0;
		for (int k : arrayNumbers) {
			if (k != 0) {
				noRepeatNumbers[y] = k;
				y++;
			}
		}

		// System.out.println(Arrays.toString(arrayNumbers));
		System.out.println(Arrays.toString(noRepeatNumbers));

		return noRepeatNumbers;

	}

	// Gera numeros aleatorios de 1 a 100
	public static int generateRandomNumber() {
		int numberRandom = (int) Math.round((99 * Math.random()) + 1);
		return numberRandom;
	}

}
