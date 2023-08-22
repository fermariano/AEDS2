import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        int cont = 0;

        System.out.print("String: ");
        String palavra = teclado.nextLine();

        System.out.print("Caractere: ");
        char c = teclado.next().charAt(0);

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == c) {
                cont++;
            }
        }

        System.out.println(cont);
        teclado.close();

    }
}
