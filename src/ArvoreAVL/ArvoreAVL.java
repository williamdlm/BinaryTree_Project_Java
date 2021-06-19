package arvoreAVL;

public class ArvoreAVL {
	private Elemento ele;
	private ArvoreAVL dir;
	private ArvoreAVL esq;
	private int bal;

	public ArvoreAVL() {
		this.ele = null;
		this.esq = null;
		this.dir = null;
		this.bal = 0;
	}

	public ArvoreAVL(Elemento elem) {
		this.ele = elem;
		this.dir = null;
		this.esq = null;
		this.bal = 0;
		// System.out.println("Criei a arvore com o elemento "+elem.getValor());
	}

	public int calcularAltura() {
		if (this.esq == null && this.dir == null) {// Não tem filhos
			return 1;
		} else if (this.esq != null && this.dir == null) {
			return 1 + this.esq.calcularAltura();
		} else if (this.esq == null && this.dir != null) {
			return 1 + this.dir.calcularAltura();
		} else {
			return 1 + Math.max(this.esq.calcularAltura(), this.dir.calcularAltura());
		}
	}

	public void calcularBalanceamento() {
		if (this.dir == null && this.esq == null) {
			this.bal = 0;
		} else if (this.esq == null && this.dir != null) {
			this.bal = this.dir.calcularAltura() - 0;
		} else if (this.esq != null && this.dir == null) {
			this.bal = 0 - this.esq.calcularAltura();
		} else {
			this.bal = this.dir.calcularAltura() - this.esq.calcularAltura();
		}
		if (this.dir != null) {
			this.dir.calcularBalanceamento();
		}
		if (this.esq != null) {
			this.esq.calcularBalanceamento();
		}
	}

	// Verificação e rotação

	public ArvoreAVL verificaBalanceamento() {
		if (this.bal >= 2 || this.bal <= -2) {
			if (this.bal >= 2) {
				if (this.bal * this.dir.getBal() > 0) {
					System.out.println("Rotacao simples a direita");
					return rotacaoSimplesDireita();

				} else {
					System.out.println("Rotacao dupla direita");
					return rotacaoDuplaDireita();
				}
			} else {// ball <= -2
				if (this.bal * this.esq.getBal() > 0) {
					System.out.println("Rotacao simples esquerda");
					return rotacaoSimplesEsquerda();
				} else {
					System.out.println("Rotacao dupla esquerda");
					return rotacaoDuplaEsquerda();
				}

			}
		}
		this.calcularBalanceamento();
		if (this.esq != null) {
			this.esq = this.esq.verificaBalanceamento();
		}

		if (this.dir != null) {
			this.dir = this.dir.verificaBalanceamento();
		}
		return this;
	}

	public ArvoreAVL rotacaoSimplesDireita() {
		ArvoreAVL filhoDir;
		ArvoreAVL filhoDoFilho = null;

		filhoDir = this.getDireita();
		if (this.dir != null) {
			if (this.dir.getEsquerda() != null) {
				filhoDoFilho = filhoDir.getEsquerda();
			}
		}
		filhoDir.setEsq(this);
		this.setDir(filhoDoFilho);
		return filhoDir;
	}

	public ArvoreAVL rotacaoSimplesEsquerda() {
		ArvoreAVL filhoEsq;
		ArvoreAVL filhoDoFilho = null;

		filhoEsq = this.getEsquerda();
		if (this.esq != null) {
			if (this.esq.getDireita() != null) {
				filhoDoFilho = filhoEsq.getDireita();
			}
		}
		filhoEsq.setDir(this);
		this.setEsq(filhoDoFilho);
		return filhoEsq;
	}

	public ArvoreAVL rotacaoDuplaDireita() {
		ArvoreAVL arvore = this;
		ArvoreAVL filhoDir = this.getDireita();
		ArvoreAVL filhoDoFilho = filhoDir.getEsquerda();
		ArvoreAVL noIserido = filhoDoFilho.getDireita();
		
		
		//Alinhar
		filhoDir.setEsq(noIserido);
		filhoDoFilho.setDir(filhoDir);
		this.setDir(filhoDoFilho);
		
		//Parte 2
		ArvoreAVL novoFilhoDireita = this.getDireita();
		arvore.setDir(null);
		novoFilhoDireita.setEsq(arvore);
		return novoFilhoDireita;
	}

	public ArvoreAVL rotacaoDuplaEsquerda() {
		ArvoreAVL arvore = this;
		ArvoreAVL filhoEsq = this.getEsquerda();
		ArvoreAVL filhoDoFilho = filhoEsq.getDireita();
		ArvoreAVL noIserido = filhoDoFilho.getEsquerda();
		
		
		//Alinhar
		filhoEsq.setDir(noIserido);
		filhoDoFilho.setEsq(filhoEsq);
		this.setEsq(filhoDoFilho);
		
		//Parte 2
		ArvoreAVL novoFilhoEsquerda = this.getEsquerda();
		arvore.setEsq(null);
		novoFilhoEsquerda.setDir(arvore);
		return novoFilhoEsquerda;
	}

	// metodos de controle;
	public boolean isEmpty() {
		return (this.ele == null);
	}

	public void imprimirPreOrdem() {
		if (!isEmpty()) {
			System.out.print(this.ele.getValor() + "  ");
			if (this.esq != null) {
				this.esq.imprimirPreOrdem();
			}
			if (this.dir != null) {
				this.dir.imprimirPreOrdem();
			}
		}
	}

	public void imprimirInOrdem() {
		if (!isEmpty()) {
			if (this.esq != null) {
				this.esq.imprimirInOrdem();
			}
			System.out.print(this.ele.getValor() + "  ");
			if (this.dir != null) {
				this.dir.imprimirInOrdem();
			}
		}
	}

	public void imprimirPosOrdem() {
		if (!isEmpty()) {
			if (this.dir != null) {
				this.dir.imprimirPosOrdem();
			}
			if (this.esq != null) {
				this.esq.imprimirPosOrdem();
			}
			System.out.print(this.ele.getValor() + "  ");
		}
	}

	public ArvoreAVL inserir(Elemento novo) {
		if (isEmpty()) {
			this.ele = novo;
		} else {
			ArvoreAVL novaArvore = new ArvoreAVL(novo);
			if (novo.getValor() < this.ele.getValor()) { // vou inserir na descendencia esquerda
				if (this.esq == null) { // sou um nó folha?
					this.esq = novaArvore;
					// System.out.println("Inseri o elemento "+ novo.getValor()+ " à esquerda de
					// "+this.ele.getValor());
				} else {
					this.esq = this.esq.inserir(novo); // repassei a resposnabilidade pra sub-árvore esquerda
				}
			} else if (novo.getValor() > this.ele.getValor()) { // vou inserir na descendenia direita
				if (this.dir == null) {
					this.dir = novaArvore;
					// System.out.println("Inseri o elemento "+ novo.getValor()+ " à direita de
					// "+this.ele.getValor());
				} else {
					this.dir = this.dir.inserir(novo);
				}

			}
		}
		return this;
	}

	public boolean busca(int valor) {
		if (isEmpty()) {
			return false;
		}
		if (this.ele.getValor() == valor) {
			return true;
		} else {
			if (valor < this.ele.getValor()) {
				if (this.esq == null) {
					return false;
				} else {
					return this.esq.busca(valor); // repassei a responsabilidade para a subarvore esquerda
				}
			} else if (valor > this.ele.getValor()) {
				if (this.dir == null) {
					return false;
				} else {
					return this.dir.busca(valor);
				}
			}
			return false;
		}
	}

	// remocao do no da arvore
	public ArvoreAVL remover(Elemento elem) {
		// primeiro caso - achei o elemento
		if (this.ele.getValor() == elem.getValor()) {
			// caso mais simples - o elemento está em um nó folha
			if (this.dir == null && this.esq == null) {
				return null;
			} else {
				// caso 2 - eu tenho filhos à esquerda, porém não tenho à direita
				if (this.esq != null && this.dir == null) {
					return this.esq;
				}
				// caso 3 - eu tenho filhos à direita, porém não tenho à esquerda
				else if (this.dir != null && this.esq == null) {
					return this.dir;
				}
				// caso 4 - tenho filhos dos dois lados (esquerda e direita)
				else {
					// vamos adotar a estratégia do maior dentre os menores?
					ArvoreAVL aux = this.esq;
					while (aux.dir != null) { // enquanto houver filhos à direita
						aux = aux.dir;
					}
					// troco os elementos da árvore
					this.ele = aux.getElemento(); // o nó atual recebe o elemento do aux
													// o maior dentre os menores
					aux.setElemento(elem); // insiro no nó folha (lá embaixão) o elmento a ser eliminado
					this.esq = esq.remover(elem);
				}
			}
		} else if (elem.getValor() < this.ele.getValor()) {
			// delegar a responsabilidade à sub-arvore da esquerda
			this.esq = this.esq.remover(elem);
		} else if (elem.getValor() > this.ele.getValor()) {
			// delegar a responsabilidade à sub-arvore da direita
			this.dir = this.dir.remover(elem);
		}
		return this;
	}

	// gets e sets

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public void setElemento(Elemento ele) {
		this.ele = ele;
	}

	public void setDir(ArvoreAVL dir) {
		this.dir = dir;
	}

	public void setEsq(ArvoreAVL esq) {
		this.esq = esq;
	}

	public ArvoreAVL getDireita() {
		return this.dir;
	}

	public ArvoreAVL getEsquerda() {
		return this.esq;
	}

	public Elemento getElemento() {
		return this.ele;
	}

	public String printArvore(int level) {
		String str = this.toString() + "\n";
		for (int i = 0; i < level; i++) {
			str += "\t";
		}
		if (this.esq != null) {
			str += "+=ESQ: " + this.esq.printArvore(level + 1);
		} else {
			str += "+=ESQ: NULL";
		}
		str += "\n";

		for (int i = 0; i < level; i++) {
			str += "\t";
		}
		if (this.dir != null) {
			str += "+-DIR: " + this.dir.printArvore(level + 1);
		} else {
			str += "+-DIR:NULL";
		}
		str += "\n";
		return str;
	}

	public String toString() {
		return "[" + this.ele.getValor() + "] (" + this.bal + ")";
	}
}
