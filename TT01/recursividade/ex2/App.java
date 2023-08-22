import java.util.Scanner;

public class App {

    public static int maior(int vetor[], int n){
            return maior (vetor, n, 0);
        }

    public  static int maior (int vetor[], int n, int i) {
        int resp;
        if (i == n - 1) {
           resp = vetor[n - 1];
        } else {
           resp = maior(vetor, n, i + 1);

           if (resp < vetor[i]) {
            resp = vetor[i];
           }

        }
           return resp;
    }
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Tamanho: ");
        int t = teclado.nextInt();

        int vetor[] = new int[t];
        
        for (int i = 0; i < t; i++) {
            System.out.printf("Posição %d: ", i);
            vetor[i] = teclado.nextInt();

        }

        maior(vetor, t);

        teclado.close();
    }
}
