class No {
    No esq;
    No dir;
    int elemento;

    No() {
        esq = dir = null;
        elemento = -1;
    }

    No(int x) {
        esq = dir = null;
        elemento = x;
    }

    public No getEsq() {
        return this.esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return this.dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public int getElemento() {
        return this.elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

}

class Tree {
    No raiz;

    Tree() {
        raiz = null;
    }

    void inserir(int x) {
        if (raiz == null) {
            No tmp = new No(x);
            raiz = tmp;
        } else if (x < raiz.getElemento()) {
            inserir(raiz, raiz.getEsq(), x);
        } else if (x > raiz.getElemento()) {
            inserir(raiz, raiz.getDir(), x);
        }
            
    }

    void inserir(No pai, No filho, int x) {

        if (filho == null) {
            filho = new No(x);

            if (x < pai.getElemento()) {
                pai.setEsq(filho);
            } else if (x > pai.getElemento()) {
                pai.setDir(filho);
            }

        } else if (x < filho.getElemento()) {
            inserir(filho, filho.getEsq(), x);
        } else if (x > filho.getElemento()) {
            inserir(filho, filho.getDir(), x);
        }

    }

    No getMenorDir(No i) {
        No pai = i.getDir();
        No filho = i; // pai.getEsq();

        while (filho.getEsq() != null) {
            filho = filho.getEsq();
            pai = filho;
        }

        if (filho.getDir() == null) {
            pai.setEsq(null);
        } else {
            pai.setEsq(filho.getDir());
        }

        if (pai == filho) {
            i.setEsq(null);
        }

        return filho;


    }

    void remover(int x) throws NullPointerException {
        if (raiz == null) throw new NullPointerException("Arvore vazia");
        else if (x < raiz.getElemento()) remover(x, raiz, raiz.getEsq()); // elemento é menor
        else if (x > raiz.getElemento()) remover(x, raiz, raiz.getDir()); // elemento é maior
        else { // elemento é igual
            if (raiz.getDir() == null) {
                raiz = raiz.getEsq();
            } else if (raiz.getEsq() == null) {
                raiz = raiz.getDir();
            } else {
               raiz.setElemento(getMenorDir(raiz).getElemento());
            }
        }
    }

    void remover(int x, No filho, No pai) {
        if (x == filho.getElemento()) {
            if (x > pai.getElemento()) {
                if (filho.getDir() == null) {
                    pai.setDir(filho.getEsq());
                } else if (filho.getEsq() == null) {
                    pai.setDir(filho.getDir());
                } else {
                    pai.setElemento(getMenorDir(raiz).getElemento());
                }
            } else if (x < pai.getElemento()) {
                if (filho.getDir() == null) {
                    pai.setEsq(filho.getEsq());
                } else if (filho.getEsq() == null) {
                    pai.setEsq(filho.getDir());
                } else {
                    pai.setElemento(getMenorDir(raiz).getElemento());
                }
            }
        } else if (x < filho.getElemento()) {
            remover(x, filho.getEsq(), filho);
        } else if (x > filho.getElemento()) {
            remover(x, filho.getDir(), filho);
        }
    }

    void mostrarCentral() {
        mostrarCentral(raiz);
        System.out.println();
    }

    void mostrarCentral(No i) {
        if (i != null) {
            mostrarCentral(i.getEsq());
            System.out.print(i.getElemento() + " ");
            mostrarCentral(i.getDir());
        }
        
    }

    void mostrarCentralInvertido() {
        mostrarCentralInvertido(raiz);
        System.out.println();
    }

    void mostrarCentralInvertido(No i) {
        if (i != null) {
            mostrarCentralInvertido(i.getDir());
            System.out.print(i.getElemento() + " ");
            mostrarCentral(i.getEsq());
        }
    }

    boolean pesquisar(int x) {
        boolean resp = false;
        if (raiz.getElemento() == x) {
            resp = true;
        } else {
            if (x < raiz.getElemento()) {
                resp = pesquisar(x, raiz.esq, resp);
            } else if (x > raiz.getElemento()) {
                resp = pesquisar(x, raiz.dir, resp);
            }
        }
        return resp;
    }

    boolean pesquisar (int x, No i, boolean resp) {
        if (i != null) {
            if (x == i.getElemento()) {
                resp = true;
            } else if (x < i.getElemento()) {
                pesquisar(x, i.esq, resp);
            } else if (x > i.getElemento()) {
                pesquisar(x, i.dir, resp);
            }
        }
        return resp;
    }
    
}

class Celula {
    private int elemento;
    private Celula prox;

    Celula() {
        prox = null;
    }

    Celula(int x) {
        elemento = x;
        prox = null;
    }

    void setElemento(int x) {
        elemento = x;
    }

    int getElemento() {
        return elemento;
    }

    void setProx(Celula i) {
        prox = i;
    }

    Celula getProx() {
        return prox;
    }
}

// lista com nó cabeça    
class ListaSimples {
    private Celula inicio, fim;
    private int tam;

    ListaSimples() {
        inicio = new Celula(); // cria a celula cabeça
        fim = inicio;
        tam = 1; // 1 pq tem a celula cabeça
    }

    int getTam() {
        return tam;
    }

    boolean isVazia() {
        if (inicio == fim) return true;
        else return false;
    }

    // inserir no inicio da lista
    void inserirInicio(int x) {
        Celula aux = new Celula(x); // cria a celula a ser inserida
        aux.setProx(inicio.getProx()); // coloca que o proximo da inserida é o proximo do primeiro (enfia ela la no meio)
        inicio.setProx(aux); // o proximo do inicio passa a ser a celula inserida
        if (inicio == fim) fim = fim.getProx(); // se for o primeiro elemento ele pula o fim
        tam++; // atualiza o tamanho
    }

    // inserir no final
    void inserirFim(int x) {
        Celula aux = new Celula(x); // cria a celula a ser inserida
        fim.setProx(aux); // coloca que o proximo do fim é a celula inserida
        fim = aux; // passa o fim pra frente
        tam++; // atualiza o tamanho
    }

    // inserir inicio (insere no nó cabeça e cria uma nova celula cabeça )
    void inserirInicioC(int x) {
        inicio.setElemento(x);
        Celula aux = new Celula();
        aux.setProx(inicio);
        inicio = aux;
        aux = null;
        tam++;
    }

    // inserir em qualquer posiçao
    void inserirPos(int x, int pos) throws NullPointerException {
        if (pos == 0) inserirInicio(x); // se pedir pra inserir no inicio chama a funçao ne
        else if (pos == getTam() - 1) inserirFim(x); // mesma coisa com o fim
        else if (pos < 0 || pos > getTam()-1) throw new NullPointerException("Posição inválida"); // se colocar uma posiçao que nao existe da erro
        else {
            int cont = pos; // cria um contador com a posiçao
            Celula i = inicio.getProx(); // coloca uma celula auxiliar na primeira posiçao valida

            while(cont > 2) { // esse while leva a celula ate uma posiçao antes da que voce quer inserir (2 por causa da posiçao antes e ignoramos a cabeça)
                i = i.getProx();
                cont--;
            }

            Celula aux = new Celula(x); // cria a celula que vai ser inserida
            aux.setProx(i.getProx()); // coloca que o proximo dela é o proximo da celula atual da posiçao
            i.setProx(aux); // proximo da celula anterior é igual a ela

            tam++; // atualiza o tamanho
            

        }

        
    }

    // remove do inicio obvio (tira fisicamente)
    int removerInicioF() throws NullPointerException {
        if (isVazia()) throw new NullPointerException ("Vazia");
        Celula i = inicio.getProx(); // seta uma celula i pra primeira valida (a que vai ser removida)
        int elemento = i.getElemento(); // salva o elemento pra retornar
        inicio.setProx(i.getProx()); // pula a celula removida
        i = null; // limpaaa
        tam--; // atualiza o tamanho
        return elemento; // e retorna
    }

    // remove do inicio mas so pula o inicio
    int removerInicio() {
        if (isVazia()) throw new NullPointerException ("Vazia");
        Celula i = inicio.getProx(); // coloca a celula i na que vai ser removida
        int elemento = i.getElemento(); // pega o elemento que vai ser removido
        inicio = i; // pula o inicio pra frente
        i = null; // limpeza
        tam--; // atualiza o tamanho
        return elemento;
    }

    // remover do final
    int removerFim() {
        if (isVazia()) throw new NullPointerException ("Vazia");
        Celula i = inicio; // coloca uma celula no inicio
        int pos = getTam()-1; // pega o valor da ultima posiçao

        while (pos > 1) { // anda ate o penultimo
            i = i.getProx();
            pos--;
        } 

        int elemento = i.getProx().getElemento(); // pega o elemento que vai ser tirado

        fim = i; // coloca o fim sendo o penultimo
        i.setProx(null); // limpa
        i = null; // limpa
       
        tam--; // atualiza o tamanho
        return elemento; // retorna

    }

    // remover na posiçao que quer
    int removerPos(int pos) {
        int elemento;
        if (isVazia()) throw new NullPointerException ("Vazia"); // testa se ta vazia
        else if (pos < 0 || pos > getTam()-1) throw new NullPointerException("Tamanho inválido"); // se tiver passado tamanho invalido
        else if (pos == 0) elemento = removerInicio(); // se tiver passado a primeira posiçao remove do inicio
        else if (pos == getTam()-1) elemento = removerFim(); // se tiver passado a ultima posiçao remove do final
        else {
            Celula i = inicio; // coloca uma celula no inicio
            int cont = 1; // controle pra caminhar

            while (cont < pos) { // anda ate a celula antes da posiçao que quer
                i = i.getProx();
                cont++;
            }

            elemento = i.getProx().getElemento(); // pega o elemento que vai ser removido
            i.setProx(i.getProx().getProx()); // // pula a celula do elemento

            tam--; // atualiza o tamanho

        }
            return elemento;
    }
    
    // mostrar a lista
    void mostrar() {
        Celula i = inicio.getProx();
        System.out.print("[ ");
        while (i != null) {
            System.out.print(i.getElemento() + " ");
            i = i.getProx();
        }
        System.out.print("]\n");
    }    

    boolean pesquisar(int x) {
        Celula i = inicio.getProx();
        while (i != null) {
            if (i.getElemento() == x) return true;
            i = i.getProx();
        }
        return false;
    }



    
}

class HashInside {
    int tam = 10;
    int[] hash = new int[tam];
    Tree reserva = new Tree();

    HashInside() {
        for (int i = 0; i < tam; i++) {
            hash[i] = -1;
        }
    }

    int calcPos(int x) {
        return x % tam;
    }

    int rehash(int x) {
        return (x+1) % tam;
    }

    void inserir(int x) {
        if (hash[calcPos(x)] == -1) {
            hash[calcPos(x)] = x;
        } else if (hash[rehash(x)] == -1) {
            hash[rehash(x)] = x;
        } else {
            reserva.inserir(x);
        }
    }

    void mostrar() {
        for (int i : hash) {
            if (i != -1) System.out.print(i + " ");
        }
        System.out.print("\nÁrvore: ");
        reserva.mostrarCentral();
    }

    boolean pesquisar(int x) {
        boolean resp = false;
        if (hash[calcPos(x)] == x) {
            resp = true;
        } else if (hash[rehash(x)] == x) {
            resp = true;
        } else {
            resp = reserva.pesquisar(x);
        }
        return resp;
    }
}

public class Hashtable {
    int tam = 10;
    int[] hash = new int[tam];
    int[] reserva = new int[3];

    ListaSimples lista = new ListaSimples();
    Tree arvoreRes = new Tree();
    HashInside hashDentro = new HashInside();
    

    Hashtable() {
        for (int i = 0; i < tam; i++) {
            hash[i] = -1;
        }

        for (int i = 0; i < 3; i++) {
            reserva[i] = -1;
        }
    }

    int calcPos(int x) {
        return x % tam;
    }

    int rehash(int x) {
        return (x+1) % tam;
    }

    int hashReserva(int x) {
        return x % 3;
    }

    void inserir(int x) {
        if (hash[calcPos(x)] == -1) {
            hash[calcPos(x)] = x;
        } else {
            if (hashReserva(x) == 0) {
                hashDentro.inserir(x);
            } else if (hashReserva(x) == 1) {
                lista.inserirFim(x);
            } else if (hashReserva(x) == 2) {
                arvoreRes.inserir(x);
            }
        }
    }

    boolean pesquisar(int x) {
        boolean resp = false;
        if (hash[calcPos(x)] == x) {
            resp = true;
        } else {
            if (hashReserva(x) == 0) {
                resp = hashDentro.pesquisar(x);
            } else if (hashReserva(x) == 1) {
                resp = lista.pesquisar(x);
            } else if (hashReserva(x) == 2) {
                resp = arvoreRes.pesquisar(x);
            }
        }
        return resp;
    }

    void remover() {

    }

    void mostrar() {
        System.out.print("Hash principal: ");
        for (int i : hash) {
           if (i != -1) System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Reserva: ");
        System.out.println("Posição 0:");
        System.out.print("Hash: ");
        hashDentro.mostrar();

        System.out.println("Posição 1: ");
        lista.mostrar();

        System.out.println("Posição 2");
        arvoreRes.mostrarCentral();
    }

    public static void main(String[] args) {
        Hashtable hash = new Hashtable();

        hash.inserir(0);
        hash.inserir(10);
        hash.inserir(58);
        hash.inserir(7);
        hash.inserir(28);
        hash.inserir(9);            
        hash.inserir(18);
        hash.mostrar();
    }
    
    
}
