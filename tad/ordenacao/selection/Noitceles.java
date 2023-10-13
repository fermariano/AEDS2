package selection;

public class Noitceles {

    static boolean binarySearch(int[] vetor, int x) {
        boolean resp = false;
        int dir = vetor.length-1, esq = 0;
        int meio = (dir + esq) /2;

        while (dir >= esq) {
            if (x == vetor[meio]) {
                resp = true;
                return resp;
            } else if (x < vetor[meio]) {
                dir = meio-1;
                meio = (dir + esq)/2;
            } else {
                esq = meio +1;
                meio = (dir+esq)/2;
            }
        }
           return resp;
    }

    static void swap(int menor, int j, int[] vetor) {
        int temp;
        temp = vetor[j];
        vetor[j] = vetor[menor];
        vetor[menor] = temp;
    }

    static void organiza(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int menor = i;
            for (int j = (i+1); j < array.length; j++) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }
            swap(menor, i, array);
        }

    }

    public static void main(String[] args) {

        int[] vetor = new int[100];

        for (int i = 99; i >= 0; i--) {
            vetor[99 - i] = i;
        }

        for (int num1 : vetor) {
            MyIO.print(num1 + " ");
        }

        System.out.println();
        System.out.println("-----ORGANIZA!------");
        System.out.println();

        organiza(vetor);

        for (int num : vetor) {
            MyIO.print(num + " ");
        }

        System.out.println(binarySearch(vetor, 122));

    }
    
    
}
