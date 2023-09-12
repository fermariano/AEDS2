import java.util.Scanner;

public class Diamond {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();
        teclado.nextLine();
        
        for (int i = 0; i < n; i++) {

            int cont = 0, resp = 0;
            
            String frase = teclado.nextLine();
            String aux = "";
            

            for (int f = 0; f < frase.length(); f++) {
                if (frase.charAt(f) != '.') {
                    aux += frase.charAt(f);
                }   
        }

            for (int k = 0; k < aux.length(); k++) {
                if (aux.charAt(k) == '<') {
                    cont++;
                } else if (aux.charAt(k) == '>' && cont > 0) {
                    cont--;
                    resp++;
                }
            }

            System.out.println(resp);

        
        
    }

    teclado.close();
}
    
}