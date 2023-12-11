class NoAB { // no da arvore
	public char elemento; // o caractere do no
	public NoAB esq, dir; // esq dir padrao
    public No no; // o no que faz referencia a TRIE

	public NoAB() { // construtor vazio
      this.elemento = 0;
      this.esq = null;
      this.dir = null;
      this.no = null;
	}

	public NoAB(char elemento) { // construtor que recebe um char
      this.elemento = elemento; // seta o elemento no nozinho
      this.esq = null;
      this.dir = null;
      this.no = new No(elemento); // cria um no da trie com esse elemento
	}
}


class No { // no da TRIE
   public char elemento; // letra correspondente
	private NoAB raiz; // arvore que guarda as proximas letras
   public boolean folha; // pra saber se é folha
   
   public No (){ // construtor vazio
      this(' ');
   }

   public No (char elemento){ // construtor que recebe a letra
      this.elemento = elemento; // seta o elemento
		raiz = null;
        folha = false;
   }

   public No inserir(char x) throws Exception { // insere dentro da arvore dentro do no 
		raiz = inserir(x, raiz); // chama a função recursiva passando a raiz
        return pesquisar(x); // retorna o pesquisar
	}

	private NoAB inserir(char x, NoAB i) throws Exception { // insere um no dentro da arvore dentro do no da trie (um inserir normal)
		if (i == null) { // quando achar a folha
         i = new NoAB(x); // cria o no de dentro

      } else if (x < i.elemento) { // se o elemento for menor que o do no
         i.esq = inserir(x, i.esq); // chama andando pra esquerda

      } else if (x > i.elemento) { // se o elemento for maior que o do no
         i.dir = inserir(x, i.dir); // chama pra direita 

      } else {
         throw new Exception("Erro ao inserir!");
      }

		return i;
	}

	public No pesquisar(char x) { // chamada recursiva do pesquisar
		return pesquisar(x, raiz);
	}

	private No pesquisar(int x, NoAB i) { // nesse pesquisar ele retorna o ponteiro para a letra da arvore TRIE
      No resp;
		if (i == null) { // se nao encontrar o elemento
         resp = null; // retorna nulo

      } else if (x == i.elemento) { // se for igual ao elemento
         resp = i.no; // ele coloca que resp é o no

      } else if (x < i.elemento) { // se o procurado por menor ele chama recursivamente pra esquerda
         resp = pesquisar(x, i.esq);

      } else { // se o pesquisado for maior ele chama recursivamente pra direita
         resp = pesquisar(x, i.dir);
      }
      return resp; // retorna o no
	}

   public void setFilhoFolha(char x){
      setFilhoFolha(x, raiz);
   }
   public void setFilhoFolha(char x, NoAB i){
		if (i == null) {
         //nada...

      } else if (x == i.elemento) {
         i.no.folha = true;

      } else if (x < i.elemento) {
         setFilhoFolha(x, i.esq);

      } else {
         setFilhoFolha(x, i.dir);
      }
   }

	public int getN() {
      return getN(raiz);
	}
	private int getN(NoAB i) {
      int resp = 0;
		if (i != null) {
         resp = 1 + getN(i.esq) + getN(i.dir);
		}
      return resp;
	}

   public No[] getFilho(){
      int n = getN();
      No[] vet = new No[n];
      getFilho(vet, 0, raiz);
      return vet;
   }

   public int getFilho(No[] vet, int pos, NoAB i){
      if(i != null){
         vet[pos++] = i.no;
         pos = getFilho(vet, pos, i.esq);
         pos = getFilho(vet, pos, i.dir);
      }
      return pos;
   }
}

public class Trie { // classe da arvore principal
    private No raiz; // raiz da arvore

    public Trie(){
        raiz = new No();
    }

    public void inserir(String s) throws Exception { // metodo inserir passando a string
        inserir(s, raiz, 0);
    }

    private void inserir(String s, No no, int i) throws Exception {
        No filho = no.pesquisar(s.charAt(i)); // pesquisa na arvore dentro do no pra saber se a letra existe
        if(filho == null){ // se nao existir
            filho = no.inserir(s.charAt(i)); // voce cria o no dentro da arvore binaria

            if(i == s.length() - 1){ // se for a ultima letra da palavra
                no.setFilhoFolha(s.charAt(i)); // seta como folha
            }else{ // se nao for chama o inserir chamando a proxima letra
                inserir(s, filho, i + 1);
            }

        } else if (filho.folha == false && i < s.length() - 1){ // se nao for folha e nao tiver chegado no fim da palavra
            inserir(s, filho, i + 1); // chama o inserir passando a proxima letra

        } else {
            throw new Exception("Erro ao inserir!");
        } 
    }


    public boolean pesquisar(String s) throws Exception { // pesquisar passando a string
        return pesquisar(s, raiz, 0); // chama a raiz e o char 0 da string
    }

    public boolean pesquisar(String s, No no, int i) throws Exception {
        boolean resp; // boolean que vai ser retornado
        No filho = no.pesquisar(s.charAt(i)); // procura se existe o elemento na arvore
        if(filho == null){ // se nao existir
            resp = false; // retorna false
        } else if(i == s.length() - 1){ // se for o ultimo caractere da palavra
            resp = (filho.folha == true); // retorna true se for folha | false se nao for
        } else if(i < s.length() - 1 ){ // se nao for o ultimo caractere da palavra
            resp = pesquisar(s, filho, i + 1); // chama recursivamente o pesquisar 
        } else {
            throw new Exception("Erro ao pesquisar!");
        }
        return resp; // retorna o boolean
    }


    public void mostrar(){ // mostra a arvore toda aparentemente
        mostrar("", raiz); // passa a string e a raiz
    }

    public void mostrar(String s, No no) { // string e no
        if(no.folha == true){ // se o no for folha
            System.out.println("Palavra: " + (s + no.elemento)); // ele imprime a palavra
        } else { // se nao for a folha
            No[] filho = no.getFilho(); // cria um array de filhos
            for(int i = 0; i < filho.length; i++){ // percorre todo esse array
                 mostrar(s + no.elemento, filho[i]); // chama recursivamente o mostrar com cada elemento do array
            }
        }
    }

      public static void main (String[] args) throws Exception {
         Trie arv = new Trie();
   
         String array[] = new String[8];
         array[0] = "ABACAXI";
         array[1] = "BALA";
         array[2] = "BOLO";
         array[3] = "ABACATE";
         array[4] = "galo";
         array[5] = "pata";
         array[6] = "pato";
         array[7] = "gato";
   
         for(int i = 0; i < array.length; i++){
            arv.inserir(array[i]);
         }
   
         arv.mostrar();
         for(int i = 0; i < array.length; i++){
            System.out.println("Pesquisar(" + array[i] + "):" + arv.pesquisar(array[i]));
         }
   
         String s = "ABACA";
         System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
   
         s = "ABACAXIS";
         System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
   
         s = "gaga";
         System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
         
      }
   }

