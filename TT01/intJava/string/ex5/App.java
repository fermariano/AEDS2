import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Palavra: ");
        String palavra = teclado.nextLine();
        int cont = 0;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) >= 'A' && palavra.charAt(i) <= 'Z') {
                cont++;
            }
        }

        System.out.printf("Letras maiúsculas: %d\n", cont);
        System.out.printf("Tamanho: %d\n", palavra.length());

        teclado.close();

    }
}
