package menu;

import java.util.Scanner;

import arvoreAVL.ArvoreAVL;
import arvoreAVL.Elemento;
import arvoreBinaria.*;

public class Executa extends arvoreBinaria.GenerateNumbers {
	public static void main(String[] args) throws InterruptedException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Quantos numeros deseja gerar: ");

		// Variavel que receberá quantidade de numeros a serem gerados
		int qtdNumbers = entrada.nextInt();
		int[] arrayNumbers = new int[qtdNumbers];
		arrayNumbers = generateArrayNoRepetedNumber(arrayNumbers);

		System.out.println("");

		// Instancia Arvore Binaria
		Arvore arvore = new Arvore();

		// Instancia Arvore AVL
		ArvoreAVL arvoreAvl = new ArvoreAVL();

		int key;
		do {
			System.out.println("Qual estrutura de dados deseja usar?");
			System.out.println("1: Arvore binaria \n2: Arvore AVL \n0: Sair");
			key = entrada.nextInt();
			switch (key) {
			case 0: {
				System.out.println("Programa finalizado");
				break;
			}

			case 1: {
				for (int i : arrayNumbers) {
					arvore.adicionar(i);
				}

				menuArvoreBinaria(arvore);

				break;
			}
			case 2: {
				for (int i : arrayNumbers) {
					arvoreAvl.inserir(new Elemento(i));
				}
				menuArvoreAvl(arvoreAvl);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
		} while (key != 0);
	}

	public static void menuArvoreAvl(ArvoreAVL arvoreAVL) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("####ARVORE AVL######");
		System.out.println("####ESCOLHA UMA OPÇÃO######");
		arvoreAVL.calcularBalanceamento();
		System.out.println("1: Inserir \n2: Buscar \n3: Remover \n4: Ordernar \n5: Calcular altura   \n0: Sair");
		System.out.println("");
		int option = entrada.nextInt();

		switch (option) {
		case (1): {
			System.out.println("Digite um numero que deseja inserir");
			int number = entrada.nextInt();
			long start = System.currentTimeMillis();
			arvoreAVL.inserir(new Elemento(number));
			arvoreAVL.verificaBalanceamento();
			long end = System.currentTimeMillis();
			long tempoExecucao = end - start;
			System.out.println("O tempo de execução foi de: " +tempoExecucao);
			break;
		}

		case 2: {
			System.out.println("Insira o numero que deseja buscar");
			int number = entrada.nextInt();
			long start = System.currentTimeMillis();
			if (arvoreAVL.busca(number) == true) {
				System.out.println("Numero existente da arvore");
			} else {
				System.out.println("Não existe");
			}
			long end = System.currentTimeMillis();
			long tempoExecucao = end - start;
			System.out.println("O tempo de execução foi de: " +tempoExecucao);

			break;
		}
		case 3: {
			System.out.println("Insira o numero que deseja remover");
			int number = entrada.nextInt();
			long start = System.currentTimeMillis();
			arvoreAVL.remover(new Elemento(number));
			long end = System.currentTimeMillis();
			long tempoExecucao = end - start;
			System.out.println("O tempo de execução foi de: " +tempoExecucao);
			System.out.println("Finalizada remoção");
			break;
		}
		case 4: {
			int optionOrder;
			do { 
			System.out.println("#####################################" + "\nEm qual ordem deseja ler a arvore?");
			System.out.println("1: Em ordem \n2: Pre-ordem \n3: Pos-ordem" +"\n0: Voltar menu anterior");

			optionOrder = entrada.nextInt();

			switch (optionOrder) {
			case 1: {
				System.out.println("###EM ORDEM####");
				long start = System.currentTimeMillis();
				arvoreAVL.imprimirInOrdem();
				long end = System.currentTimeMillis();
				long tempoExecucao = end - start;
				System.out.println("O tempo de execução foi de: " +tempoExecucao);

				break;
			}
			case 2: {
				System.out.println("###PRE ORDEM###");
				long start = System.currentTimeMillis();
				arvoreAVL.imprimirPreOrdem();
				long end = System.currentTimeMillis();
				long tempoExecucao = end - start;
				System.out.println("O tempo de execução foi de: " +tempoExecucao);
				break;

			}
			
			case 3: {
				System.out.println("###POS ORDEM###");
				long start = System.currentTimeMillis();
				arvoreAVL.imprimirPosOrdem();
				long end = System.currentTimeMillis();
				long tempoExecucao = end - start;
				System.out.println("O tempo de execução foi de: " +tempoExecucao);
				break;
			}

			}

		} while (optionOrder != 0);
}
		case 5:{
			System.out.println("A altura da arvore:");
			System.out.println(arvoreAVL.calcularAltura());
			break;
			
		}

		}
	}

	public static void menuArvoreBinaria(Arvore arvore) throws InterruptedException {
		Scanner entrada = new Scanner(System.in);
		int option;

		do {
			System.out.println("#####################################" + "\nESCOLHA UMA OPÇÃO.:");
			System.out.println("1: Inserir \n2: Remover \n3: Ordenar \n4: Calcular altura \n0: Sair");
			option = entrada.nextInt();

			switch (option) {
			case 0: {
				System.out.println("RETORNADO PARA ESCOLHA DA ARVORE");
				break;
			}
			case 1: {
				System.out.println("#### Adição ####");
				System.out.println("Escreva o numero que deseja inserir:");
				int number = entrada.nextInt();
				long start = System.currentTimeMillis();
				arvore.adicionar(number);
				long end = System.currentTimeMillis();
				long tempoExecucao = end - start;
				System.out.println("O tempo de execução foi de: " +tempoExecucao);
				break;
			}
			case 2: {
				System.out.println("#### REMOÇÃO ####");
				System.out.println("Escreva o numero que deseja remover:");
				int number = entrada.nextInt();
				long start = System.currentTimeMillis();
				arvore.remover(number);
				long end = System.currentTimeMillis();
				long tempoExecucao = end - start;
				System.out.println("O tempo de execução foi de: " +tempoExecucao);
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
						long start = System.currentTimeMillis();
						arvore.emOrdem(arvore.getRaiz());
						//Thread.sleep(1000);
						long end = System.currentTimeMillis();
						long tempoExecucao = end - start;
						System.out.println("O tempo de execução foi de: " +tempoExecucao);
						System.out.println("");
						break;
					}
					case 2: {
						System.out.println("");
						System.out.println("##### PRÉ ORDEM #####");
						long start = System.currentTimeMillis();
						arvore.preOrdem(arvore.getRaiz());
						long end = System.currentTimeMillis();
						long tempoExecucao = end - start;
						System.out.println("O tempo de execução foi de: " +tempoExecucao);
						System.out.println("");
						break;
					}
					case 3: {
						System.out.println("");
						System.out.println("##### POS ORDEM #####");
						long start = System.currentTimeMillis();
						arvore.posOrdem(arvore.getRaiz());
						long end = System.currentTimeMillis();
						long tempoExecucao = end - start;
						System.out.println("O tempo de execução foi de: " +tempoExecucao);
						System.out.println("");
						break;
					}

					}
				} while (optionOrder != 0);
			}case 4:{
				System.out.println("Altura é:");
				System.out.println(arvore.calcularAltura());
				break;
				
			}
			}

		} while (option != 0);
	}
}
