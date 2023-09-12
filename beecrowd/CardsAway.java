/* Dada uma pilha de n cartas enumeradas de 1 até n com a carta 1 no topo e a carta n na base.  A seguinte operação é ralizada enquanto tiver 2 ou mais cartas na pilha.

Jogue fora a carta do topo e mova a próxima carta (a que ficou no topo) para a base da pilha.

Sua tarefa é encontrar a sequência de cartas descartadas e a última carta remanescente.

Cada linha de entrada (com exceção da última) contém um número n ≤ 50. A última linha contém 0 e não deve ser processada. Cada número de entrada produz duas linhas de saída. 
A primeira linha apresenta a sequência de cartas descartadas e a segunda linha apresenta a carta remanescente.

Entrada
A entrada consiste em um número indeterminado de linhas contendo cada uma um valor de 1 até 50. A última linha contém o valor 0.

Saída
Para cada caso de teste, imprima duas linhas. A primeira linha apresenta a sequência de cartas descartadas, cada uma delas separadas por uma vírgula e um espaço. 
A segunda linha apresenta o número da carta que restou. Nenhuma linha tem espaços extras no início ou no final. Veja exemplo para conferir o formato esperado. */

import java.util.Scanner;

public class CardsAway {
    public static void main (String[] args) {

        Scanner teclado = new Scanner(System.in);

        while (true) {
            int n = teclado.nextInt();
            if (n == 0) break;
            int array[] = new int[n];
            int arraytemp[] = new int[n-1];
            int cont = 0;
    
            for (int i = 0; i < n; i++) {
                array[i] = n-i;
            }

            int tamanho = n;

            while (tamanho >= 2) {

                arraytemp[cont] = array[tamanho-1];
                tamanho--;
                cont++;
                int aux = array[tamanho-1];

                for (int j = tamanho-1; j > 0; j--) {
                    array[j] = array[j-1];
                }

                array[0] = aux;

            }

            System.out.print("Discarded cards: ");

            for (int num : arraytemp) {
                System.out.print(num + " ");
            }

            System.out.print("\nRemaining card: ");

            System.out.println(array[0]);

        }




        teclado.close();

    }
}
