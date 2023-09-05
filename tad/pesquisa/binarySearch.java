package pesquisa;

public class binarySearch {

    public static boolean search(int[] vetor, int x) {

        boolean resp = false;
        int esq = 0, dir = vetor.length-1, meio, pos;
        meio = (esq + dir) / 2;

        while (esq <= dir) {
            if (vetor[meio] == x) {
                resp = true;
                esq = vetor.length;
                pos = meio;
                MyIO.println(pos);
            } else if (x > vetor[meio]) {
                esq = meio + 1;
                meio = (dir + esq)/2;
            } else {
                dir = meio - 1;
                meio = (dir + esq)/2;
            }
        }
           
            return resp;
    }
    
    public static void main (String[] args) {

        int[] vetor = {1, 2, 3, 4, 5, 6};

        int x = 100;

        MyIO.println(search(vetor, x));

    }
    


}

