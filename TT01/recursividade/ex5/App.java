import java.util.Scanner;

public class App {

    public static int contVogalConso(String word, int i) {
        int cont = 0;

        if (i < word.length()) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' || word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                
            } else {
                cont++;
            }
            cont += contVogalConso(word, i + 1);
        }

        return cont;
    }
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        String str = teclado.nextLine();

        System.out.println(contVogalConso(str, 0));

        teclado.close();


        

    }
}
