import java.io.*;
import java.net.*;

public class HTML2 {
    
    public static int[] ifs (String frase) {

        int vetor[] = new int[25];


        for (int i = 0; i < 25; i++) {
            vetor[i] = 0;
        }

        
        for (int i = 0; i < frase.length(); i++) {
            if ((int)frase.charAt(i) == 'a') {
                vetor[0] += 1;
            } else if ((int)frase.charAt(i) == 'e') {
                vetor[1] += 1;
            } else if ((int)frase.charAt(i) == 'i') {
                vetor[2] += 1;
            } else if ((int)frase.charAt(i) == 'o') {
                vetor[3] += 1;
            } else if ((int)frase.charAt(i) == 'u') {
                vetor[4] += 1;
            } else if ((int)frase.charAt(i) == 160) {
                vetor[5] += 1;
            } else if ((int)frase.charAt(i) == 130) {
                vetor[6] += 1;
            } else if ((int)frase.charAt(i) == 161) {
                vetor[7] += 1;
            } else if ((int)frase.charAt(i) == 162) {
                vetor[8] += 1;
            } else if ((int)frase.charAt(i) == 163) {
                vetor[9] += 1;
            } else if ((int)frase.charAt(i) == 133) {
                vetor[10] += 1;
            } else if ((int)frase.charAt(i) == 138) {
                vetor[11] += 1;
            } else if ((int)frase.charAt(i) == 141) {
                vetor[12] += 1;
            } else if ((int)frase.charAt(i) == 149) {
                vetor[13] += 1;
            } else if ((int)frase.charAt(i) == 151) {
                vetor[14] += 1;
            } else if ((int)frase.charAt(i) == 198) {
                vetor[15] += 1;
            } else if ((int)frase.charAt(i) == 228) {
                vetor[16] += 1;
            } else if ((int)frase.charAt(i) == 131) {
                vetor[17] += 1;
            } else if ((int)frase.charAt(i) == 136) {
                vetor[18] += 1;
            } else if ((int)frase.charAt(i) == '<' && (int)frase.charAt((i+1)) == 'b' && (int)frase.charAt((i+2)) == 'r' && (int)frase.charAt((i+3)) == '>') {
                vetor[20] += 1;
            } else if ((int)frase.charAt(i) == '<' && (int)frase.charAt((i+1)) == 't' && (int)frase.charAt((i+2)) == 'a' && (int)frase.charAt((i+3)) == 'b' && (int)frase.charAt((i+4)) == 'l' && (int)frase.charAt((i+5)) == 'e' && (int)frase.charAt((i+6)) == '>') {
                vetor[21] += 1;  
                vetor[19] -= 3;
             } else if ((int)frase.charAt(i) == 147) {
                vetor[22] += 1;
             } else if ((int)frase.charAt(i) == 150) {
                vetor[23] += 1;
             } else if ((int)frase.charAt(i) == 140) {
                vetor[24] += 1;
             } else if (((int)frase.charAt(i) >= 'a' && (int)frase.charAt(i) <= 'z'))  {
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

