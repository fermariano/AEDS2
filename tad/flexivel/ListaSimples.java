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
public class ListaSimples {
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



    
}
