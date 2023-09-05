public class Fila {
    
    private int cont = 0;
    private int[] vetor;

    Fila() {
        vetor = new int[6];
    }

    Fila (int n) {
        setVetor(n);
    }

    public void setVetor(int n) {
        vetor = new int[n];
    }

    public int[] getVetor() {
        return vetor;
    }

    public int getContador() {
        return cont;
    }

    public void inserir(int x) {

        if (cont == vetor.length) System.out.println("[ERRO] Array cheio");
        else {
            for (int i = cont; i > 0; i--) {
                vetor[i] = vetor[i-1];
            }
    
            vetor[0] = x;
            cont++;

        }


    }

    public int remover() {

        int backup = vetor[cont-1];

        cont--;

        return backup;

    }

    public void mostrar() {

        for (int i = 0; i < cont; i++) {
            System.out.print(vetor[i] + " ");
            
        }

        System.out.println();

    }


}

