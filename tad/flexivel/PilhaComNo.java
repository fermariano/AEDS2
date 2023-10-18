class Celula {
    private int elemento;
    Celula prox;

    Celula() {
        elemento = -1;
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

    Celula getProx() {
        return prox;
    }

    void setProx(Celula i) {
        prox = i;
    }
}


class PilhaComNo {
    private Celula topo;

    PilhaComNo() {
        topo = new Celula(); // cria o topo com cabeça
    }

    Celula getTopo() {
        return topo;
    }

    void setTopo(Celula i) {
        topo = i;
    }

    // inserir sempre no inicio
    void inserir(int x) {
        Celula aux = new Celula(x); // celula que vai ser inserida
        aux.setProx(topo.getProx()); // coloca o prox dela apontando pro prox do topo
        topo.setProx(aux); // seta o prox do topo como aux (insere no inicio)
        aux = null;
    }

    // remover do inicio (topo)
    int remover() throws NullPointerException {
        if (topo.getProx() == null) throw new NullPointerException("Vazia");
        int elemento = topo.getProx().getElemento(); // salva o elemento que vai ser removido
        Celula i = topo; // coloca um ponteiro aqui so pra remover depois
        topo = topo.getProx(); // coloca o topo como o prox (nova celula cabeça)
        topo.setElemento(-1); // elemento padrao da cabeça
        i.setProx(null); // limpa limpa
        i = null;
        return elemento; // retorna o elemento
    }

    // printar a celula
    void mostrar() {
        Celula i = topo.getProx(); // marca a celula que começa a printar
        System.out.print("[ ");
        while(i != null) { 
            System.out.print(i.getElemento() + " ");
            i = i.getProx();
        }
        System.out.print(" ]\n");
    }
    
}
