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

        FileReader arqR = new FileReader(arq1 + ".txt");
        BufferedReader leitor = new BufferedReader(arqR);

        FileWriter arqW = new FileWriter(arq2 + ".txt");
        PrintWriter printar = new PrintWriter(arqW);

        String str = "";

        while((str = leitor.readLine()) != null) {
            for (int i = (str.length() - 1); i >= 0; i--) {
                printar.print(str.charAt(i));
                
            }
            printar.println();
        }

        leitor.close();
        printar.close();
        teclado.close();

    }
}
