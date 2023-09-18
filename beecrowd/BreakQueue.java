import java.util.Scanner;

public class BreakQueue {

    static void swap(int[] array, int k, int maior) {
        int aux = array[k];
        array[k] = array[maior];
        array[maior] = aux;

    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();

        for (int i = 0; i < n; i++) {

            int m = teclado.nextInt();
            int notas[] = new int[m];
            int temp[] = new int[m];

            for (int j = 0; j < m; j++) {
                notas[j] = teclado.nextInt();
                temp[j] = notas[j];
            }

            for (int k = 0; k < m; k++) {
                int maior = k;
                for (int j = k+1; j < m; j++) {
                    if (notas[j] > notas[maior]) {
                        maior = j;
                    }
                }
                 swap(notas, k, maior);

            }

            int cont = 0;

            for (int j = 0; j < m; j++) {
                if (notas[j] == temp[j]) cont++;
            }

            System.out.println(cont);
        }
    }
    
}
