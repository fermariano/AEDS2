package bubble;

public class Bubblesort {

    static void swap(int j, int j2, int[] array) {

        int temp = array[j];
        array[j] = array[j2];
        array[j2] = temp;
    }

    static void ordenar(int[] array) {

        int n = (array.length-1);

        for (int i = 0; i < n/2; i++) {

            for (int j = i; j < (n-i); j++) {
                if (array[j] > array[j+1]) {
                    swap(j, j+1, array);
                }
                
            }

            for (int j = (n - i); j > i; j--) {
                if (array[j] < array[j-1]) {
                    swap(j, j-1, array);
                }

            }


        }


    }

        static boolean binarySearch(int[]array, int x) {

            boolean resp = false;
            int dir = (array.length-1), esq = 0;

            while (dir > esq) {

            int meio = (dir + esq)/2;

            if (array[meio] == x) {
                resp = true;
                return resp;
            } else if (array[meio] < x) {
                esq = meio + 1;
                meio = (esq + dir)/2;
            } else {
                dir = meio - 1;
                meio = (esq + dir)/2;
            }

            }

            return resp;

        }

        public static void main (String[] args) {
            int[] vetor = new int[50];
            int cont = 50;

            for (int i = 0; i < 50; i++) {
                vetor[i] = cont;
                cont--;
            }

            for (int num : vetor) {
                System.out.print(num + " ");
            }

            ordenar(vetor);
            System.out.println();

            for (int num : vetor) {
                System.out.print(num + " ");
            }

            System.out.println(binarySearch(vetor, 69));

        }



    }
    

