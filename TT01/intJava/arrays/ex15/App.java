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

        int cont = t;
        int soma;

        for (int i = 0; i < t/2; i++) {
            soma = 0;
            soma = vetor[i] + vetor[cont-1];
            cont--;
            System.out.println(soma);
        }

        

        

        teclado.close();

    }
}
