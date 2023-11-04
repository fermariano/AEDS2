import java.util.Scanner;

public class TrainOrganizer {

    static void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[i] = tmp;
    }

    static int bubblesort(int[] vetor) {
        int cont = 0;
        int i, j;
        int n = vetor.length-1;
        for (i = n; i >= 0; i--) {
            for (j = 0; j < i; j++) {
                if (vetor[i] < vetor[j]) {
                    swap(i, j, vetor);
                    cont++;
                }
            }
        }
        
        return cont;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();

        for (int f = 0; f < n; f++) {

            int vagao = teclado.nextInt();
            int[] vetor = new int[vagao];

            for (int i = 0; i < vagao; i++) {
                vetor[i] = teclado.nextInt();
            }


            System.out.println("Optimal train swapping takes " + bubblesort(vetor) + " swaps." );


        }

    }
}
