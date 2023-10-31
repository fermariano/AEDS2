class Celula {
    int elemento;
    Celula prox;

    Celula() {
        prox = null;
    }

    Celula(int x) {
        elemento = x;
        prox = null;
    }


    public int getElemento() {
        return this.elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public Celula getProx() {
        return this.prox;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }

}

public class QuicksortLS {
    Celula inicio, fim;
    int tam = 0;

    QuicksortLS() {
        inicio = fim = null;
    }

    void inserirInicio(int x) {
        if (inicio == null) {
            inicio = new Celula(x);
            fim = inicio;
        } 
        else {
            Celula aux = new Celula(x);
            aux.setProx(inicio);
            inicio = aux;
        }
        tam++;
    }

    void inserirFim(int x) {
        Celula tmp = inicio;
        while (tmp.getProx() != null) {
            tmp = tmp.getProx();
        }
        Celula aux = new Celula(x);
        tmp.setProx(aux);
        fim = aux;
        tmp = null;
        tam++;
    }

    void inserirPos(int x, int pos) throws NullPointerException {
        if (pos == 0) inserirInicio(x);
        else if (pos == tam-1) inserirFim(x);
        else if (pos < 0 || pos >= tam) throw new NullPointerException("Posição inválida");
        else {
            Celula tmp = inicio;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getProx();
            }

            Celula aux = new Celula(x);
            aux.setProx(tmp.getProx());
            tmp.setProx(aux);
            tam++;
        }
    }

    int removerInicio() throws NullPointerException {
        int elemento;
        if (inicio == null) throw new NullPointerException("Lista vazia");
        else {
            elemento = inicio.getElemento();
            inicio = inicio.getProx();
        }
        tam--;
        return elemento;
    }

    int removerFim() throws NullPointerException {
        int elemento;
        if (inicio == null) throw new NullPointerException("Lista vazia");
        else {
            Celula tmp = inicio;
            while(tmp.getProx().getProx() != null) {
                tmp = tmp.getProx();
            }
            elemento = tmp.getProx().getElemento();
            fim = tmp;
            tmp.setProx(null);
        }
        tam--;
        return elemento;
    }

    int removerPos(int pos) throws NullPointerException {
        int elemento = 0;
        if (inicio == null) throw new NullPointerException("Lista vazia");
        else if (pos == 0) removerInicio();
        else if (pos == tam-1) removerFim();
        else {
            Celula aux = inicio;
            for (int i = 1; i < pos; i++) {
                aux = aux.getProx();
            }
            elemento = aux.getProx().getElemento();
            aux.setProx(aux.getProx().getProx());
        }
        return elemento;
    }

    void mostrar() {
        System.out.print("[ ");
        Celula aux = inicio;
        while (aux != null) {
            System.out.print(aux.getElemento() + " ");
            aux = aux.getProx();
        }
        System.out.print("]\n");
    }

     void swap(Celula a, Celula b) {
        Celula aux = new Celula(a.getElemento());
        a.setElemento(b.getElemento());
        b.setElemento(aux.getElemento());
     }

     void quicksort() { // metodo so pra chamar primeiro
        quicksort(inicio, fim);
     }

     void quicksort(Celula ini, Celula end) { // metodo verdadeiro
        Celula i = ini; // cria uma celula no inicio
        Celula divisor = ini; // coloca um divisor que começa em inicio tambem (todos antes dele sao menores e depois sao maiores)
        int pivo = ini.getElemento(); // pega o pivo sendo o primeiro elemento

        while (i != null) { // enquanto nao chega no final
            if (i.getElemento() < pivo) { // testa se o elemento é menor que o pivo
                swap(i, divisor); // se for ele troca os dois
                i = i.getProx(); // anda com o i
                divisor = divisor.getProx(); // anda com o divisor
                mostrar(); // mostra bonitin so pra ver
            } else {
                i = i.getProx(); // se for maior ou igual ele so anda com o i
            }
        }

        if (ini != divisor) { // chama o subarray da esquerda
            quicksort(ini, divisor);
        }
 
        if (end != divisor) { // chama o subarray da direita
            quicksort(divisor.getProx(), end);
        }

     }
    
}
