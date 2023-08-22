import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite o primeiro valor: ");
        int n1 = teclado.nextInt();
        System.out.print("Digite o segundo valor: ");
        int n2 = teclado.nextInt();

        int resultado = 0;

        if (n1 > 45 || n2 > 45) {
            resultado = n1 + n2;
            System.out.println(resultado);
        } else if (n1 > 20 && n2 > 20) {
            if (n1 > n2) {
                resultado = n1 - n2;
                System.out.println(resultado);
            } else {
                resultado = n2 - n1;
                System.out.println(resultado);
            }
        } else if ((n1 < 10 || n2 < 10) && (n1 != 0 || n2 != 0)) {
            resultado = n1/n2;
            System.out.println(resultado);
        } else {
            System.out.println("Fernanda");
        }

        

        teclado.close();

    }
}
