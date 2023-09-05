package ordenacao;

public class Selection {

    static boolean binarySearch(int[] array, int x) {
        boolean resp = false;

        int esq = 0, dir = array.length-1;

        while (dir >= esq) {
            int meio = (dir + esq) /2;
            if (array[meio] == x) {
                resp = true;
                esq = dir + 1;
            } else if (x > array[meio]) {
                esq = meio +1;
                meio = (dir + esq) /2;
            } else {
                dir = meio -1;
                meio = (dir + esq)/2;
            }
            

        }


        return resp;
    }

    static void swap (int[] array, int menor, int i) {

        int temp;
        temp = array[i];
        array[i] = array[menor];
        array[menor] = temp;

    }

    static void organiza (int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            int menor = i;

            for (int j = (i + 1); j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }

            swap(vetor, menor, i);

        }
    }

    public static void main (String[] main) {

        int[] vetor = new int[100];
        int cont = 100;

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = cont;
            cont--;
        }

        for (int num : vetor) {
            MyIO.print(num + " ");
        }

        organiza(vetor);

        System.out.println("ORGANIZA!");

        for(int num : vetor) {
            MyIO.print(num + " ");
        }

        System.out.println(binarySearch(vetor, 84));
    }
    
}
