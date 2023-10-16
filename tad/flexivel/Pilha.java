class Celula {
    public int elemento;
    public Celula prox;

    Celula() {
        prox = null;
    }

    Celula (int x) {
        elemento = x;
        prox = null;
    }

    public void setElemento(int ee) {
        elemento = ee;
    }

    public int getElemento() {
        return elemento;
    }

    public void setProx(Celula pp) {
        prox = pp;
    }

    public Celula getProx() {
        return prox;
    }

}

class Pilha {
    private Celula topo;
    private int tam = 0;

    public Pilha() {
        topo = null;
    }

    public void setTopo(Celula cc) {
        topo = cc;
    }

    public void nullPointer(Celula tmp) {
        tmp.setProx(null);
        tmp = null;
    }

    public void addTam() {
        tam++;
    }

    public void removeTam() {
        tam--;
    }

    public int getTam() {
        return tam;
    }


    // inserir no topo sempre
    public void inserir(int x) {
        Celula tmp = new Celula(x); // cria a nova celula pra inserir
        tmp.prox = topo; // seta o prox da nova celula para o que o topo ta apontando agora
        topo = tmp; // coloca o topo apontando pra ela
        tmp = null;// coloca o tmp apontando pra null
        addTam(); // controle do tamanho (soma 1)
    }

    // remover do topo sempre tambem
    public int remover() throws NullPointerException {
        if (topo == null) throw new NullPointerException("Lista vazia!"); // se o topo for null ela ta vazia
        int x = topo.getElemento(); // pega o elemento que vai ser removido
        Celula tmp = topo; // cria uma celula tmp que aponta para o topo
        setTopo(tmp.getProx()); // coloca o topo pra apontar pra proxima celula = removendo a do topo
        nullPointer(tmp); // coloca a que vai ser removida toda null
        removeTam(); // controle do tamanho (tira 1)
        return x;
    }

    // imprimir todos os elementos
    public void printar() throws NullPointerException {
        if (topo == null) throw new NullPointerException("Erro aqui"); // ta vaziaaaaaa
        Celula tmp = topo; // coloca uma celula tmp que vai percorrer a fila toda
        System.out.print("[ "); 
        while (tmp != null) { // enquanto ela a celula for diferente de null (null = acabou)
            System.out.print(tmp.getElemento() + " "); // printa o elemento atual
            tmp = tmp.getProx(); // vai pro proximo
        }
        System.out.print(" ]\n");

    }

    // somar todos os elementos iterativo
    public int soma() throws NullPointerException {
        if (topo == null) throw new NullPointerException("Ta vazia mano quer somar o que");
        Celula tmp = topo; // coloca uma celula tmp pra percorrer a pilha
        int soma = 0;
        while(tmp != null) { // enquanto ela nao for null (enquanto nao acabar)
            soma += tmp.getElemento(); // soma o elemento
            tmp = tmp.getProx(); // passa pra frente
        }
        return soma;
    }

    // auxilio da recursividade
    public int somaChama() {
        Celula tmp = topo;
        return somaRec(tmp);
    }

    // somar todos os elementos recursivo
    public int somaRec(Celula tmp) throws NullPointerException {
        if (topo == null) throw new NullPointerException("Vazia burrao"); // vazia!
        int soma = 0; // variavel de soma (da pra fazer direto mas preciso ver isso depois)
        
        if (tmp != null) { // enquanto a celula nao for null 
            soma = tmp.getElemento() + somaRec(tmp.getProx()); // soma os elementos e chama com o proximo
        }

        return soma;
    }


    // Encontrar o maior elemento iterativo
    public int maiorElemento() throws NullPointerException {
        if (topo == null) throw new NullPointerException("Vazia!");
        Celula tmp = topo;
        int maior = tmp.getElemento();
        while (tmp != null) {
            if (tmp.getElemento() > maior) maior = tmp.getElemento();
            tmp = tmp.getProx();
        }
        return maior;
    }

    // encontrar o maior elemento recursivo (essa função é so pra chamar)
    public int maiorElementoChama() throws NullPointerException {
        if (topo == null) throw new NullPointerException("Vazia");
        Celula tmp = topo;
        int maior = topo.getElemento();
        return maiorElementoRec(tmp, maior);
    }

    // encontrar o maior elemento recursivo (essa é a principal)
    public int maiorElementoRec(Celula tmp, int maior) {
        if (tmp != null) {
            if (tmp.getElemento() > maior) {
                maior = tmp.getElemento();
            } 
            maiorElementoRec(tmp.getProx(), maior);
        }
        return maior;
    }

    // printar na ordem que foi inserido recursivo
    public void printaReverse() throws NullPointerException {
        if (topo == null) throw new NullPointerException("Erro"); // ta vazia
        Celula tmp = topo; // coloca a tmp começando no topo
        printaReverseRec(tmp); // chama a funçao recursiva
    }

    public int printaReverseRec(Celula tmp) {
        if (tmp != null) { // enquanto a celula for diferente de null
            printaReverseRec(tmp.getProx()); // chama a função
            System.out.print(tmp.getElemento() + " "); // aqui printa o return da função anterior (vai desempilhando)
        }
        return 0;
    }

    // printar na ordem que foi inserido iterativo
    public void printaReverseI() throws NullPointerException {
        if (topo == null) throw new NullPointerException("Vazia");
        
        int cont = getTam(); // pega o tamanho da pilha
        System.out.print("[" );
        for (int i = 0; i < cont; i++) { // esses dois for faz com que cada iteraçao ele va diminuindo o final (?) pra ir printando
            Celula tmp = topo; // coloca a celula no inicio
            for (int j = 0; j < cont-i-1; j++) { //  vai caminhando que nem falei
                tmp = tmp.getProx();
            }
            System.out.print(tmp.getElemento() + " "); // printa o elemento
        }
        System.out.print( "]");
    }
    
}