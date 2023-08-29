import java.util.Random;

public class RandomAlt {

    public static String change(String frase) {
        Random gerador = new Random();
        gerador.setSeed(4);
        char teste = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        System.out.println(teste);

        Random gerador2 = new Random();
        gerador.setSeed(4);
        char teste2 = (char)('a' + (Math.abs(gerador2.nextInt()) % 26));
        System.out.println(teste2);

        String str = "";


        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == teste) {
                str += teste2;
            } else {
                str += frase.charAt(i);
            }
        }
        return str;

    }
    public static void main (String[] args) {
        String frase = "";

        while (true) {
            frase = MyIO.readLine();
            if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
                break;
            }
            System.out.println(change(frase));
        }
    }
    
}
