import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        String str = teclado.nextLine();
        int num = 0, tmp;
        for (int i = 0; i < str.length(); i++){
            tmp = (int)(str.charAt(i) - 48);
            tmp *= (int)Math.pow(10, str.length() - i - 1);
            num += tmp;
        }

            System.out.println(num);
            teclado.close();

    }
}
