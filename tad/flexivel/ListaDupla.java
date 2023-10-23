class CelulaDupla {
    int elemento;
    CelulaDupla prox;
    CelulaDupla ant;

    CelulaDupla() {
        prox = ant = null;
    }

    CelulaDupla(int x) {
        elemento = x;
        prox = ant = null;
    }

    void setProx(CelulaDupla i) {
        prox = i;
    }

    CelulaDupla getProx() {
        return prox;
    }

    void setAnt(CelulaDupla aux) {
        ant = aux;
    }

    CelulaDupla getAnt() {
        return ant;
    }

    void setElemento(int x) {
        elemento = x;
    }

    int getElemento() {
        return elemento;
    }
}

public class ListaDupla {
    CelulaDupla inicio, fim;
    int tam = 1;

    ListaDupla() {
        inicio = new CelulaDupla();
        fim = inicio;
    }

    int getTam() {
        return tam;
    }

    void inserirInicio(int x) {
        CelulaDupla aux = new CelulaDupla(x);
        aux.setAnt(inicio);
        aux.setProx(inicio.getProx());
        inicio.setProx(aux);
        if (inicio == fim) fim = aux;
        tam++;

    }

    void inserirFim(int x) {
        CelulaDupla aux = new CelulaDupla(x);
        fim.setProx(aux);
        aux.setAnt(fim);
        fim = aux;
        tam++;
    }

    void inserirPos(int x, int pos) throws NullPointerException {
        if (pos == 0) inserirInicio(x);
        else if (pos == getTam() - 1) inserirFim(x);
        else if (pos < 0 || pos >= getTam()) throw new NullPointerException("Posição inválida");
        else {
            CelulaDupla i = inicio.getProx();
            CelulaDupla aux = new CelulaDupla(x);
    
            while(pos > 1) {
                i = i.getProx();
                pos--;
            }

            
            aux.setAnt(i);
            aux.setProx(i.getProx());
            i.getProx().setAnt(aux);
            i.setProx(aux);


            tam++;

        }

    }

    int removerInicio() throws NullPointerException {
        if (inicio == fim) throw new NullPointerException("Vazia");
        int elemento = inicio.getProx().getElemento();


        CelulaDupla i = inicio;
        inicio = inicio.getProx();
        inicio.setAnt(null);
        i.setProx(null);
        i = null;


        return elemento;
    }

    int removerFim() throws NullPointerException {
        if (inicio == fim) throw new NullPointerException("Vazia");

        int elemento = fim.getElemento();
        CelulaDupla i = fim;

        fim = fim.getAnt();
        fim.setProx(null);
        
        

        return elemento;

    }

    int removerPos(int pos) throws NullPointerException {
        int elemento = 0;
        if (inicio == fim) throw new NullPointerException("Vazia");
        CelulaDupla i = inicio.getProx();
        if (pos == 0) elemento = removerInicio();
        else if (pos == getTam()-1) elemento = removerFim();
        else if (pos < 0 || pos > getTam()) throw new NullPointerException("Posição inválida");
        else {
            while (pos > 1) {
                i = i.getProx();
                pos--;
            }

            CelulaDupla aux = i.getProx();
            elemento = aux.getElemento();
            i.setProx(aux.getProx());
            aux.getProx().setAnt(i);


        }

        return elemento;


    }

    void mostrar() {
        CelulaDupla i = inicio.getProx();

        System.out.print("[ ");
        while (i != null) {
            System.out.print(i.getElemento() + " ");
            i = i.getProx();
        }
        System.out.print("]\n");
    }
    
    
}
