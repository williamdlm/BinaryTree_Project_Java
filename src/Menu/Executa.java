package Menu;

import java.util.Scanner;

import arvoreBinaria.*;

public class Executa extends arvoreBinaria.GenerateNumbers {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Quantos numeros deseja gerar: ");

		// Variavel que receberá quantidade de numeros a serem gerados
		int qtdNumbers = entrada.nextInt();
		int[] arrayNumbers = new int[qtdNumbers];
		arrayNumbers = generateArrayNoRepetedNumber(arrayNumbers);

		System.out.println("");
		
		//Instancia Arvore Binaria
		Arvore arvore = new Arvore();
		
		//Instancia Arvore AVL
		
		
		System.out.println("Qual estrutura de dados deseja usar?");
		System.out.println("1: Arvore binaria \n2: Arvore AVL");
		int chooseTree = entrada.nextInt();
		if(chooseTree == 1) {
			
			for (int i : arrayNumbers) {
				arvore.adicionar(i);
			}
		}else {
			
		}


		int option;

		do {
			System.out.println("#####################################" + "\nESCOLHA UMA OPÇÃO.:");
			System.out.println("1: Inserir \n2: Remover \n3: Ordenar \n0: Sair");
			option = entrada.nextInt();

			switch (option) {
			case 0: {
				System.out.println("PROGRAMA FINALIZADO");
				break;
			}
			case 1: {
				System.out.println("#### Adição ####");
				System.out.println("Escreva o numero que deseja inserir:");
				int number = entrada.nextInt();
				arvore.adicionar(number);
				break;
			}
			case 2: {
				System.out.println("#### REMOÇÃO ####");
				System.out.println("Escreva o numero que deseja remover:");
				int number = entrada.nextInt();
				arvore.remover(number);
				break;
			}
			case 3: {
				int optionOrder;
				do {

					System.out
							.println("#####################################" + "\nEm qual ordem deseja ler a arvore?");
					System.out.println("1: Em ordem \n2: Pre-ordem \n3: Pos-ordem" + "\n0: Voltar menu anterior");

					optionOrder = entrada.nextInt();

					switch (optionOrder) {
					case 0: {
						System.out.println("saiu da ordenação");
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
				} while (optionOrder != 0);
			}
			}

		} while (option != 0);

	}
}
