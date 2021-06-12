package arvoreBinaria;

public class ArvoreMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Arvore<Integer> arvore = new Arvore<Integer>();
		arvore.adicionar(10);
		arvore.adicionar(8);
		arvore.adicionar(5);
		arvore.adicionar(9);
		arvore.adicionar(7);
		arvore.adicionar(18);
		arvore.adicionar(13);
		arvore.adicionar(20);
		
		System.out.println("\n Impressão da arvore em ordem");
		arvore.emOrdem(arvore.getRaiz());
		

	}

}
