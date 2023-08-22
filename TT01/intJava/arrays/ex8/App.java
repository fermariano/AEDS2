import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Tamanho do vetor: ");
        int t = teclado.nextInt();

        int vetor1[] = new int[t];
        int vetor2[] = new int[t];

        int vetorU[] = new int[t*2];
        

        for (int i = 0; i < t; i++) {
            System.out.print("valores: ");
            vetor1[i] = teclado.nextInt();

            vetorU[i] = vetor1[i];
        }

        

        for (int i = 0; i < t; i++) {
            System.out.print("Valores: ");
            vetor2[i] = teclado.nextInt();

            vetorU[i+t] = vetor2[i];
        }

        for (int i = 0; i < t*2; i++) {
            System.out.printf("%d ", vetorU[i]);
        }

        System.out.println(" ");

        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < t*2; i++) {
            if (i % 2 == 0) {
                System.out.print(vetor1[cont1]);
                System.out.print(" ");
                cont1++;
            } else {
                System.out.print(vetor2[cont2]);
                System.out.print(" ");
                cont2++;
            }
        }

        

    






        teclado.close();

    }
}
