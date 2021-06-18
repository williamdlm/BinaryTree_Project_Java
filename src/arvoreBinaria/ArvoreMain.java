package arvoreBinaria;

import java.util.Arrays;
import java.util.Scanner;

public class ArvoreMain {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.out.println("Quantos numeros deseja gerar: ");

		// Variavel que receberá quantidade de numeros a serem gerados
		int qtdNumbers = entrada.nextInt();
		int[] arrayNumbers = new int[qtdNumbers];
		arrayNumbers = generateArrayNoRepetedNumber(arrayNumbers);

		System.out.println("");

		Arvore arvore = new Arvore();

		for (int i : arrayNumbers) {
			arvore.adicionar(i);
		}

		int responseOrder;

		do {
			System.out.println("#####################################" + "\n Qual opcao desejada?");
			System.out.println("1: Remocao de no \n2: Ordenacao da arvore" + "\n0: Sair");
			responseOrder = entrada.nextInt();

			switch (responseOrder) {
			case 0: {
				System.out.println("Programa finalizado");
				break;
			}
			case 1:{
				remocao(arvore);
			}
			case 2:{
				ordenacao(arvore);
			}
			}

		} while (responseOrder != 0);
		
		

	}
	
	public static void remocao(Arvore arvore) {
		int responseOrder;
		
		do {

			System.out.println("#####################################" + "\nQual numero voce deseja excluir?");
			System.out.println("Digite 0 (zero) para retornar ao menu anterior");
			responseOrder = entrada.nextInt();

			if (responseOrder == 0) {
				break;
			}else{
				arvore.remover(responseOrder);
				System.out.println("Numero " + responseOrder + " excluido!");
			}

		} while (true);
		main(null);
	}
	
	public static void ordenacao(Arvore arvore) {
		int responseOrder;
		
		do {

			System.out.println("#####################################" + "\nEm qual ordem deseja ler a arvore?");
			System.out.println("1: Em ordem \n2: Pre-ordem \n3: Pos-ordem" + "\n0: Voltar menu anterior");
			responseOrder = entrada.nextInt();

			switch (responseOrder) {
			case 0: {
				System.out.println("Programa finalizado");
				break;
			}
			case 1: {
				System.out.println("");
				System.out.println("##### EM ORDEM #####");
				arvore.emOrdem(arvore.getRaiz());
				System.out.println("");
				break;
			}
			case 2: {
				System.out.println("");
				System.out.println("##### PRÉ ORDEM #####");
				arvore.preOrdem(arvore.getRaiz());
				System.out.println("");
				break;
			}
			case 3: {
				System.out.println("");
				System.out.println("##### POS ORDEM #####");
				arvore.posOrdem(arvore.getRaiz());
				System.out.println("");
				break;
			}

			}
		} while (responseOrder != 0);
		main(null);

//		System.out.println("\n Impressão da arvore em ordem");
//		arvore.emOrdem(arvore.getRaiz());
		
	}

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
