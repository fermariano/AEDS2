package insertion;

public class Insercao {

    static void organiza(int[] vetor) {

        for (int i = 1; i < vetor.length; i++) {
            int temp = vetor[i]; // variavel temporaria 
            int j = i-1; // ultima pos do vetor ordenado

            while ((j >= 0) && temp < vetor[j]) {
                vetor[j+1] = vetor[j]; // movimenta os numeros maiores
                j--;
            }

            vetor[j+1] = temp;


        }

        }

    static boolean binarySearch(int[] array, int x) {
        boolean resp = false;

        int dir = (array.length-1), esq = 0;
        int meio = (dir + esq) /2;

        while (dir >= esq) {
            if (x == array[meio]) {
                resp = true;
                esq = dir + 1;
            } else if (x < array[meio]) {
                dir = meio -1;
                meio = (esq + dir)/2;
            } else {
                esq = meio + 1;
                meio = (esq + dir) /2;
            }
        }

        return resp;
    }

    public static void main (String[] args) {
        
        int[] vetor = new int[100];
        int cont = 100;

        for (int i = 0; i < 100; i++) {
            vetor[i] = cont;
            cont--;
        }

        for (int num : vetor) {
            MyIO.print(num + " ");
        }

        System.out.println("ORGANIZA!");
        organiza(vetor);

        for (int num : vetor) {
            MyIO.print(num + " ");
        }

        System.out.println(binarySearch(vetor, 258));

    }
    
}
