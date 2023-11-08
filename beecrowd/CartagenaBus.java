import java.util.*;

public class Prova {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();

        for (int i = 0; i < n; i++) {

            int pessoa = teclado.nextInt();
            int horario = teclado.nextInt();

            String[] pessoas = new String[pessoa];
            String[] horarios = new String[horario];
            int[] cont = new int[horario];

            teclado.nextLine();

            for (int j = 0; j < horario; j++) {
                horarios[j] = teclado.nextLine();
            }

            String aux = "";

            for (int j = 0; j < pessoa; j++) {
                int tmp = teclado.nextInt();
                aux += teclado.nextLine();
                aux += " ";
            }

            String[] pessoasAtt = aux.split(" ");

            for (int j = 0; j < horario; j++) {
                for (int k = 0; k < pessoasAtt.length; k++) {
                    if (horarios[j].equals(pessoasAtt[k])) {
                        cont[j]++;
                    }
                }
            }

            Arrays.sort(cont);
            for (int j = 0; j < cont.length; j++) {
                if (cont[j] != 0) {
                    System.out.println(cont[j]);
                    break;
                } 
            
            
               
            }

        }


    }
}