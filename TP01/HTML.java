import java.io.*;
import java.net.*;

public class HTML {
    
    public static int[] ifs (String frase) {

        int vetor[] = new int[25];


        for (int i = 0; i < 25; i++) {
            vetor[i] = 0;
        }

        
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'a') {
                vetor[0] += 1;
            } else if (frase.charAt(i) == 'e') {
                vetor[1] += 1;
            } else if (frase.charAt(i) == 'i') {
                vetor[2] += 1;
            } else if (frase.charAt(i) == 'o') {
                vetor[3] += 1;
            } else if (frase.charAt(i) == 'u') {
                vetor[4] += 1;
            } else if (frase.charAt(i) == 'á') {
                vetor[5] += 1;
            } else if (frase.charAt(i) == 'é') {
                vetor[6] += 1;
            } else if (frase.charAt(i) == 'í') {
                vetor[7] += 1;
            } else if (frase.charAt(i) == 'ó') {
                vetor[8] += 1;
            } else if (frase.charAt(i) == 'ú') {
                vetor[9] += 1;
            } else if (frase.charAt(i) == 'à') {
                vetor[10] += 1;
            } else if (frase.charAt(i) == 'è') {
                vetor[11] += 1;
            } else if (frase.charAt(i) == 'ì') {
                vetor[12] += 1;
            } else if (frase.charAt(i) == 'ò') {
                vetor[13] += 1;
            } else if (frase.charAt(i) == 'ù') {
                vetor[14] += 1;
            } else if (frase.charAt(i) == 'ã') {
                vetor[15] += 1;
            } else if (frase.charAt(i) == 'õ') {
                vetor[16] += 1;
            } else if (frase.charAt(i) == 'â') {
                vetor[17] += 1;
            } else if (frase.charAt(i) == 'ê') {
                vetor[18] += 1;
            } else if (frase.charAt(i) == '<' && frase.charAt((i+1)) == 'b' && frase.charAt((i+2)) == 'r' && frase.charAt((i+3)) == '>') {
                vetor[20] += 1;
            } else if (frase.charAt(i) == '<' && frase.charAt((i+1)) == 't' && frase.charAt((i+2)) == 'a' && frase.charAt((i+3)) == 'b' && frase.charAt((i+4)) == 'l' && frase.charAt((i+5)) == 'e' && frase.charAt((i+6)) == '>') {
                vetor[21] += 1;  
                vetor[19] -= 3;
             } else if (frase.charAt(i) == 'ô') {
                vetor[22] += 1;
             } else if (frase.charAt(i) == 'û') {
                vetor[23] += 1;
             } else if (frase.charAt(i) == 'î') {
                vetor[24] += 1;
             } else if ((frase.charAt(i) >= 'a' && frase.charAt(i) <= 'z'))  {
                vetor[19] += 1;
             }
        }
        return vetor;

    }
    
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
   public static void main(String[] args) {

      
      String endereco, html;
      int[] vetor = new int[25];

      while(true) {
        
        String name = MyIO.readLine();

        if (name.length() == 3 && name.charAt(0) == 'F' && name.charAt(1) == 'I' && name.charAt(2) == 'M') {
            break;
        }

        endereco = MyIO.readLine();

        html = getHtml(endereco);

        vetor = ifs(html);

        System.out.printf("a(%d) e(%d) i(%d) o(%d) u(%d) á(%d) é(%d) í(%d) ó(%d) ú(%d) à(%d) è(%d) ì(%d) ò(%d) ù(%d) ã(%d) õ(%d) â(%d) ê(%d) î(%d) ô(%d) û(%d) consoante(%d) <br>(%d) <table>(%d) %s", vetor[0], vetor[1], vetor[2], vetor[3], vetor[4], vetor[5], vetor[6], vetor[7], vetor[8], vetor[9], vetor[10], vetor[11],vetor[12], vetor[13], vetor[14], vetor[15], vetor[16], vetor[17], vetor[18], vetor[24], vetor[22], vetor[23], vetor[19], vetor[20], vetor[21], name);
        System.out.println();
        


      }

      
      
      


      
   }
}

