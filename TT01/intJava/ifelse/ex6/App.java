import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o salário: ");
        double salario = teclado.nextDouble();

        System.out.print("Digite o valor da parcela: ");
        double parcela = teclado.nextDouble();

        if (salario * 0.4 < parcela) {
            System.out.println("Não é possível fazer o empréstimo");
        } else {
            System.out.println("É possível fazer o empréstimo");
        }

        teclado.close();

    }
}
