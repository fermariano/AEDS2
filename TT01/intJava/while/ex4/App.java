import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o número: ");
        int n = teclado.nextInt();
        int seq = 1, cont = 0;
        
        System.out.println(seq);
        while (cont < n-1) {
            if (cont % 2 == 0) {
                seq += 4;
                System.out.println(seq);
            } else {
                seq += 7;
                System.out.println(seq);
            }
            cont++;
        }

        teclado.close();
    }
}
