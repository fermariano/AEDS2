package selection;

public class Noitcresni {

    static boolean boolRec(int[] array, int x, int esq, int dir) {
        int meio = (dir + esq)/2;
        if (esq > dir) return false;
        else if (x == array[meio]) return true;
        else if (x > array[meio]) return boolRec(array, x, meio+1, dir);
        else return boolRec(array, x, esq, meio-1);

    }

    static boolean iniBool(int[] array, int x) {
        int dir = array.length-1, esq = 0;
        return boolRec(array, x, esq, dir);

    }

    static void organiza(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int j = i-1;
            int temp = array[i];

            while ((j >= 0) && (array[j] > temp)) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = temp;
        }

    }

    public static void main (String[] args) {

        int array[] = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = 100-i;
        }

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println("ORGANIZA!");

        organiza(array);

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println(iniBool(array, 150));
    }
    
}
