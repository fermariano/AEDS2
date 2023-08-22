import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        int soma = 0;
        float media;

        System.out.print("Digite o tamanho do vetor: ");
        int n = teclado.nextInt();

        int vetor[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.format("Posição %d: ", i);
            vetor[i] = teclado.nextInt();
            soma += vetor[i];

        }

        

        media = soma/n;

        

        for (int i = 0; i < n; i++) {
            if (vetor[i] > media) {
                System.out.println(vetor[i]);
                
            }
        }

        teclado.close();

    }
}
