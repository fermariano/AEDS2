import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nome do arquivo: ");
        String nomeArq = teclado.nextLine();

        FileReader arqR = new FileReader(nomeArq + ".txt");
        BufferedReader leitor = new BufferedReader(arqR);

        String str = "";
        int chave = 3;
        char x, y, ascii;

        while ((str = leitor.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
                    if ((int)(str.charAt(i) + chave) > 122) {
                    x = (char)(str.charAt(i) + chave); // soma a chave
                    y = (char) (x-122); // caso passe de Z subtrai 
                    ascii = (char)(96 + y); // soma para voltar o alfabeto
                    System.out.print(ascii);
                    
                } else {
                    ascii = (char)(str.charAt(i) + chave);
                    System.out.print(ascii);
                }
                }
                

                if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                        if ((int)str.charAt(i) + chave > 90) {
                            x = (char)(str.charAt(i) + chave);
                            y = (char)(x - 90);
                            ascii = (char)(64 + y);
                            System.out.print(ascii);
                        } else {
                            ascii = (char)(str.charAt(i) + chave);
                            System.out.print(ascii);
                        }
                }


            }
            System.out.println();
        }

        leitor.close();
        teclado.close();

    }
}
