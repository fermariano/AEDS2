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

    int getElemento() {
        return elemento;
    }

    void setElemento(int x) {
        elemento = x;
    } 

    Celula getProx() {
        return prox;
    }

    void setProx(Celula i) {
        prox = i;
    }

    void clearCelula(Celula i) {
        i.prox = null;
        i = null;
    }
}

public class LSOrdenada {
    private Celula inicio, fim;
    private int tam;

    LSOrdenada() {
        inicio = new Celula();
        fim = inicio;
    }

    int getTam() {
        return tam;
    }

    // insere no inicio
    void inserirInicio(int x) {
        Celula aux = new Celula(x);
        aux.setProx(inicio.getProx()); // primeira inserção vai dar null
        inicio.setProx(aux);
        if (inicio == fim) fim = fim.getProx();
        tam++;
        
    } 

    // insere no fim
    void inserirFim(int x) {
        Celula aux = new Celula(x);
        fim.setProx(aux);
        fim = aux;
        tam++;
    }

    // insere ordenadamente
    void inserir(int x) {
        Celula i = inicio.getProx();
        if (inicio == fim) { // se tiver vazia insere normal
            Celula aux = new Celula(x);
            inicio.setProx(aux);
            fim = aux;
            tam++;
        } else if (x < i.getElemento()) inserirInicio(x); // se ela for menor que o primeiro elemento insere no inicio
        else if (x > fim.getElemento())  inserirFim(x); // se ela for maior que o ultimo elemento insere no final
        else { // se tiver no meiao
            while (x > i.getProx().getElemento() && i != null) { // anda ate achar um valor maior que ela
                i = i.getProx();
            }
            Celula aux = new Celula(x); // insere
            aux.setProx(i.getProx());
            i.setProx(aux);
            tam++;
        }   
    }

    // remove no inicio
    int removerInicio() throws NullPointerException {

        if (inicio == fim) throw new NullPointerException("Vazia");

        int elemento = inicio.getProx().getElemento();

        inicio.setProx(inicio.getProx());
        inicio = inicio.getProx();

        tam--;
        return elemento;
    }

    // remove no final
    int removerFim() throws NullPointerException {
        if (inicio == fim) throw new NullPointerException("Vazia");

        int cont = getTam()-1;
        Celula i = inicio;
        int elemento = fim.getElemento();

        while (cont > 0) {
            i = i.getProx();
            cont--;
        }

        fim = i;
        fim.setProx(null);
        tam--;
        return elemento;
    }

    // printa 
    void mostrar() {
        Celula i = inicio.getProx();
        System.out.print("[ ");
        while (i != null) {
            System.out.print(i.getElemento() + " ");
            i = i.getProx();
        }
        System.out.print("]\n");
    }



}
