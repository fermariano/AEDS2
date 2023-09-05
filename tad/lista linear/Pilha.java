public class Pilha {
    
    int cont = 0;
    int vetor[];

    Pilha() {
        vetor = new int[6];
    }

    Pilha(int n) {
         vetor = new int[n];
    }

    public void inserir(int x) {

        if (cont == vetor.length) System.out.println("[ERRO] Out of range");
        else {
            vetor[cont] = x;
            cont++;
        }

    }

    public int remover() {

        

        if (cont == 0) System.out.println("[ERRO]Array vazio"); 
         else cont--;

         int backup = vetor[cont];
            
        return backup;

    }

    public void mostrar() {

        for (int i = 0; i < cont; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println();

    }

}
