import java.util.Scanner;

public class App {

    public static void imprimir(int vetor[]) {

        int maior = vetor[0];
        int menor = vetor[0];

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }

            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }

        System.out.format("Maior valor: %d\n", maior);
        System.out.format("Menor valor: %d\n", menor);
        

    }
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o tamanho do vetor: ");
        int n = teclado.nextInt();

        int vetor[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.format("Posição %d: ", i);
            vetor[i] = teclado.nextInt();
        }

        imprimir(vetor);

        teclado.close();
    }
}
