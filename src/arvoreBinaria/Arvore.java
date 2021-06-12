package arvoreBinaria;

public class Arvore<TYPE extends Comparable<TYPE>> {
	
	private Elemento<TYPE> raiz;
	
	public Arvore() {
		this.raiz = null;
	}
	
	public void adicionar(TYPE valor) {
		Elemento<TYPE> novoElemento = new Elemento<TYPE>(valor);
		if(raiz == null) {
			this.raiz = novoElemento;
		}else {
			Elemento<TYPE> atual = this.raiz;
			while(true) {
				if(novoElemento.getValor().compareTo(atual.getValor()) ==-1) {
					if(atual.getEsquerda() != null) {
						atual = atual.getEsquerda();
					}else {
						atual.setEsquerda(novoElemento);
						break;
					}
				}else {
					if(atual.getDireita() != null) {
						atual = atual.getDireita();
					}else {
						atual.setDireita(novoElemento);
						break;
					}
				}
			}
		}
		
	}
	
	
	
	public Elemento<TYPE> getRaiz() {
		return raiz;
	}

	public void emOrdem(Elemento<TYPE> atual) {
		if(atual != null) {
			emOrdem(atual.getEsquerda());
			System.out.println(atual.getValor());
			emOrdem(atual.getDireita());
		}
		
	}
	
	public void preOrdem(Elemento<TYPE> atual) {
		if(atual !=null) {
			System.out.println(atual.getValor());
			preOrdem(atual.getEsquerda());
			preOrdem(atual.getDireita());
		}
	}	
	
	public void posOrdem(Elemento<TYPE> atual) {
		if(atual != null){
			posOrdem(atual.getEsquerda());
			posOrdem(atual.getDireita());
			System.out.println(atual.getValor());
		}
	}
}
