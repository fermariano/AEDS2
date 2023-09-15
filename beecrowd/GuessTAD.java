import java.util.Arrays;
import java.util.Scanner;

public class GuessTAD {

    static boolean impossible(int[] numeros, int[] removidos, int contN, int contR) {
        boolean resp = false;
        int cont = 0;

        for (int i = numeros.length - 1; i >= numeros.length - contN; i--) {
            int aux = numeros[i];
            for (int j = 0; j < contR; j++) {
                if (aux == removidos[j]) {
                    cont++;
                } 
            }
        }
        
        if (cont == 0) resp = true;

        return resp;
    }

    static boolean pqueue(int[] numeros, int[] removidos, int contN, int contR) { // funciona
        boolean resp = false;
        int cont = 0;

        Arrays.sort(numeros);

        for (int i = 0 ; i < contR; i++) {
            if (removidos[i] == numeros[numeros.length - 1 - i]) {
                cont++;
            }
        }

        if (cont == contR) resp = true;


        return resp;


    }

    static boolean stack(int[] numeros, int[] removidos, int contN, int contR) { // funciona
        boolean resp = false;
        int cont = 0;
        int aux;

        if (contR > contN) aux = contR;
        else if (contR < contN) aux = contN;
        else aux = contN;
        
        
        for (int i = 0; i < aux; i++) {
             int j = contN - 1 - i;

            // System.out.println(numeros[i] + " " + removidos[j]);

            if (numeros[i] == removidos[j]) cont++;

            if (cont == contN) resp = true;
            //System.out.println(cont + " " + contN);

        }

        return resp;
    }

    static boolean queue(int[] numeros, int[] removidos, int contN, int contR) { // funciona
        boolean resp = false;
        int cont = 0;

        for (int i = 0; i < contN; i++) {
            if (numeros[i] == removidos[i]) {
                cont++;
            }
        }

        if (cont == contN) resp = true;

        return resp;

    }

    static boolean notsure(int[] numeros, int[] removidos, int contN, int contR) {
        boolean resp = false;
        int cont = 0;

        if (pqueue(numeros, removidos, contN, contR)) cont++;
        if (queue(numeros, removidos, contN, contR)) cont++;
        if (stack(numeros, removidos, contN, contR)) cont++;

        if (cont > 1) resp = true;
        System.out.println(cont);

        return resp;
    }
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNextLine()) {


            int n = teclado.nextInt();
            int numeros[] = new int[n];
            int removidos[] = new int[n];
            int contN = 0, contR = 0;
    
            
            for (int i = 0; i < n; i++) {
                int action = teclado.nextInt();
                if (action == 1) {
                    numeros[contN] = teclado.nextInt();
                    contN++;
                } else if (action == 2) {
                    removidos[contR] = teclado.nextInt();
                    contR++;
                }
            }

            int cont = 0;

            int aux[] = new int[n];
            int j = 0;

            for (int num : numeros) {
                aux[j] = num;
                j++;
            }
            


            if (queue(numeros,removidos,contN,contR)) {
               cont++;
            }

            if (stack(numeros,removidos,contN,contR)) {
               cont++;
            }

            if (pqueue(aux, removidos, contN, contR)) {
               cont++;
            }

            if (impossible(numeros, removidos, contN, contR)) {
              cont++;
            }

            if (cont > 2) {
                System.out.println("not sure");
            } else {
                if (queue(numeros,removidos,contN,contR)) {
                System.out.println("queue");
            }

            if (stack(numeros,removidos,contN,contR)) {
                System.out.println("stack");
               
            }

            if (pqueue(aux, removidos, contN, contR)) {
                System.out.println("priority queue");
               
            }

            if (impossible(aux, removidos, contN, contR)) {
                System.out.println("impossible");
              
            }


            }
            
        }
        teclado.close();
    }

}
            





    

    
