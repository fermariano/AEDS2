package insertion;

public class InsercaoL {

    static boolean binarySearch(int[] array, int x, int esq, int dir) {
        int meio = (esq+dir)/2;
        if (esq > dir) return false;
        if (array[meio] == x) return true;
        else if (x > array[meio]) return binarySearch(array,x,meio+1,dir);
        else return binarySearch(array,x,esq,meio-1);
    }

    static boolean iniSearch(int[] array, int x) {
        int esq = 0, dir = array.length-1;
        return binarySearch(array, x, esq, dir);
    }

    static void ordena(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int aux = array[i];
            int j = (i-1);

            while ((j >= 0) && aux < array[j]) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = aux;
        }

    }

    public static void main(String[] args) {

        int array[] = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = 100-i;
        }

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("\nORGANIZA\n");

        ordena(array);

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println(iniSearch(array, 169));

    }

    
}
