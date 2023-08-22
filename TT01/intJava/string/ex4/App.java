import java.util.Scanner;

public class App {

    public static boolean verificar(String frase) {

        
        int contador = frase.length();
        boolean testar = true;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != frase.charAt(contador-1)) {
                testar = false;
            } else {
                contador--;
            }

        }

        return testar;
        
    }
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        String vetor = teclado.nextLine();

        while (vetor.compareTo("FIM") != 0) {
            if (verificar(vetor)) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            vetor = teclado.nextLine();
        }
            teclado.close();
    }
}
