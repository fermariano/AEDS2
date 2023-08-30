import java.util.Random;

public class RandomAlt {

    public static String change(String frase, char teste1, char teste2) {

        String str = "";


        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == teste1) {
                str += teste2;
            } else {
                str += frase.charAt(i);
            }
        }
        return str;

    }
    public static void main (String[] args) {
        String frase = "";

        Random r = new Random();
        r.setSeed(4);


        while (true) {
            frase = MyIO.readLine();

            if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
                break;
            }
            char teste1 = (char)('a' + (Math.abs(r.nextInt()) % 26));
            char teste2 = (char)('a' + (Math.abs(r.nextInt()) % 26));
            MyIO.println(change(frase, teste1, teste2));
        }
    }
    
}
