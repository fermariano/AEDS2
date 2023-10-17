class Celula {
    private int elemento;
    private Celula prox;

    Celula() {
        prox = null;
    }

    Celula(int ee) {
        elemento = ee;
    }

    void setElemento(int x) {
        elemento = x;
    }

    int getElemento() {
        return elemento;
    }

    void setProx(Celula cc) {
        prox = cc;
    } 

    Celula getProx() {
        return prox;
    }

    void limpa(Celula tmp) {
        tmp.prox = null;
        tmp = null;
    }
    
}


public class Fila extends Celula {
    private Celula first, last;
    private int tam = 1; // começa com 1 pq tem a celula cabeça

    Fila() {
        first = new Celula(-1); // celula cabeça
        last = first;
    }

    int getTam() {
        return tam;
    }


    // inserir sempre no fim
    void inserir(int x) {
        Celula aux = new Celula(x); // cria a celula auxiliar
        last.setProx(aux); // coloca ela no ultimo
        last = last.getProx(); // pula o ultimo pra onde ela ta (atualiza o ultimo)
        tam++; // atualiza o tamanho
    }

    // remover sempre do inicio (esse so para de valer o elemento do primeiro)
    int remover() throws NullPointerException {
        if (first == last) throw new NullPointerException("Vazia");
        Celula i = first; // coloca uma celula (ponteiro) auxiliar em primeiro
        first = first.getProx(); // coloca o primeiro no proximo (agora ela é a celula cabeça)
        int elemento = first.getElemento(); // salva o elemento que ta em ultimo
        first.setElemento(-1); // só pra marcar a celula cabeça
        i.setProx(null);
        i = null;
        tam--; // atualiza o tamnaho
        return elemento;
    }

    // remover fisicamente a celula (esse retira a celula mesmo)
    int removerF() throws NullPointerException {
        if (first == last) throw new NullPointerException("Vazia"); // ta vazia
        Celula tmp = first.getProx(); // coloca uma celula auxiliar na primeira celula valida
        int elemento = tmp.getElemento(); // pega o elemento que vai remover
        first.setProx(first.getProx().getProx()); // pula a celula que vai ser removida e tira o ponteiro apontado pra ela
        tmp.setProx(null); // coloca null
        tmp = null; // coloca null
        tam--; // atualiza o tamanho
        return elemento;
    }

    // printar os elementos
    void mostrar() throws NullPointerException {
        if (first == last) throw new NullPointerException("Vazia");
        Celula i = first.getProx(); // cria uma celula auxiliar começando da celula valida (pula cabeça)
        System.out.print("[ ");
        while(i != null) { // enquanto a celula nao for nula
            System.out.print(i.getElemento() + " "); // printa o elemento
            i = i.getProx(); // vai pro proximo
        }
        System.out.print(" ]\n");
    }

    // pegar o maior elemento da fila
    int maior() throws NullPointerException {
        if (first == last) throw new NullPointerException("Vazia");// fila vazia
        Celula i = first.getProx(); // coloca uma celula auxiliar no primeiro elemento valido (pula a cabeça)
        int maior = i.getElemento(); // seta o maior como o primeiro elemento
        while (i != null) {
            if (i.getElemento() > maior) maior = i.getElemento(); // vai comparando com os outros
            i = i.getProx(); // pula os passos
        }
        return maior;
    }

    // pega o terceiro elemento da fila
    int terElemento() throws NullPointerException {
        int aux = getTam(); // pega o tamanho da fila
        if (first == last) throw new NullPointerException("Vazia");
        else if (aux < 3) throw new NullPointerException("Tamanho insuficiente");

        Celula i = first.getProx(); // coloca uma celula auxiliar
        int cont = 2; // pra parar no terceiro elemento
        while (cont > 0) {
            i = i.getProx(); // vai pulando
            cont--;
        }

        return i.getElemento(); // retorna o terceiro

    }

    // soma todos os elementos
    int soma() throws NullPointerException {
        if (first == last) throw new NullPointerException("Vazia"); // ta vazia
        int soma = 0; // variavel de soma
        Celula i = first.getProx(); // começa a contar da primeira celula valida (pula a cabeça)
        while (i != null) { // enquanto nao for vazia
            soma += i.getElemento(); // soma o elemento
            i = i.getProx(); // pula
        }
        return soma;
    }

    // inverter os elementos 
    void inverter() throws NullPointerException {
        if (first == last) throw new NullPointerException("Ta vazia"); // vazia
        Celula fim = last;

        while(first.getProx() != fim) { // fim vai andando pra frente de tabela e para quando fica no primeiro elemento valido
            Celula nova = new Celula(first.getProx().getElemento()); // cria uma nova celula com o elemento do primeiro
            nova.setProx(fim.getProx()); // fala que a nova celula (com o elemento do primeiro) aponta pro proximo do fim 
            fim.setProx(nova); // seta o proximo do fim na nova celula (agora a nova celula é a ultima)
            Celula i = first.getProx(); // so para marcar o elemento que vai ser removido (o primeiro que foi jogado la atras)
            first.setProx(first.getProx().getProx()); // coloca o proximo da cabeça sendo o segundo elemento
            i.setProx(null); // nulooo
            i = nova = null; // coloca nulo as temporarias
            if (last == fim )last = last.getProx(); // na primeira execuçao ele atualiza o ultimo
        }
        fim = null; // coloca n fim como null pq nao vai usar mais
    }

    // contar os elementos pares e multiplos de 5 recursivo
    int contadorChama() throws NullPointerException {
        if (first == last) throw new NullPointerException("Vazia");
        return contador(first.getProx());
    }

    int contador(Celula i) {
        int cont; // contador para contar!
        if (i == null) { // condiçao de parada (quando chega no final)
            cont = 0; // retorna 0 
        } else if (i.getElemento() % 2 == 0 || i.getElemento() % 5 == 0) { // quando o elemento encaixa no que foi pedido
            cont = 1 + contador(i.getProx()); // soma 1 na variavel e chama de novo somando o proximo
        }  else { // caso contrario
            cont = contador(i.getProx()); // so chama de novo sem somar
        }
        return cont;
    }

    // metodo que nao faz NADA
    void fazNada() {
        Celula fim = last;
        while (first != fim) {
            Celula aux = new Celula(first.getProx().getElemento());
    
            last.setProx(aux);
            
    
            Celula tmp = first;
            first = first.getProx();
    
            tmp.setProx(null);
            tmp = null;

           last = last.getProx();
        }
        fim = null;
    }

    // receber uma pilha e colocar ela em uma fila
    Celula toFila(Celula topo) throws NullPointerException {

        if (topo == null) throw new NullPointerException("Vazia");

        Fila nova = new Fila();
        Celula tmp = topo.getProx();
        while(tmp != null) {
            nova.inserir(tmp.getElemento());
            if (first == null) first = tmp;
            last = tmp = tmp.getProx();
        }
        
        return first;

    }

    // mostrar em uma celula especifica
    void mostrar(Celula i) throws NullPointerException {
        System.out.print("[ ");
        while(i != null) { // enquanto a celula nao for nula
            System.out.print(i.getElemento() + " "); // printa o elemento
            i = i.getProx(); // vai pro proximo
        }
        System.out.print(" ]\n");
    }
}
