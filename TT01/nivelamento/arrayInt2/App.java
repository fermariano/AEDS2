import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static boolean testar(int[] vetor, int n) {

        boolean teste = false;

        Arrays.sort(vetor);

        if (n > vetor[vetor.length/2]) {
            for (int i = (vetor.length/2 + 1); i < vetor.length; i++) {
                if (vetor[i] == n) {
                    teste = true;
                } 
            }
        } else if (n < vetor[vetor.length/2]) {
            for (int i = 0; i < (vetor.length/2); i++) {
                if (vetor[i] == n) {
                    teste = true;
                }
            }
        } else {
            teste = true;
        }
            return teste;
    }
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor: ");
        int t = teclado.nextInt();
        
        int vetor[] = new int[t];

        for (int i = 0; i < t; i++) {
            System.out.format("Posição %d: ", i);
            vetor[i] = teclado.nextInt();
        }

        System.out.print("Digite o número para procurar: ");
        int n = teclado.nextInt();

        if (testar(vetor, n)) {
            System.out.format("O número %d está no vetor\n", n);
        } else {
            System.out.format("O número %d não está no vetor\n", n);
        }

        teclado.close();

    }
}
