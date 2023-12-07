
class No { // no da arvore
	public int elemento; 
	public No esq, dir; 
	public int altura; // altura do no

	
	public No(int elemento) {
		this(elemento, null, null, 1);
	}

	public No(int elemento, No esq, No dir, int nivel) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.altura = nivel;
	}

    // esse metodo calcula a altura do no (conta a maior altura dos nos da esquerda/direita e soma 1)
	public void setAltura() {
		this.altura = 1 + Math.max(getAltura(esq), getAltura(dir));
	}

    // se o no nao existir, a altura é 0
	public static int getAltura(No no) {
		return (no == null) ? 0 : no.altura;
	}
}


public class AVL {
	private No raiz; 

	public AVL() {
		raiz = null;
	}

    // metodo recursivo para pesquisa
	public boolean pesquisar(int x) {
		return pesquisar(x, raiz); // manda o numero que quer pesquisar e a raiz
	}

	
	private boolean pesquisar(int x, No i) {
		boolean resp; // booleano que vai definir se achou o elemento ou nao
		if (i == null) { // se chegou no fim da arvore e nao achou o elemento
			resp = false;
		} else if (x == i.elemento) { // se encontrou o elemento
			resp = true; 
		} else if (x < i.elemento) { // se nao chegou no fim e o elemento é menor que o no
			resp = pesquisar(x, i.esq);
		} else { // se nao chegou no fim e o elemento é maior que o no
			resp = pesquisar(x, i.dir);
		}
		return resp; // retorna o booleano
	}

	public void caminharCentral() {
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

	
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento + " "); // Conteudo do no.
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

	public void caminharPre() {
		System.out.print("[ ");
		caminharPre(raiz);
		System.out.println("]");
	}

	
	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + "(fator " + (No.getAltura(i.dir) - No.getAltura(i.esq)) + ") "); // Conteudo do no.
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}

	public void caminharPos() {
		System.out.print("[ ");
		caminharPos(raiz);
		System.out.println("]");
	}


	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			System.out.print(i.elemento + " "); // Conteudo do no.
		}
	}

	// inserir recursivo
	public void inserir(int x) throws Exception {
		raiz = inserir(x, raiz); // passa o elemento que quer inserir e a raiz
	}


	private No inserir(int x, No i) throws Exception {
		if (i == null) { // se o i for nulo quer dizer que pode inserir la
			i = new No(x); // insere o no
		} else if (x < i.elemento) { // se nao chegou no nulo & elemento for menor do que o no
			i.esq = inserir(x, i.esq); // chama recursivamente indo para a esquerda
		} else if (x > i.elemento) { // se nao chegou no nulo & elemento for maior que o no
			i.dir = inserir(x, i.dir); // chama recursivamente indo para a direita
		} else { // se o elemento for igual a outro ja existente da erro
			throw new Exception("Erro ao inserir!");
		}
		return balancear(i); // MUUITO IMPORTANTE! ele retorna o balancear <-----
	} 

	// remover recursivamente
	public void remover(int x) throws Exception {
		raiz = remover(x, raiz);
	}


	private No remover(int x, No i) throws Exception {
		if (i == null) { // se o i for nulo quer dizer que a arvore esta vazia ou o elemento nao existe
			throw new Exception("Erro ao remover!");
		} else if (x < i.elemento) { // se o elemento for menor que o no
			i.esq = remover(x, i.esq); // chama indo para a esquerda
		} else if (x > i.elemento) { // se o elemento for maior que o no
			i.dir = remover(x, i.dir); // chama indo pra direita
		} 
        // se for igual ao elemento
        else if (i.dir == null) { // se a direita for nula
			i = i.esq; // coloca a esquerda no lugar dele
		} else if (i.esq == null) { // se a esquerda for nula
			i = i.dir; // coloca a direita no lugar dele
		} else { // se tiver dois filhos
			i.esq = maiorEsq(i, i.esq); // seta que a esquerda é o maior elemento da esquerda
		}
		return balancear(i); // IMPORTANTEE! chama o balancear em toda inserçao e remoçao
	}

	private No maiorEsq(No i, No j) { // pegar o maior elemento da esquerda para a remoçao
		if (j.dir == null) { // percorre com o j. quando acha o ultimo elemento...
			i.elemento = j.elemento;  // seta que o novo elemento do i é o j
			j = j.esq; // "apaga" o dir do j
		
		} else { // se nao for o ultimo elemento chama recursivamente andando para direita (pq quer o maior)
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}

    // METODO MAIS IMPORTANTE DE TODOS..... BALANCEAR!
	private No balancear(No no) throws Exception {
        // importante: sempre que for chamar o rotacionar tem que retornar na variavel... tipo > no.dir = rotacionarEsq(no.dir) <
		if (no != null) { // se o no for diferente de null (nao da pra balancear um null...)
			int fator = No.getAltura(no.dir) - No.getAltura(no.esq); // calcula o fator que é a altura da direita menos a altura da esquerda
			
			if (Math.abs(fator) <= 1) { // se o fator for 1 ou 0 (nao precisa balancear)
				no.setAltura(); // atualiza a altura do no
			
			} else if (fator == 2) { // se o fator for 2 ela ta desbalanceada para a direita (balanceia pra esquerda)
                // aqui ele descobre qual tipo de balanceamento usar (simples ou dupla)
				int fatorFilhoDir = No.getAltura(no.dir.dir) - No.getAltura(no.dir.esq); // calcula o fator do filho
				
				if (fatorFilhoDir == -1) { // se o fator for -1 quer dizer que é um cotovelo
					no.dir = rotacionarDir(no.dir); // ele rotaciona para a direita primeiro
				}
				no = rotacionarEsq(no); // rotaciona para a esquerda (se for simples ele so rotaciona para a esquerda. se for dupla ele entra naquele if primeiro)
			
			} else if (fator == -2) { // se o fator for -2 quer dizer que ta desbalanceado para a esquerda (rotaciona para a direita)
				int fatorFilhoEsq = No.getAltura(no.esq.dir) - No.getAltura(no.esq.esq); // calcula o fator do filho da esquerda
				// aqui descobre qual tipo de rotaçao usar (simples ou dupla)
				if (fatorFilhoEsq == 1) { // se o fator for 1 ele vai fazer rotaçao dupla
					no.esq = rotacionarEsq(no.esq);
				}
                // se o fator for -1 ele faz rotaçao simples
				no = rotacionarDir(no);
			} else {
				throw new Exception(
						"Erro no No(" + no.elemento + ") com fator de balanceamento (" + fator + ") invalido!");
			}
		}
		return no;
	}

    // o grande rotacionar para a direita
	private No rotacionarDir(No no) {
		System.out.println("Rotacionar DIR(" + no.elemento + ")");
		No noEsq = no.esq; // salva o no que ta a esquerda do i
		No noEsqDir = noEsq.dir; // saçva o no que ta a direita do filho da esquerda pra nao perder a referencia

		noEsq.dir = no; // aponta a direita do filho para o pai
		no.esq = noEsqDir; // aponta a esquerda do pai 

        // atualiza as alturas
		no.setAltura(); 
		noEsq.setAltura(); 

		return noEsq; // retorna o no da esquerda
	}

    // rotacionar para a esquerda!
	private No rotacionarEsq(No no) {
		System.out.println("Rotacionar ESQ(" + no.elemento + ")");
		No noDir = no.dir; // salva o elemento da direita
		No noDirEsq = noDir.esq; // salva o elemento da esquerda do filho da direita pra nao perder

		noDir.esq = no; // seta que a esquerda do filho é o no
		no.dir = noDirEsq; // seta a direita do no 

        // atualiza as alturas
		no.setAltura(); 
		noDir.setAltura(); 

		return noDir; // retorna o no da direita
	}

	public static void main(String[] args) {
		try {
			AVL avl = new AVL();
			//int array[] = {4,35,10,13,3,30,15,12,7,40,20};
			int array[] = {1,2,3,4,5,6,7,8,9,10};
			for(int item: array){
				System.out.println("Inserindo -> " + item);
				avl.inserir(item);
				avl.caminharPre();
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
    }
}


