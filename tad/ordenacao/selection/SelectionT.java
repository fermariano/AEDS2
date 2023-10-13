package selection;


public class SelectionT {

    static boolean rescBinary(int[] vetor, int x, int esq, int dir) {

        int meio = (dir+esq)/2;
        if (esq > dir) return false; // condiçao de parada caso nao encontre
        if (vetor[meio] == x) { // condiçao de parada caso encontre
            return true;
        } else if (vetor[meio] < x) { // chama a funçao de novo com novos valores
            return rescBinary(vetor, x, meio+1, dir);
        } else { // chama a funçao de novo com novos valores
            return rescBinary(vetor, x, esq, meio-1);
        }

    }

    static boolean binarySearch(int[] vetor, int x) {

        int esq = 0, dir = vetor.length-1;

        return rescBinary(vetor, x, esq, dir);
    }
    
    static void swap(int[] vetor, int menor, int i) {
        int temp = vetor[menor];
        vetor[menor] = vetor[i];
        vetor[i] = temp;
    
    }

    static void organiza(int[] vetor) {
       

        for (int i = 0; i < vetor.length-1; i++) {
             int menor = i;
            for (int j = (i+1); j < vetor.length; j++) {
                if (vetor[menor] > vetor[j]) {
                    menor = j;
                }

            }
            swap(vetor, menor, i);
        }

    }

    public static void main(String[] args) {

        int vetor[] = new int[100];
        int cont = 100;

        for (int i = 0; i < 100; i++) {
            vetor[i] = cont;
            cont--;
        }

        for (int num : vetor) {
            System.out.print(num + " ");
        }

        organiza(vetor);

        System.out.println();
        System.out.println("AAAAAAAAAAAAAAA");

        for (int num : vetor) {
            System.out.print(num + " ");
        }

        System.out.println(binarySearch(vetor, 101));


    }
    
}
