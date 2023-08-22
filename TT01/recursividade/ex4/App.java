import java.util.Scanner;

public class App {

    public static int contVogal(String word, int i) {
        int cont = 0;

        word = word.toLowerCase();

        if (i < word.length()) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                cont++;
            }
            cont += contVogal(word, i + 1);
        }

        return cont;
    }
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        String str = teclado.nextLine();

        System.out.println(contVogal(str, 0));

        teclado.close();


        

    }
}
