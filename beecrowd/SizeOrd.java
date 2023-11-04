import java.util.Scanner;

public class SizeOrd {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();
        teclado.nextLine();
        
        for (int i = 0; i < n; i++) {
            String frase = teclado.nextLine();
            String[] palavra = frase.split(" ");

            int tam = palavra.length;

            for (int j = 1; j < tam; j++) {
                String pos = palavra[j];
                int k = j - 1;

                while (k >= 0 && palavra[k].length() < pos.length()) {
                    palavra[k+1] = palavra[k];
                    k--;
                }
                palavra[k + 1] = pos;
            }

            for (String word : palavra) {
                System.out.print(word + " ");
            }
            System.out.println();

        }
        teclado.close();
    }
}