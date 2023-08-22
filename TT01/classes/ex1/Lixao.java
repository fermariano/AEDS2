import java.util.Scanner;

public class Lixao {
    public static void main(String[] args) throws Exception {
        
        Retangulo r1 = new Retangulo();
        Retangulo r2 = new Retangulo();

        Scanner teclado = new Scanner(System.in);

        System.out.print("Base do primeiro retângulo: ");
        float base1 = teclado.nextFloat();

        System.out.print("Altura do primeiro retângulo: ");
        float altura1 = teclado.nextFloat();

        r1.starter(base1, altura1);

        System.out.print("Base do segundo retângulo: ");
        float base2 = teclado.nextFloat();

        System.out.print("Altura do segundo retângulo: ");
        float altura2 = teclado.nextFloat();

        r2.starter(base2, altura2);

        r1.printar();
        System.out.println("-------");
        r2.printar();

        teclado.close();

    }
}
