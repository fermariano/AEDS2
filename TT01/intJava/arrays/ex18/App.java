import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Tamanho do vetor 1: ");
        int t1 = teclado.nextInt();
        System.out.print("Tamanho do vetor 2: ");
        int t2 = teclado.nextInt();

        int tm;

        if (t1 > t2) {
            tm = t1;
        } else {
            tm = t2;
        }

        int vetor1[] = new int[t1];
        int vetor2[] = new int[t2];

        for (int i = 0; i < t1; i++) {
            System.out.printf("Posição %d: ", i);
            vetor1[i] = teclado.nextInt();
        }

        for (int i = 0; i < t2; i++) {
            System.out.printf("Posição %d: ", i);
            vetor2[i] = teclado.nextInt();
        }

        for (int i = 0; i < tm; i++) {
            if (i < t1) {
                System.out.println(vetor1[i]);
            } if (i < t2) {
                System.out.println(vetor2[i]);
            }
        }



        teclado.close();

    }
}
