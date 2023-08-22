import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        int vetor[] = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o valor: ");
            vetor[i] = teclado.nextInt();
        }

        int maior = vetor[0];
        int menor = vetor[0];

        for (int i = 0; i < 3; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }

            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }

        System.out.format("Maior valor: %d\n", maior);
        System.out.format("Menor valor: %d\n", menor);



        teclado.close();

    }
}
