import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        
        int vetor[] = new int[5];
        int soma = 0;
        int menor = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            System.out.print("Nota: ");
            vetor[i] = teclado.nextInt();
            soma += vetor[i];

            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }

        float media = soma/5;

        System.out.printf("Soma: %d\n", soma);

        System.out.printf("Media: %.2f\n", media);

        teclado.close();
        

    }
}
