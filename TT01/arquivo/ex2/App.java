public class App {
    public static void main(String[] args) throws Exception {
        
        Arq.openRead("exemplo.txt");

        String texto = " ";
        while (Arq.hasNext() == true) {
            texto += Arq.readChar();
        }

        Arq.close();

        Arq.openWrite("saida.txt");
        Arq.print(texto);
        Arq.close();

    }
}
