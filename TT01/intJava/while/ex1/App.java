import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        int cont = 0;
        Scanner teclado = new Scanner(System.in);
        float soma = 0, media;
        
        while (cont < 5) {
            System.out.format("Digite a nota do aluno %d: ", cont);
            soma += teclado.nextInt();
            cont++;
        }

        media = soma/5;
        System.out.format("A média das notas é %.2f\n", media);

        teclado.close();

    }
}
