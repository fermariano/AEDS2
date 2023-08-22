import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Primeiro número: ");
        double n1 = teclado.nextDouble();
        System.out.print("Segundo número: ");
        double n2 = teclado.nextDouble();
        System.out.print("Terceiro número: ");
        double n3 = teclado.nextDouble();

        if (n1 == n2 && n2 == n3) {
            System.out.println("Triângulo equilátero");
        } else if (n1 != n2 && n2 != n3 && n1 != n3) {
            System.out.println("Triângulo escanelo");
        } else {
            System.out.println("Triângulo isósceles");
        }

        teclado.close();

    }
}
