import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Palavra: ");
        String palavra = teclado.nextLine();
        int letra = 0, nletra = 0, vogal = 0, conso = 0;

        System.out.printf("Número de caracteres: %d\n", palavra.length());

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) >= 'A' && palavra.charAt(i) <= 'Z' || palavra.charAt(i) >= 'a' && palavra.charAt(i) <= 'z') {
                letra++;
            } else {
                nletra++;
            }

            if(palavra.charAt(i) == 'a' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'i' || palavra.charAt(i) == 'o'
            || palavra.charAt(i) == 'u' || palavra.charAt(i) == 'A' || palavra.charAt(i) == 'E' || palavra.charAt(i) == 'I'
            || palavra.charAt(i) == 'O' || palavra.charAt(i) == 'U') {
                vogal++;
            } else {
                conso++;
            }

        }

        System.out.printf("Letras: %d\n", letra);
        System.out.printf("Não letras: %d\n", nletra);
        System.out.printf("Vogais: %d\n", vogal);
        System.out.printf("Consoantes: %d\n", conso);

        teclado.close();

    }
}
