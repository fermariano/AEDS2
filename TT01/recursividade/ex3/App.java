import java.util.Scanner;

public class App {

    public static boolean isPalindromo(String word, int i) {
        boolean teste;
        if (i >= word.length() / 2){
            teste = true;
        } else if (word.charAt(i) != word.charAt(word.length() - 1 - i)){
            teste = false;
        } else {
            teste = isPalindromo(word, i + 1);
        }
             return teste;
    }
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Frase: ");
        String str = teclado.nextLine();

       System.out.println(isPalindromo(str, 0)); 

        teclado.close();

    }
}
