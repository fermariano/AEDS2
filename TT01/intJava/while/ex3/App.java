import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        int cont = 1;
        
        System.out.print("Digite um número inteiro: ");
        int n = teclado.nextInt();

        while (cont < n) {

            System.out.println(cont);
            cont += 2;

        }

        teclado.close();

    }
}
