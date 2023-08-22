import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;


public class App {
    
    public static void main (String[] args) throws Exception {

        try {
            FileReader arq = new FileReader("teste.txt");
            BufferedReader leitura = new BufferedReader(arq);
            
            FileWriter copia = new FileWriter("copia.txt");
            PrintWriter escrita = new PrintWriter(copia);

            String str = "";

            while ((str = leitura.readLine()) != null) {
                escrita.println(str);
            }
                
                
            

            
            

            escrita.close();
            leitura.close();


        } catch (FileNotFoundException e) {
            System.out.println("[ERRO]");
            e.printStackTrace();
        }
        
    }

}
