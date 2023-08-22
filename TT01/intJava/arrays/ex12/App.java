import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Tamanho: ");
        int t = teclado.nextInt();
        int soma = 0;

        int vetor[] = new int[t];

        for (int i = 0; i < t; i++) {
            System.out.print("Valor: ");
            vetor[i] = teclado.nextInt();
        }

        if (t % 2 == 0) {
            for (int i = 0; i < t; i += 2) {
                soma = vetor[i] + vetor[i+1];
                System.out.println(soma);
            }

        }

        teclado.close();

    }
}
