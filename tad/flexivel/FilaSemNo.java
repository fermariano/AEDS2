class Celula {
    private int elemento;
    private Celula prox;

    Celula() {
        prox = null;
        elemento = -1;
    }

    Celula(int x) {
        prox = null;
        elemento = x;
    }

    int getElemento() {
        return elemento;
    }

    void setElemento(int x) {
        elemento = x;
    }

    void setProx(Celula i) {
        prox = i;
    }

    Celula getProx() {
        return prox;
    }
}


public class FilaSemNo {
    Celula primeiro, ultimo;

    Celula getPrimeiro() {
        return primeiro;
    }

    void setPrimeiro(Celula i) {
        primeiro = i;
    }

    Celula getUltimo() {
        return ultimo;
    }

    void setUltimo(Celula i) {
        ultimo = i;
    }

    boolean testeVazia() { // testa se a fila ta vazia
        if (primeiro == null) return true;
        else return false;
    } 

    void inserir(int x) {
        Celula tmp = new Celula(x); // cria a celula que vai ser inserida
        if (testeVazia()) primeiro = ultimo = tmp; // se a lista tiver vazia ela coloca o primeiro e ultimo no elemento
        else {
            ultimo.setProx(tmp); // coloca a celula inserida em ultimo
            ultimo = ultimo.getProx(); // atualiza o ultimo
        }
        
    }

    int remover() throws NullPointerException {
        if(testeVazia()) throw new NullPointerException("Vazia");
        int elemento = primeiro.getElemento(); // pega o elemento a ser removido
        primeiro = primeiro.getProx(); // pula para o proximo elemento
        return elemento; // retorna o elemento
    }

    void mostrar() throws NullPointerException {
        if (testeVazia()) throw new NullPointerException("Vazia");
        Celula i = primeiro;
        System.out.print("[ ");
        while(i != null) {
            System.out.print(i.getElemento() + " ");
            i = i.getProx();
        }
        System.out.print( "]\n");
    }

}
