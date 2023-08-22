import java.util.Scanner;

public class App {

    static int fibonacci(int n) {

        int resp = 0;

        if (n < 2) {
            resp = n;
        } else {
            resp = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return resp;
    }
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o número: ");
        int n = teclado.nextInt();

        System.out.println(fibonacci(n-1));

        teclado.close();

    }
}
