import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Nome do arquivo: ");
        String nomeArq = teclado.nextLine();

        FileReader arq = new FileReader(nomeArq);
        BufferedReader leitor = new BufferedReader(arq);

        String str = "";

        while ((str = leitor.readLine()) != null) {
            System.out.println(str);
        }

        leitor.close();
        teclado.close();

        
        
    }
}
