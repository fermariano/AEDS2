import java.util.Scanner;

public class App {

    public static boolean pesquisar(int[] vetor, int x) {

        boolean teste = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == x) {
                teste = true;
            }
        }

        return teste;

    }
    public static void main(String[] args) throws Exception { 
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int n = teclado.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.format("Elemento %d: ", i);
            vetor[i] = teclado.nextInt();
        }

        System.out.print("Digite o termo para pesquisa: ");
        int v = teclado.nextInt();

        if (pesquisar(vetor, v)) {
            System.out.format("O vetor contém o número %d\n", v);
        }  else {
            System.out.format("O vetor não contém o número %d\n", v);
        }

        teclado.close();
    }
}
