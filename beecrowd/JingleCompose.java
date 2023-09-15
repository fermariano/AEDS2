import java.util.Scanner;

public class JingleCompose {
    public static void main (String[] args) {

        Scanner teclado = new Scanner(System.in);

        char[] letras = {'W', 'H', 'Q', 'E', 'S', 'T', 'X'};
        double[] valor = {1, 0.5, 0.25, 0.125, 0.0625, 0.03125, 0.015625};

        while(true) {

            String frase = teclado.nextLine();
            if (frase.equals("*")) break;
            
            String[] jingle = frase.split("/");
            int cont = 0;

            for (int i = 0; i < jingle.length; i++) {

                double total = 0;
                String aux = jingle[i];
               
                for (int j = 0; j < letras.length; j++) {

                    for (int k = 0; k < aux.length(); k++) {
                        if (aux.charAt(k) == letras[j]) {
                            total += valor[j];
                        }
                    }
                }
                if (total == 1) cont++;
            }

            System.out.println(cont);



        }
            teclado.close();
    }

}
