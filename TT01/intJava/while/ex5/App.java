import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int t = 4, cont = 0, menor = 0, maior = 0;
        int soma = 0; 
        Scanner teclado = new Scanner(System.in);
        int alunos[] = new int[t];
        
        System.out.print("Digite a nota máxima: ");
        int notaMax = teclado.nextInt();

        while (cont < t) {
            System.out.format("Aluno %d: ", cont);
            alunos[cont] = teclado.nextInt();
            
            soma += alunos[cont];

            if (alunos[cont] < (notaMax*0.6)) {
                menor++;
            }

            if (alunos[cont] >= (notaMax*0.9)) {
                maior++;
            }
            cont++;

        }

        int media = soma/t;

        System.out.format("Média: %d\n", media);
        System.out.format("Alunos abaixo da média: %d\n", menor);
        System.out.format("Alunos com conceito A: %d\n", maior);


        teclado.close();

    }
}
