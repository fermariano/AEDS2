package insertion;

public class Inserction {

    static boolean boolRec(int[] array, int x, int dir, int esq) {
        int meio = (dir + esq) /2;
        if (dir < esq) return false;
        if (array[meio] == x) return true;
        else if (x > array[meio]) return boolRec(array, x, dir, meio+1);
        else return boolRec(array, x, meio-1, esq);
     }

    static boolean iniBool (int[] array, int x) {
        int dir = (array.length-1), esq = 0;
        return boolRec(array, x, dir, esq);

    }

    static void organiza (int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int aux = vetor[i]; // variavel temporaria
            int j = i-1; // ultima posiçao do vetor ordenado
            while ((j >= 0) && (aux < vetor[j])) {
                vetor[j+1] = vetor[j]; // passa os elementos pra frente
                j--; // descrementa para percorrer o vetor ordenado
            }

            vetor[j+1] = aux; // insere o valor no lugar correto
            

        }
    }
    
    public static void main(String[] args) {

        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = 100 - i;
        }

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println("----ORGANIZA----");
        

        organiza(array);

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println(iniBool(array, 169));
        

    }

}
