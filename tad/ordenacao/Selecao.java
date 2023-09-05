package ordenacao;

public class Selecao {

    static void swap (int menor, int i, int[] vetor) {
        int temp;

        temp = vetor[i];
        vetor[i] = vetor[menor];
        vetor[menor] = vetor[i];
     }

    static int organiza(int[] vetor) {

        int menor, comp = 0;

        for (int i = 0; i < (vetor.length-1); i++) { // percorre o vetor menos a ultima posição
            menor = i;
            for (int j = (i+1); j < vetor.length; j++) { // percorre a parte não-ordenada do vetor (sempre uma posição a frente do i)
                comp++;
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
                
            }
            swap(menor, i, vetor);
         }

         return comp;

    }

    static boolean binarySearch (int x, int[] vetor) {

        int meio, esq = 0, dir = (vetor.length - 1);
        boolean resp = false;

        while (esq <= dir) {
            for (int i = 0; i < vetor.length; i++) {
                meio = (esq + dir) / 2;
                if (vetor[meio] == x) {
                    resp = true;
                    esq = vetor.length;
                } else if (x > vetor[meio]) {
                    esq = meio + 1;
                    meio = (dir + esq) / 2; //sempre lembrar de setar o meio de novo
                } else {
                    dir = meio - 1;
                    meio = (dir + esq) / 2;
                }
            }


        }

        return resp;


    }
    
    public static void main (String[] args) {

        int[] vetor = new int[100];

        for (int i = 99; i >= 0; i--) {
            vetor[i] = i;
        }

        organiza(vetor);

        for (int num : vetor) {
            MyIO.print(num + " ");
        }

        MyIO.println(binarySearch(100, vetor));

    }
 
}
