class No {
    int elemento;
    No dir, esq;

    No() {
        dir = esq = null;
        elemento = -1;
    }

    No(int x) {
        dir = esq = null;
        elemento = x;
    }


    public int getElemento() {
        return this.elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getDir() {
        return this.dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public No getEsq() {
        return this.esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

}

public class Arvore {
    No inicio;

    Arvore() {
        inicio = null;
    }

    // inserir com passagem de pai
    // esse serve para testar a raiz
    void inserir(int x) { // metodo que recebe o numero a ser inserido apenas 
        if (inicio == null) { // testa se ela ta vazia
            inicio = new No(x); // se river ela seta a raiz como o novo no
        } else if (x < inicio.getElemento()) { // se nao tiver, testa se o elemento é menor
            inserir(x, inicio, inicio.getEsq()); // se for chama o outro metodo (que tem pai e filho) passando os respectivos nós
        } else if (x > inicio.getElemento()) { // se o elemento for maior
            inserir(x, inicio, inicio.getDir()); // faz a mesma coisa com a direita
        }
    }

    // esse testa os elementos abaixo da raiz
    void inserir(int x, No pai, No filho) {

        if (filho == null) { // "condição de parada" -> o filho ser null = achar um espaço livre para inserir
            filho = new No(x); // ai ele insere
            // aqui embaixo ele seta a ligaçao do pai
            if (x > pai.getElemento()) { // se for maior
                pai.setDir(filho); // ele seta na direita
            } else if (x < pai.getElemento()) { // se for menor
                pai.setEsq(filho); // ele seta na esquerda
            }
            // se nao achar um livre ele chama a função de novo descendo com o pai e o filho
        } else {
            if (x < filho.getElemento()) { // se o elemento for menor que o filho
                inserir(x, filho, filho.getEsq()); // chama andando pra esquerda
            } else if (x > filho.getElemento()) { // se for maior que o filho
                inserir(x, filho, filho.getDir()); // chama andando pra direita
            }
            
        }
      }

      No getMenorDir(No i) {
        No pai = i.getDir(); // seta o pai como a direita (porque é o menor da DIREITA!)
        No filho = pai; // seta o filho igual ao pai

        while (filho.getEsq() != null) { // anda com o filho ate achar o menor (ate nao existir mais esquerda)
            pai = filho;
            filho = filho.getEsq();
        }

        if (pai == filho) { // se ele nao andou nada é pq tem um so (tipo o filho nao tem filho)
            i.setDir(pai.getDir()); // ai ele so seta mesmo
        } else {
            pai.setEsq(filho.getDir()); // se ele andou é pq pegou certinho o menor filho. ai seta que a esquerda do pai (pq é menor) é a direita do filho
            // ele pula o filho
        }


        return filho;
      }

      // remover caminhando o pai e o filho
      void remover(int x) { // essa função chama passando o inicio
        if (inicio == null) throw new NullPointerException("Árvore vazia"); // se o inicio tiver null a arvore ta vazia
        else if (x < inicio.getElemento()) remover(x, inicio.getEsq(), inicio); // se o elemento for menor, chama a função pra esquerda
        else if (x > inicio.getElemento()) remover(x, inicio.getDir(), inicio); // se o elemento for maior, chama a função pra direita
        else { // se achar o elemento
            if (inicio.getDir() == null) { // se o da direita for null
                inicio = inicio.getEsq(); // seta a raiz como esquerda
            } else if (inicio.getEsq() == null) { // se a esuqerda for null
                inicio = inicio.getDir(); // seta a raiz como direita
            } else { // se tiver os dois filhos
                inicio.setElemento(getMenorDir(inicio).getElemento()); // chama a funçao de pegar o menor da direita
            }
        }
      }      

      void remover(int x, No i, No pai) throws NullPointerException {
            if (x == i.getElemento()) { // essa é a condição de parada -> quando acha o elemento que quer remover
            if (x < pai.getElemento()) { // se o elemento for menor que o pai
                if (i.getDir() == null) {  // se ele nao tiver o filho da direita
                    pai.setEsq(i.getEsq()); // seta o filho como a esquerda
                } else if (i.getEsq() == null) { // se ele nao tiver o filho da esquerda
                    pai.setEsq(i.getDir()); // seta o filho como a direita
                } else { // se ele tiver os dois filhos
                    int novo = getMenorDir(i).getElemento(); // chama a funçao getMenorDir para pegar o menor da direita e ja refaz a ligação
                    i.setElemento(novo); // coloca o novo elemento onde o outro foi removido
                }
            } else if (x > pai.getElemento()) { // se o elemento for maior que o pai
                if (i.getDir() == null) { // se ele nao tiver o filho da direita
                    pai.setDir(i.getEsq()); // seta o filho como esquerda
                } else if (i.getEsq() == null) { // se ele nao tiver o filho da esquerda
                    pai.setDir(i.getDir()); // seta o filho como direita
                } else {
                    int novo = getMenorDir(i).getElemento(); // chama a funçao getMenorDir para pegar o menor da direita e ja refaz a ligação
                    i.setElemento(novo); // coloca o novo elemento onde o outro foi removido
                }
            } 
            } 
            // se nao tiver achado o elemento
            else if (x < i.getElemento()) { // se ele for menor
                remover(x, i.getEsq(), i); // caminha pra esquerda
            } else if (x > i.getElemento()) { // se ele for maior
                remover(x, i.getDir(), i); // caminha pra direita
            }
        

      }

      void caminharCentral() {
        caminharCentral(inicio);
        System.out.println("\n");
      }
      
      void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
         
        }

        
       
    }
    

