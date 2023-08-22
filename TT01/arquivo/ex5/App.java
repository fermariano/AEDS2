import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nome do arquivo: ");
        String nomeArq = teclado.nextLine();


        System.out.print("Frase: ");
        String frase = teclado.nextLine();

        FileWriter arq = new FileWriter(nomeArq);
        PrintWriter entrada = new PrintWriter(arq);

        entrada.println(frase);

        entrada.close();



        teclado.close();

    }
}
