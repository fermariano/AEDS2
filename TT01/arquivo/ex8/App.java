import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Primeiro arquivo: ");
        String arq1 = teclado.nextLine();

        System.out.print("Segundo arquivo: ");
        String arq2 = teclado.nextLine();

        FileReader arqR = new FileReader(arq1);
        BufferedReader leitor = new BufferedReader(arqR);

        FileWriter arqW = new FileWriter(arq2);
        PrintWriter copiar = new PrintWriter(arqW);

        String str = " ";

        while ((str = leitor.readLine()) != null) {
            copiar.println(str);
        }

        teclado.close();
        copiar.close();
        leitor.close();

}
}
