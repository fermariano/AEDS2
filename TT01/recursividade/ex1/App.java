public class App {

    public static int somar(int x, int y) {
        int resp = 0;
        if (y > 0) {
            resp = x + somar(x, y - 1);
        }

        return resp;

    }

    public static void main(String[] args) throws Exception {
        
        System.out.println(somar(3,4));


    }
}
