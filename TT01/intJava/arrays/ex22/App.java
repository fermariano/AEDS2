import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Linhas: ");
        int ln = teclado.nextInt();

        System.out.print("Colunas: ");
        int col = teclado.nextInt();

        int matriz1[][] = new int[ln] [col];
        int matriz2[][] = new int[ln] [col];
        int matrizS[][] = new int[ln] [col];

        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Valor: ");
                matriz1[i][j] = teclado.nextInt();
            }
        }

         for (int i = 0; i < ln; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Valor: ");
                matriz2[i][j] = teclado.nextInt();
            }
        }

        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < col; j++) {
                matrizS[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%d ", matrizS[i][j]);
            }
            System.out.println();
        }

        teclado.close();


    }
}