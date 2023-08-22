import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        int t = 10;
        int vetor[] = new int[t];

        for (int i = 0; i < t; i++) {
            System.out.format("Posição %d: ", i);
            vetor[i] = teclado.nextInt();
        }

        int maior = vetor[0];
        
        for (int i = 0; i < t; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }

        System.out.format("O maior valor é %d\n", maior);

        teclado.close();
        


    }
}
