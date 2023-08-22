import java.io.FileWriter;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {
        
        FileWriter arq = new FileWriter("teste.txt");
        PrintWriter gravar = new PrintWriter(arq);

        gravar.println(7);
        gravar.println(8.9);
        gravar.println('f');
        gravar.println(false);
        gravar.println("Teste de arquivo");


        gravar.close();



    }
}
