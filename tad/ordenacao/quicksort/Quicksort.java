package quicksort;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {

    static int k = 50;
    static int array[] = new int[k];

    public static int pivo(int dir, int esq) {
        int pivo;
        int aux[] = new int[3];
        int t = dir + esq;

        for (int i = 0; i < 3; i++) {
            aux[i] = (int) (Math.random() * (dir-esq)) + esq;
        }

        Arrays.sort(aux);

        pivo = aux[1];
        //System.out.println(pivo);
        return pivo;
    }

    public static void preenche() {
        Random gerador = new Random();
        for (int i = 0; i < k; i++) {
            array[i] = gerador.nextInt(100);
        }
    }

    public static void printAll() {
        System.out.print("[ ");
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public static void print(int esq, int dir) {
        System.out.print("[ ");
        for (int i = esq; i < dir; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quicksortP () {
        quicksort(0, array.length-1);
    }

    public static void quicksort (int esq, int dir) {

        // definição do direita esquerda e pivo
        int i = esq, j = dir, pivo;
        if (dir - esq > 2) pivo = array[pivo(dir, esq)];
        else pivo = array[(esq+dir)/2];

        // comparação dos trem
        while(i <= j) {
            while(array[i] < pivo) { // vai andando com o i na esquerda ate ele ser maior que o pivo
                i++; 
            }

            while (array[j] > pivo) { // vai andando com o j na direita a te ele ser menor que o pivo
                j--;
            }

            if (i <= j) { 
                swap(i, j); // quando acha os dois ele troca pra organizar bonitinho
                i++; // continua a andar
                j--; // continua a andar
            }
            // acabou de trocar todos os elementos do array atual (menores na esquerda e maiores na direita)
        }

        System.out.println(pivo);
        print(esq, dir);

        // chamada da recursão
        if (esq < j) { // se o j nao tiver ultrapassado o array
            quicksort(esq, j); // chama a função pra ordenar a outra parte (divide)
        }
        if (i < dir) { // se o i nao tiver ultrapassado o array tambem
            quicksort(i, dir); // chama a função pra ordenar a outra parte (divide)
        }
    }

    public static void main(String[] args) {
        preenche();
        printAll();
        quicksortP();
        printAll();

    }
}
