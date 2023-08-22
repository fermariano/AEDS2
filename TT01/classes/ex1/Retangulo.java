public class Retangulo {
    private float base;
    private float altura;

    public void starter(float bb, float hh) {
        set_base(bb);
        set_altura(hh);
    }

    Retangulo() {
        starter(0, 0);
    }

    Retangulo(float bb, float hh) {
        starter(bb, hh);
    }

    public void set_base(float bb) {
        if (bb >= 0) {
            base = bb;
        } else {
            System.out.println("Valor inválido!");
        }
    }

    public void set_altura(float hh) {
        if (hh >= 0) {
            altura = hh;
        } else {
            System.out.println("Valor inválido!");
        }
    }

    public float get_base() {
        return base;
    }

    public float get_altura() {
        return altura;
    }

    public double getArea() {
        double area = (double) (base*altura);
        return area;
    }

    public double getPerimetro() {
        double per = (double) (2*altura + 2*base);
        return per;
    }

    public double getDiagonal() {
        double diag = (double) (Math.sqrt(altura*altura + base*base));
        return diag;
    }

    public void printar() {
        System.out.format("Base: %.2f\n", get_base());
        System.out.format("Altura: %.2f\n", get_altura());
        System.out.format("Área: %.2f\n", getArea());
        System.out.format("Perímetro: %.2f\n", getPerimetro());
        System.out.format("Diagonal: %.2f\n", getDiagonal());
  }
}
