public class App {

    public static void sortarray(int[] vetor, int k) {
        if (k < vetor.length - 1) {
            int min = k;
            for (int i = k + 1; i < vetor.length; i++) {
                if (vetor[i] < vetor[min]) {
                    min = i;
                }
            }

            if (min != k) {
                int temp = vetor[k];
                vetor[k] = vetor[min];
                vetor[min] = temp;
            }

            sortarray(vetor, k + 1);
        }
    }

    public static void main(String[] args) {
        int[] vetor = {12, 45, 23, 6, 17, 9};
        
        System.out.println("Vetor antes da ordenação:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }

        sortarray(vetor, 0);

        System.out.println("\nVetor após a ordenação:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
    }
}

