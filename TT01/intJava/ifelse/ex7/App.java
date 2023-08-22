import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Primeiro número: ");
        float n1 = teclado.nextFloat();
        System.out.print("Segundo número: ");
        float n2 = teclado.nextFloat();

        if (n1 < n2) {
            System.out.println(Math.cbrt(n1));
            System.out.println((int) (Math.log(n1) / Math.log(n2) + 1e-10));
        } else {
            System.out.println(Math.cbrt(n2));
            System.out.println((int) (Math.log(n2) / Math.log(n1) + 1e-10));
        }

        
        teclado.close();

        

    }
}
