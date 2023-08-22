import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Palavra: ");
        String palavra = teclado.nextLine();

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == 'A') {
                System.out.printf("Posição %d\n", i+1);
                break;
            }
        }
        
        teclado.close();
    }
}
