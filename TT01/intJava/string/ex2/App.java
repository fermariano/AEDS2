import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        System.out.print("String: ");
        String palavra = teclado.nextLine();

        int cont = 0;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) <'0' || palavra.charAt(i) > '9') {
                cont++;
            } 
        }

        if (cont == palavra.length()) System.out.println("Sem número");
        else System.out.println("Com número");
 

        teclado.close();

        
    }
}
