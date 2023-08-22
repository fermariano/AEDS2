import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Tamanho do vetor: ");
        int t = teclado.nextInt();
        int par = 0, div = 0;

        int vetor[] = new int[t];

        for (int i = 0; i < t; i++) {
            System.out.printf("Posição %d: ", i);
            vetor[i] = teclado.nextInt();
            
            if (vetor[i] % 2 == 0) {
                par++;
            }

            if (vetor[i] % 3 == 0) {
                div++;
            }

           
            
        }

         System.out.println(par);
            System.out.println(div);

        

        teclado.close();

    }
}
