import java.util.Scanner;

public class Parentesis {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        while(teclado.hasNext()) {

            String frase = teclado.nextLine();
            int cont = 0;
            int resp = 0;

            for (int i = 0; i < frase.length(); i++) {
                if (frase.charAt(i) == '(') {
                    cont++;
                } else if (frase.charAt(i) == ')') {
                    if (cont > 0) {
                        cont--;
                    } else {
                        cont++;
                    }
                }
            }

            if (cont == 0) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }

        }

        teclado.close();
    }
    
}
