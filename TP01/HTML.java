import java.io.*;
import java.net.*;

public class HTML {
    
    public static int[] ifs (String frase) {

        int vetor[] = new int[25];


        for (int i = 0; i < 25; i++) {
            vetor[i] = 0;
        }

        
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == '\u0061') {
                vetor[0] += 1;
            } else if (frase.charAt(i) == '\u0065') {
                vetor[1] += 1;
            } else if (frase.charAt(i) == '\u0069') {
                vetor[2] += 1;
            } else if (frase.charAt(i) == '\u006f') {
                vetor[3] += 1;
            } else if (frase.charAt(i) == '\u0075') {
                vetor[4] += 1;
            } else if (frase.charAt(i) == '\u00e1') {
                vetor[5] += 1;
            } else if (frase.charAt(i) == '\u00e9') {
                vetor[6] += 1;
            } else if (frase.charAt(i) == '\u00ed') {
                vetor[7] += 1;
            } else if (frase.charAt(i) == '\u00f3') {
                vetor[8] += 1;
            } else if (frase.charAt(i) == '\u00fa') {
                vetor[9] += 1;
            } else if (frase.charAt(i) == '\u00e0') {
                vetor[10] += 1;
            } else if (frase.charAt(i) == '\u00e8') {
                vetor[11] += 1;
            } else if (frase.charAt(i) == '\u00ec') {
                vetor[12] += 1;
            } else if (frase.charAt(i) == '\u00f2') {
                vetor[13] += 1;
            } else if (frase.charAt(i) == '\u00f9') {
                vetor[14] += 1;
            } else if (frase.charAt(i) == '\u00e3') {
                vetor[15] += 1;
            } else if (frase.charAt(i) == '\u00f5') {
                vetor[16] += 1;
            } else if (frase.charAt(i) == '\u00e2') {
                vetor[17] += 1;
            } else if (frase.charAt(i) == '\u00ea') {
                vetor[18] += 1;
            } else if (frase.charAt(i) == '<' && frase.charAt((i+1)) == 'b' && frase.charAt((i+2)) == 'r' && frase.charAt((i+3)) == '>') {
                vetor[20] += 1;
            } else if (frase.charAt(i) == '<' && frase.charAt((i+1)) == 't' && frase.charAt((i+2)) == 'a' && frase.charAt((i+3)) == 'b' && frase.charAt((i+4)) == 'l' && frase.charAt((i+5)) == 'e' && frase.charAt((i+6)) == '>') {
                vetor[21] += 1;  
                vetor[19] -= 3;
                vetor[1] -= 1;
                vetor[0] -= 1;
             } else if (frase.charAt(i) == '\u00f4') {
                vetor[22] += 1;
             } else if (frase.charAt(i) == '\u00fb') {
                vetor[23] += 1;
             } else if (frase.charAt(i) == '\u00ee') {
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

        MyIO.println("a("+ vetor[0] +") e("+vetor[1]+") i("+vetor[2]+") o("+vetor[3]+") u("+vetor[4]+") á("+vetor[5]+") é("+vetor[6]+") í("+vetor[7]+") ó("+vetor[8]+") ú("+vetor[9]+") à("+vetor[10]+") è("+vetor[11]+") ì("+vetor[12]+") ò("+vetor[13]+") ù("+vetor[14]+") ã("+vetor[15]+") õ("+vetor[16]+") â("+vetor[17]+") ê("+vetor[18]+") î("+vetor[24]+") ô("+vetor[22]+") û("+vetor[23]+") consoante("+vetor[19]+") <br>("+vetor[20]+") <table>("+vetor[21]+") " +name);
        
        


      }

      
      
      


      
   }
}

