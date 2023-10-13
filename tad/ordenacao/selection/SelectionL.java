package selection;

public class SelectionL {

    static boolean binaryRec(int[] vetor, int x, int dir, int esq) {

        int meio = (dir+esq)/2;
        if (dir < esq) return false;
        if (vetor[meio] == x) return true;
        else if (vetor[meio] < x) return binaryRec(vetor, x, dir, meio+1);
        else return binaryRec(vetor, x, meio-1, esq);

    }

    static boolean binarySearch(int[] vetor, int x){
        int dir = vetor.length-1, esq = 0;
        return binaryRec(vetor, x, dir, esq);

    }

    static void swap(int[] vetor, int i, int maior) {
        int temp = vetor[maior];
        vetor[maior] = vetor[i];
        vetor[i] = temp;

    }

    static void organiza (int[] vetor) {

        for (int i = 0; i < vetor.length-1; i++) {
            int maior = i;
            for (int j = (i+1); j < vetor.length; j++) {
                if (vetor[maior] < vetor[j]) {
                    maior = j;
                }
            }
            swap(vetor, i, maior);
        }

    }

    public static void main (String[] args) {

        int vetor[] = new int[100];
        int cont = 100;
        
        for (int i = 0; i < 100; i++) {
            vetor[i] = i;
        }

        for (int num : vetor) {
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println("ORGANIZA!");
        System.out.println();

        organiza(vetor);

        for (int num : vetor) {
            System.out.print(num + " ");
        }

        System.out.println(binarySearch(vetor, 584));


    }

    
}
