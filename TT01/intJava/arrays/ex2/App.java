import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor: ");
        int n = teclado.nextInt();

        int vetor[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Posição %d: ", i);
            vetor[i] = teclado.nextInt();
        }

        for (int i = 0; 2*i+1 < n; i++) {
            System.out.println(i + (2*i+1));
        }



        teclado.close();

    }
}
