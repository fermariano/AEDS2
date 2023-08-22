import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Linhas: ");
        int ln = teclado.nextInt();

        System.out.print("Colunas: ");
        int col = teclado.nextInt();

        int matriz[][] = new int[ln] [col];

        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Valor: ");
                matriz[i][j] = teclado.nextInt();
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < ln; j++) {
                System.out.printf("%d ", matriz[j][i]);
            }
            System.out.println();
        }

        teclado.close();


    }
}
