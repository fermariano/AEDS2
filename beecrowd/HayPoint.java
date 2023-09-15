import java.util.Scanner;

public class HayPoint {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int word = teclado.nextInt();
        int func = teclado.nextInt();

        String[] cargo = new String[word];
        int[] valor = new int[word];

        for (int i = 0; i < word; i++) {
            cargo[i] = teclado.next();
            valor[i] = teclado.nextInt();
        }
        
        for (int i = 0; i < func; i++) {

            String text = "";

            while (teclado.hasNext()) {
                if (teclado.hasNext(".")) {
                    teclado.nextLine();
                    break;
                } 
                text += teclado.nextLine();
                text+= " ";
            }

             String[] words = text.split("\\s+");
             int total = 0;

                
            for (int k = 0; k < word; k++) {
                for (int f = 0; f < words.length; f++) {
                    if (words[f].equals(cargo[k])) {
                        total += valor[k];
                    }
                     
                }
                
            }        

            System.out.println(total);
            
            
        }

            

        }

    }

