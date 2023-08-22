public class Ponto {
    private double x;
    private double y;
    private int id;
    private int nextID = 0;

    public void starter(double xx, double yy) {
        set_x(xx);
        set_y(yy);
        id = nextID;
        nextID++;
    }

    Ponto() {
        starter(0, 0);
    }

    Ponto(double x, double y) {
        starter(x, y);
    }

    void set_x(double xx) {
        x = xx;
    }

    void set_y(double yy) {
        y = yy;
    }

    public static double dist(double v) {
        double distancia = x - v;
        Math.abs(distancia);
        return distancia; 

    }

    public static double dist(double a, double b) {
        double distancia = a - b;
        Math.abs(distancia);
        return distancia;
    }


    public static double dist(Ponto valor) {
        double distancia =  x - valor.x;
        Math.abs(distancia);
        return distancia;
    }



    public static boolean isTriangulo(Ponto valor1, Ponto valor2, Ponto valor3) {

        boolean teste = false;

        if (valor1.x < (valor2.x + valor3.x) && valor2.x < (valor1.x + valor3.x) && valor3.x < (valor1.x + valor2.x)) {
            teste = true;
        } 

        return teste;

    }

    public double getAreaRetangulo(Ponto valor) {

        double area = (valor.x * valor.y);
        return area;

    }

    public int getID() {
        return id;
    }

    public static int getNextID() {
        return nextID;
    }


}