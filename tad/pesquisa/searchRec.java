package pesquisa;

public class searchRec {

    public static int boolIni(int[] vetor, int x) {
        int esq = 0, dir = vetor.length - 1;
        return boolRec(vetor, x, esq, dir);

    }

    public static int boolRec(int[] vetor, int x, int esq, int dir) {
        if (esq > dir) return -1;
        int meio = (esq + dir)/2;
        if (vetor[meio] == x) {
            return meio;
        } else if (x > vetor[meio]) {
            return boolRec(vetor, x, meio + 1, dir); // substitui o valor de esquerda
        } else {
            return boolRec(vetor, x, esq, meio - 1); // substitui o valor de direita
        }
    }

    public static void main(String[] args) {

        int[] vetor = {1, 2, 3, 4, 5, 6};
        int x = 5;

        MyIO.println(boolIni(vetor, x));

    }
     
}
