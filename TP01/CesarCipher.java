public class CesarCipher {

    public static String cifra(String frase) {

        int key = 3;
        String str = "";

        for (int i = 0; i < frase.length(); i++) {
            int temp;
            temp = ((int) frase.charAt(i)) + key;
            str += (char)temp;
        }

        return str;

    }
    public static void main (String[] args) {

        String frase = "teste";
             
         while (true) {
            frase = MyIO.readLine();
            if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
                break;
            }
             
             System.out.println(cifra(frase)); 
        }
          

        
    }
}
