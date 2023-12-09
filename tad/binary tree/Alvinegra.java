class NoAN { // classe do no da alvinegra
  public boolean cor; // cor do no: false para branco e true para preto
  public int elemento;
  public NoAN esq, dir;

  public NoAN() {
    this(-1);
  }

  public NoAN(int elemento) {
    this(elemento, false, null, null);
  }

  public NoAN(int elemento, boolean cor) {
    this(elemento, cor, null, null);
  }

  public NoAN(int elemento, boolean cor, NoAN esq, NoAN dir) {
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}

public class Alvinegra {
   private NoAN raiz; 

   public Alvinegra() {
      raiz = null;
   }

   // metodo recursivo do pesquisar (mesma coisa que todos os outros)
   public boolean pesquisar(int elemento) {
      return pesquisar(elemento, raiz); // chama passando o elemento a ser pesquisado e a raiz
   }

 
   private boolean pesquisar(int elemento, NoAN i) {
      boolean resp; // boolean que vai ser retornado
      if (i == null) { // se chegar no fim da arvore o elemento nao existe
         resp = false;
      } else if (elemento == i.elemento) { // aqui ele encontra o elemento
         resp = true;  // e seta o resp como true
      } else if (elemento < i.elemento) { // se o elemento for menor
         resp = pesquisar(elemento, i.esq); // chama recursivamente caminhando para a esquerda
      } else { // se o elemento for maior
         resp = pesquisar(elemento, i.dir); // chama recursivamente caminhando para a direita
      }
      return resp;
   }

   // imprime os elementos em ordem crescente
   public void caminharCentral() {
      System.out.print("[ ");
      caminharCentral(raiz);
      System.out.println("]");
   }

   private void caminharCentral(NoAN i) {
      if (i != null) {
         caminharCentral(i.esq); 
         System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); 
         caminharCentral(i.dir); 
      }
   }

   // imprime os pais primeiro e depois os filhos
   public void caminharPre() {
      System.out.print("[ ");
      caminharPre(raiz);
      System.out.println("]");
   }

   private void caminharPre(NoAN i) {
      if (i != null) {
         System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); 
         caminharPre(i.esq); 
         caminharPre(i.dir); 
      }
   }

   // imprime os filhos primeiro e depois os pais
   public void caminharPos() {
      System.out.print("[ ");
      caminharPos(raiz);
      System.out.println("]");
   }

   private void caminharPos(NoAN i) {
      if (i != null) {
         caminharPos(i.esq); 
         caminharPos(i.dir); 
         System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); 
      }
   }

   // metodo de inserir os tres primeiros elementos
   // ele insere ja balanceando manualmente
   public void inserir(int elemento) throws Exception {
      
      if (raiz == null) { // se a arvore estiver vazia ele insere na raiz
         raiz = new NoAN(elemento);
      } else if (raiz.esq == null && raiz.dir == null) { // se a arvore tiver so a raiz
         if (elemento < raiz.elemento) { // se o elemento for menor ele insere na esquerda
            raiz.esq = new NoAN(elemento);
         } else { // se o elemento for maior ele insere na direita
            raiz.dir = new NoAN(elemento);
         }
      } else if (raiz.esq == null) { // se ele tiver a raiz e o elemento da direita
         if (elemento < raiz.elemento) { // se o elemento for menor que a raiz
            raiz.esq = new NoAN(elemento); // ele insere na esquerda
         } else if (elemento < raiz.dir.elemento) { // se o elemento for maior que a raiz e menor que o da direita
            raiz.esq = new NoAN(raiz.elemento); // seta a esquerda sendo a raiz
            raiz.elemento = elemento; // coloca o elemento na raiz 
         } else { // se o elemento for maior que o filho da direita
            raiz.esq = new NoAN(raiz.elemento); // cria um no com o valor da raiz e insere na esquerda
            raiz.elemento = raiz.dir.elemento; // seta o elemento da raiz como o filho da direita
            raiz.dir.elemento = elemento; // seta o filho da direita como o novo elemento
         }
         raiz.esq.cor = raiz.dir.cor = false; // cololca todos os filhos como brancos
      } else if (raiz.dir == null) { // se a arvore tiver a raiz e o filho da esquerda
         if (elemento > raiz.elemento) { // se o elemento for maior que a raiz
            raiz.dir = new NoAN(elemento); //  ele coloca na direita e ja fica balanceado
         } else if (elemento > raiz.esq.elemento) { // se o elemento for menor que a raiz && maior que o filho da esquerda
            raiz.dir = new NoAN(raiz.elemento); // cria um no na direita e coloca a raiz la
            raiz.elemento = elemento; // seta a raiz como o elemento
         } else { // se o elemento for menor que o filho da esquerda
            raiz.dir = new NoAN(raiz.elemento); // cria um no na direita com o elemento da raiz
            raiz.elemento = raiz.esq.elemento; // seta a raiz como o filho da esquerda
            raiz.esq.elemento = elemento; // seta o filho da esquerda como o elemento
         }
         raiz.esq.cor = raiz.dir.cor = false; // coloca os filhos como branco
      } else { // se a arvore tiver tres ou mais elementos ele chama o inserçao com toda a arvore genealogica kkkk
        inserir(elemento, null, null, null, raiz); // passa o elemento a ser inserido
   }
}

    // FAMOSO BALANCEAR
   private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {
      
      if (pai.cor == true) { // o pai tem que ser preto o codigo todo ta dentro desse if
        
        // aqui ele tenta descobrir qual rotaçao é
         if (pai.elemento > avo.elemento) { // se o pai for maior que o avo 
            if (i.elemento > pai.elemento) { // se o i for maior que o pai (todo para a direita)
                // nota que vc sempre chama o avo porque voce rotaciona nele!
               avo = rotacaoEsq(avo); // rotaçao simples a esquerda
            } else { // se for o cotovelo
               avo = rotacaoDirEsq(avo); // rotaçao dupla direita-esquerda
            }
         } else { // se o pai for menor que o avo
            if (i.elemento < pai.elemento) { // se o elemento for menor que o pai quer dizer que ta tudo pra esquerda
               avo = rotacaoDir(avo); // ai rotaciona pra direita!
            } else { // se for cotovelo
               avo = rotacaoEsqDir(avo); // rotaciona esq-dir no avo
            }
         }
         // isso aqui é so pra arrumar os ponteiros dps do balanceamento
         if (bisavo == null) { // se o bisavo nao existir
            raiz = avo; // ele seta a raiz como o avo
         } else if (avo.elemento < bisavo.elemento) { // se o avo for menor que o bisavo
            bisavo.esq = avo; // ele seta o avo na perninha da esquerda do bisavo
         } else { // se o avo for maior que o bisavo
            bisavo.dir = avo; // ele seta o avo na direita do bisavo 
         }
         
         // no final do balanceamento ele seta o avo branco e os filhos coloridos
         avo.cor = false;
         avo.esq.cor = avo.dir.cor = true;
  
      } 
   }

   private void inserir(int elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
      if (i == null) { // quando acha o lugar pra ele ser inserido
         if (elemento < pai.elemento) { // se o elemento for menor que o pai
            // IMPORTANTE! sempre que voce for inserir o elemento a cor dele é true
            i = pai.esq = new NoAN(elemento, true); // ele coloca o i na esquerda do pai 
         } else { // se p elemento for maior que o pai 
            i = pai.dir = new NoAN(elemento, true); // ele coloca na direita
         }
         if (pai.cor == true) { // se o pai tambem for preto
            balancear(bisavo, avo, pai, i); // balancea o bisavo, avo e pai
         }
      } else { // se nao encontrou a folha pra inserir
         
         if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) { // se os dois filhos forem coloridos
            // inverte as cores
            i.cor = true;
            i.esq.cor = i.dir.cor = false;
            if (i == raiz) { // se o i for a raiz
               i.cor = false; // ele deixa a raiz branca pq ela é seeempre branca
            } else if (pai.cor == true) { // se o pai for preto tambem
               balancear(bisavo, avo, pai, i); // ele balanceia
            }
         }
         if (elemento < i.elemento) { // se o inserido for menor que o nó
            inserir(elemento, avo, pai, i, i.esq); // chama recursivamente para a esquerda
         } else if (elemento > i.elemento) { // se o inserido for maior que o no
            inserir(elemento, avo, pai, i, i.dir); // chama recursivamente pra direita
         } else { // se o elemento for igual ele da erro :(
            throw new Exception("Erro inserir (elemento repetido)!");
         }
      }
   }

   private NoAN rotacaoDir(NoAN no) { // rotaçao pra direita padrao que ja vimos
      NoAN noEsq = no.esq; // salva o ponteiro da esquerda
      NoAN noEsqDir = noEsq.dir; // salva o filho da direita do da esquerda

      // faz as respectivas trocas
      noEsq.dir = no; 
      no.esq = noEsqDir;

      // retorna o no da esquerda
      return noEsq;
   }

   private NoAN rotacaoEsq(NoAN no) { // rotaçao pra esquerda padrao que ja vimos tambem
      NoAN noDir = no.dir; // salva o ponteiro da direita
      NoAN noDirEsq = noDir.esq; // salva o filho da esquerda do da direita

      // faz as respectivas trocas
      noDir.esq = no;
      no.dir = noDirEsq;
      
      // retorna o filho da direita
      return noDir;
   }

   private NoAN rotacaoDirEsq(NoAN no) {
      no.dir = rotacaoDir(no.dir);
      return rotacaoEsq(no);
   }

   private NoAN rotacaoEsqDir(NoAN no) {
      no.esq = rotacaoEsq(no.esq);
      return rotacaoDir(no);
   }
}
