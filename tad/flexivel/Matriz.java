class CelulaM {
    int elemento;
    CelulaM prox;
    CelulaM ant;
    CelulaM sup;
    CelulaM inf;

    CelulaM() {
        prox = ant = sup = inf = null;
        elemento = -1;
    }

    CelulaM(int x) {
        elemento = x;
        prox = ant = sup = inf = null;
    }

    void setDir(CelulaM i) {
        prox = i;
    }

    CelulaM getDir() {
        return prox;
    }

    void setEsq(CelulaM i) {
        ant = i;
    }

    CelulaM getEsq() {
        return ant;
    }

    void setSup(CelulaM i) {
        sup = i;
    }

    CelulaM getSup() {
        return sup;
    }

    void setInf(CelulaM i) {
        inf = i;
    }

    CelulaM getInf() {
        return inf;
    }

    int getElemento() {
        return elemento;
    }

    void setElemento(int x) {
        elemento = x;
    }

}

public class Matriz {
    CelulaM inicio = new CelulaM(); // ja cria a celula inicio
    int linha, coluna; // linha e coluna

    Matriz() { // se nao der o tamanho ela é 5x5 por padrao
        linha = coluna = 3;
        construir(linha, coluna); // chama o metodo construir
    }

    Matriz(int ln, int col) { // chamando o construtor com numero de linhas e colunas
        linha = ln;
        coluna = col;
        construir(linha, coluna); // chama o metodo construir
    }

    void construir(int ln, int col) {

        // criar primeira coluna
        CelulaM aux = inicio; // coloca uma celula auxiliar em inicio pq vou andar com ela
        for (int i = 1; i < ln; i++) { // faz um for que vai de 1 (pq ja tem inicio) ate o numero de linhas 
            CelulaM tmp = new CelulaM(); // cria uma nova celula
            // coloca essa celula criada embaixo da auxiliar (que começa no inicio)
            aux.setInf(tmp); 
            tmp.setSup(aux);
            // anda com a aux pra baixo
            aux = aux.getInf();
        }

     
        // criar o resto da matriz (essas duas vao marcar o inicio de cada linha)
        CelulaM l1 = inicio; // uma celula no inicio
        CelulaM l2 = inicio.getInf(); // uma celula embaixo dela
        
        

        for (int j = 1; j < ln; j++) { // esse for percorre a linha
            // cria duas celulas temporarias que vao andar pra frente
            CelulaM tmp = l1; 
            CelulaM tmp2 = l2;

            for (int k = 1; k < col; k++) { // esse for percorre as colunas
                CelulaM harry = tmp; // cria um pinteiro de celula
            
                if (tmp.getDir() == null || tmp2.getDir() == null) { // testa se a linha ja existe, se nao ela sobrepoe e da ruim
                    harry = new CelulaM(); // se a linha ainda nao existir, cria uma nova celula
                } else {
                    harry = l1.getDir(); // se ja existir, ela so aponta o harry pra la
                }
                
                // aponta uma pra outra lateralmente
                tmp.setDir(harry);
                harry.setEsq(tmp);

                // cria uma nova celula embaixo
                CelulaM louis = new CelulaM();
        
                // seta as laterais dela e da celula anterior
                tmp2.setDir(louis);
                louis.setEsq(tmp2);

                // agora que tem o ponteiro da de cima e da de baixo, aponta os sup e inf
                harry.setInf(louis);
                louis.setSup(harry);

                // anda com as celulas pra frente 
                tmp = tmp.getDir();
                tmp2 = tmp2.getDir();
            }
            // desce os ponteiros que salvam o inicio de cada linha a ser criada/apontada
            l1 = l1.getInf();
            l2 = l2.getInf();
        }

        


    }

    // insere no proximo espaço livre (começa pela linha)
    void inserir(int x)  { 
        CelulaM i = inicio; // coloca um ponteiro que vai salvar o inicio de cada linha
        int j = 0; // contador de linha
        while (j < linha) { // começa a percorrer assim -->
            int l = 0; // contador de coluna!
            CelulaM k = i; // cria uma celula que percorre a linha
            while (l < coluna) { 
                if (k.getElemento() == -1) { // se o elemento for nulo (-1 é padrao)
                    k.setElemento(x); // coloca o elemento la
                    // quebra o while
                    l = coluna;
                    j = linha;
                } else { // se ele nao tiver livre
                    k = k.getDir(); // anda pra frente
                    l++; // incrementa a coluna
                }
            }
            // quando acaba a linha ele passa pra de baixo
            i = i.getInf();
            j++; // ate percorrer a matriz toda
        }
       
    }

    // insere no lugar que quer
    void inserirPos(int x, int ln, int col) {
        CelulaM aux = inicio; // coloca uma celula no inicio que vai percorrer
        for (int i = 0; i < ln; i++) { // esse for anda ate a linha certa
            aux = aux.getInf(); 
        }

        for (int i = 0; i < col; i++) { // esse aqui anda ate a coluna certa
            aux = aux.getDir();
        }

        aux.setElemento(x); // insere o elemento!

    }

    void mostrar() {
        CelulaM i = inicio; // celula que vai andar
        

        for (int k = 0; k < linha; k++) { // controla a linha (vai andar assim ó -->)
            CelulaM u = i; // essa celula vai percorrer as colunas
            for (int j = 0; j < coluna; j++) { // controla a coluna
                System.out.print(u.getElemento() + " "); // printa o elemento
                u = u.getDir(); // anda pro lado
            }
            i = i.getInf(); // anda pra baixo
            System.out.println(); // da a quebra de linha
        }
        System.out.println();
    }

    

    
    
    
}
