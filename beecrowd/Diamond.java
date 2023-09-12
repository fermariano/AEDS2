import java.util.Scanner;

public class Diamond {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();
        int cont = 0;
        teclado.nextLine();
        for (int i = 0; i < n; i++) {
            
            String frase = teclado.nextLine();
            String aux = "";
            String aux2 = "";

            for (int j = 0; j < frase.length(); j++) {
                if (frase.charAt(j) != '.') {
                    aux += frase.charAt(j);
                }

            for (int f = 0; f < aux.length(); f++) {
                
                if (aux.charAt(f) == '<') {
                    
                    for (int p = f+1; p < aux.length(); p++) {
                       
                        if (aux.charAt(p) == '>') {
                            cont++;
                            
                        } else {
                            aux2 += aux.charAt(f);
                        } 
                  }
               } 
                

            }
               aux = aux2;
            }

            System.out.println(aux);
            System.out.println(cont);
        }
    }


}