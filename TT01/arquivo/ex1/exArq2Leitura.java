
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.io.FileReader;
import java.io.BufferedReader;


public class exArq2Leitura {
    
    public static void main (String[] args) throws Exception {

        try {
            FileReader arq = new FileReader("teste.txt");
            BufferedReader leitura = new BufferedReader(arq);
            
            int inteiro = Integer.parseInt(leitura.readLine());
            double real = Double.parseDouble(leitura.readLine());
            String caractere = leitura.readLine();
            char c = caractere.charAt(0);
            String booleanoS = leitura.readLine();
            boolean booleano;

            if (booleanoS.compareTo("true") == 0) {
                 booleano = true;
            } else {
                booleano = false;
            }

            String str = leitura.readLine();


            System.out.println(inteiro);
            System.out.println(real);
            System.out.println(c);
            System.out.println(booleano);
            System.out.println(str);
            


            leitura.close();


        } catch (FileNotFoundException e) {
            System.out.println("[ERRO]");
            e.printStackTrace();
        }
        
    }

}
