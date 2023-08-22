import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Tamanho do vetor: ");
        int n = teclado.nextInt();

        int vetor[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Posição %d: ", i);
            vetor[i] = teclado.nextInt();
        }

        Arrays.sort(vetor);
        System.out.println(vetor[n-1]);

        teclado.close();

    }
}
