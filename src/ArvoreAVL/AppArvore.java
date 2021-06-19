package arvoreAVL;

import java.util.Scanner;

public class AppArvore {
	public static void main(String args[]) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Defina o primeiro no:");
		ArvoreAVL arvore = new ArvoreAVL(new Elemento(teclado.nextInt()));
		arvore.calcularBalanceamento();
		arvore = arvore.verificaBalanceamento();
		//System.out.println(arvore.printArvore(0));
int option = -1;
		while (option != 0) {
			System.out.println("Insira o nó da arvore:");
			arvore = arvore.inserir(new Elemento(teclado.nextInt()));
			arvore.calcularBalanceamento();
			arvore = arvore.verificaBalanceamento();
			System.out.println("Definir option:");
			option = teclado.nextInt();
			//System.out.println(arvore.printArvore(0));
		}
		
		arvore.imprimirInOrdem();

	}
}
