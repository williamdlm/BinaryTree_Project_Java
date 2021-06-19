package arvoreBinaria;

public class Arvore {
	
	private Elemento raiz;
	
	public Arvore() {
		this.raiz = null;
	}
	
	
	//METODO ADIÇÃO
	public void adicionar(int valor) {
		Elemento novoElemento = new Elemento(valor);
		if(raiz == null) {
			this.raiz = novoElemento;
		}else {
			Elemento atual = this.raiz;
			while(true) {
				if(novoElemento.getValor() < atual.getValor()) {
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
	
	
	

	//METODO REMOÇÃO
	public boolean remover(int valor) {
		Elemento atual = this.raiz;
		Elemento paiAtual = null;
		while(atual != null) {
			if(atual.getValor() == valor) {
				//Realizando a remoção do elemento da arvore
				break;
			}else if (atual.getValor() > valor){
				paiAtual = atual;
				atual = atual.getEsquerda();
			}else {
				paiAtual = atual;
				atual = atual.getDireita();
			}
		}
		
		if(atual != null){
			
			//Elemento tem os dois filhos ou elemento tem filho a direta
			if(atual.getDireita()!=null) {
				//atual so tem filho a direita
				
				//atual so tem filho a esquerda
				Elemento substituto = atual.getDireita();
				Elemento paiSubstituto = atual;
				
				while(substituto.getEsquerda() != null) {
					paiSubstituto = substituto;
					substituto = substituto.getEsquerda();
				}
				if(paiAtual != null) {
					if(atual.getValor() > paiAtual.getValor()) {
						paiAtual.setDireita(substituto);
					}else {
						paiAtual.setEsquerda(substituto);
					}
				}else {
					this.raiz = substituto;
				}
				
				
				//removendo o elemento da arvore
				if(substituto.getValor() > paiSubstituto.getValor()) {
					paiSubstituto.setDireita(null);
				}else {
					paiSubstituto.setEsquerda(null);
				}
				
			}else if(atual.getEsquerda()!=null){
				Elemento substituto = atual.getEsquerda();
				Elemento paiSubstituto = atual;
				
				while(substituto.getDireita() != null) {
					paiSubstituto = substituto;
					substituto = substituto.getDireita();
				}
				if(paiAtual != null) {
					if(atual.getValor() > paiAtual.getValor()) {
						paiAtual.setDireita(substituto);
					}else {
						paiAtual.setEsquerda(substituto);
					}
				}else { //se for a raiz
					this.raiz = substituto;
				}
				
				
				//removendo o elemento da arvore
				if(substituto.getValor() > paiSubstituto.getValor()) {
					paiSubstituto.setDireita(null);
				}else {
					paiSubstituto.setEsquerda(null);
				}
				
			}else {
				//atual não tem filhos
				if(paiAtual != null) {
					if(atual.getValor() > paiAtual.getValor()) {
						paiAtual.setDireita(null);
					}else {
						paiAtual.setEsquerda(null);
					}					
				}else {
					this.raiz = null;
				}
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	//----- FINAL METODO REMOÇÃO -----
	
	//  ------ METODOS ORDENAÇÃO --------
	public void emOrdem(Elemento atual) {
		if(atual != null) {
			emOrdem(atual.getEsquerda());
			System.out.println(atual.getValor());
			emOrdem(atual.getDireita());
		}
		
	}
	
	public void preOrdem(Elemento atual) {
		if(atual !=null) {
			System.out.println(atual.getValor());
			preOrdem(atual.getEsquerda());
			preOrdem(atual.getDireita());
		}
	}	
	
	public void posOrdem(Elemento atual) {
		if(atual != null){
			posOrdem(atual.getEsquerda());
			posOrdem(atual.getDireita());
			System.out.println(atual.getValor());
		}
	}
	
	//-----FINAL METODO DE ORDENAÇÃO-------
	
	//Getters and Setters
	
	public Elemento getRaiz() {
		return raiz;
	}
	
}
