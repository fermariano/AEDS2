public class Is {

    public static String resp(boolean teste) {

        String resposta;

        if (teste) {
            resposta = "SIM";
        }  else {
            resposta = "NAO";
        }

        return resposta;

    }

    public static boolean isVogal(String frase) {

        boolean resp = false;
        int cont = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i' || frase.charAt(i) == 'o' || frase.charAt(i) == 'u' || frase.charAt(i) == 'A' || frase.charAt(i) == 'E' || frase.charAt(i) == 'I' || frase.charAt(i) == 'O' || frase.charAt(i) == 'U') {
                cont++;
            }  

            if (cont == frase.length()) resp = true;

        }
        return resp;
    }

    public static boolean isConsoante(String frase) {

        boolean resp = false;
        int cont = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (!(frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i' || frase.charAt(i) == 'o' || frase.charAt(i) == 'u' || frase.charAt(i) == 'A' || frase.charAt(i) == 'E' || frase.charAt(i) == 'I' || frase.charAt(i) == 'O' || frase.charAt(i) == 'U')) {
                cont++;
            }  

            if (cont == frase.length()) resp = true;

        }
        return resp;
    }

    public static boolean isInteiro(String frase) {
        boolean resp = false;
        int cont = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) >= 48 && frase.charAt(i) <= 57) cont++;

            if (cont == frase.length()) resp = true;
        }

        return resp;

    }

    public static boolean isReal(String frase) {
        boolean resp = false;
        int cont = 0, real = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (isInteiro(frase) || frase.charAt(i) >= 48 && frase.charAt(i) <= 57) cont++;
            if (frase.charAt(i) == '.' || frase.charAt(i) == ',') real++;

            if (cont == (frase.length() - 1) && real == 1) resp = true;
        }

        return resp;

    }


    public static void main (String[] args) {

        String frase = "";
        String resp = "";

        while (true) {

            frase = MyIO.readLine();

            if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
                break;
            }

            resp += resp(isVogal(frase));
            resp += " ";
            resp += resp(isConsoante(frase));
            resp += " ";
            resp += resp(isInteiro(frase));
            resp += " ";
            resp += resp(isReal(frase));

            MyIO.println(resp);

            resp = "";
        
        }

    }
}
