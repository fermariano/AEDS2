import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNext()) {

            int n = teclado.nextInt();
            teclado.nextLine();
            String telefone = teclado.nextLine();
            int cont = 0;
        
            for (int i = 1; i < n; i++) {
                
                String cmp = teclado.nextLine();

                if (i > 1 && i == n-1) {
                    break;
                }

                for (int j = 0; j < telefone.length(); j++) {
                    if (telefone.charAt(j) == cmp.charAt(j)) {
                        cont++;
                    }
                }
                
                telefone = cmp;
            
            }

            System.out.println(cont);

        }
        teclado.close();
    }
}
