import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Tamanho do vetor: ");
        int t = teclado.nextInt();

        int vetor[] = new int[t];

        for (int i = 0; i < t; i++) {
            System.out.printf("Posição %d: ", i);
            vetor[i] = teclado.nextInt();
        }

        Arrays.sort(vetor);

        for(int i = 0; i < t; i++) {
             System.out.print(" ");
            System.out.print(vetor[i]);
        }

        

        teclado.close();

    }
}