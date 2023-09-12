import java.util.Scanner;

public class EvenOdd {

    static void ordenaP(int[] array) {

        int n = array.length;

        for (int i = 1; i < n; i++) {
            int temp = array[i];
            int j = (i-1);

            while ((j >= 0) && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = temp;
        }

    }

    static void ordenaI(int[] array) {

        int n = array.length;

        for (int i = 0; i < n; i++) {
            int temp = array[i];
            int j = (i-1);

            while ((j >= 0 && array[j] < temp)) {
                array[j+1] = array[j]; 
                j--;
            }
            array[j+1] = temp;
        }

    }
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int n = teclado.nextInt();
        int par, impar, contp, conti;
        contp = conti = par = impar = 0;

        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            int num = teclado.nextInt();

            if (num % 2 == 0) par++;
            else impar++;

            array[i] = num;

            
            
        }
        int vpar[] = new int[par];
        int vimpar[] = new int[impar];

        for (int j = 0; j < n; j++) {
            if (array[j] % 2 == 0) {
                vpar[contp] = array[j];
                contp++;
            } else {
                vimpar[conti] = array[j];
                conti++;
            }
        }

        ordenaP(vpar);
        ordenaI(vimpar);

        int cont = 0;

        for (int k = 0; k < vpar.length; k++) {
            array[k] = vpar[k];
        }

        for (int f = vpar.length; f < array.length; f++) {
            array[f] = vimpar[cont];
            cont++;
        }

        for (int index : array) {
            System.out.println(index);
        }
            teclado.close();
    }
}
