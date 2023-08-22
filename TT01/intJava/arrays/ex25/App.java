import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner teclado = new Scanner(System.in);
        int soma = 0;

        
        System.out.print("Linhas: ");
        int ln = teclado.nextInt();

        System.out.print("Colunas: ");
        int col = teclado.nextInt();

        int matriz[][] = new int[ln] [col];

        for (int i = 0; i < ln; i++) {
            soma = 0;
            for (int j = 0; j < col; j++) {
                System.out.print("Valor: ");
                matriz[i][j] = teclado.nextInt();
                soma += matriz[i][j];
            }
            float media = soma/(col);
            System.out.println(media);
        }

        

        

        teclado.close();


    }
}
