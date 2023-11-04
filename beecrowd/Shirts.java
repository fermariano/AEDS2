import java.util.Scanner;

class Aluno {
    String nome;
    String cor;
    String tamanho;

    Aluno(String nome, String cor, String tamanho) {
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

}

public class Shirts {

    public static void swap(int a, int b, Aluno[] alunos) {
        Aluno tmp = alunos[a];
        alunos[a] = alunos[b];
        alunos[b] = tmp;
    }

    static boolean compararMenor(Aluno[] alunos, int i, int pivo) {
        return alunos[i].getCor().compareTo(alunos[pivo].getCor()) < 0 
        || alunos[i].getCor().equals(alunos[pivo].getCor()) && alunos[i].getTamanho().compareTo(alunos[pivo].getTamanho()) > 0
        || alunos[i].getTamanho().equals(alunos[pivo].getTamanho()) && alunos[i].getNome().compareTo(alunos[pivo].getNome()) < 0; 
    }

    static boolean compararMaior(Aluno[] alunos, int i, int pivo) {
        return alunos[i].getCor().compareTo(alunos[pivo].getCor()) > 0 
        || alunos[i].getCor().equals(alunos[pivo].getCor()) && alunos[i].getTamanho().compareTo(alunos[pivo].getTamanho()) < 0
        || alunos[i].getCor().equals(alunos[pivo].getCor()) && alunos[i].getTamanho().equals(alunos[pivo].getTamanho()) && alunos[i].getNome().compareTo(alunos[pivo].getNome()) > 0; 
    }

    public static void bubblesort(Aluno[] alunos) {
        int i, j;
        int n = alunos.length;
        for (i = (n-1); i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (compararMaior(alunos, j, j+1)) {
                    swap(j, j+1, alunos);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        while (!teclado.hasNext("0")) {
            int n = teclado.nextInt();

            teclado.nextLine();

            Aluno[] alunos = new Aluno[n];

            for (int i = 0; i < n; i++) {
                String nome = teclado.nextLine();
                String cor = teclado.next();
                String tam = teclado.next();

                teclado.nextLine();

                //System.out.println(nome + "\n" + cor + "\n" + tam);

                alunos[i] = new Aluno(nome, cor, tam);

            }

            bubblesort(alunos);

            for (Aluno aluno : alunos) {
                System.out.print(aluno.getCor() + " " + aluno.getTamanho() + " " + aluno.getNome() + "\n");
            }
            System.out.println();
        }
        

        teclado.close();
    }

}
