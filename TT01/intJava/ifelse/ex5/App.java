import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Gols do mandante: ");
        int mand = teclado.nextInt();

        System.out.print("Gols do visitante: ");
        int vis = teclado.nextInt();

        if (mand > vis) {
            System.out.println("Vitória do mandante");
        } else if (vis > mand) {
            System.out.println("Vitória do visitante");
        } else {
            System.out.println("Empate");
        }

        teclado.close();

    }
}
