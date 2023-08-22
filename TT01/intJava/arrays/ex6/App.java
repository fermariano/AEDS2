import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Tamanho do vetor: ");
        int t = teclado.nextInt();
        int pos = 0;

        int vetor[] = new int[t];

        for (int i = 0; i < t; i++) {
            System.out.printf("Posição %d: ", i);
            vetor[i] = teclado.nextInt();

            int menor = Integer.MAX_VALUE;

            if (vetor[i] < menor) {
                menor = vetor[i];
                pos = i;
            }

            

        }

        System.out.println(pos); 

        teclado.close();

    }
}
