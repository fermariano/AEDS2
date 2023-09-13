/*
 * Entrada
    A primeira linha de entrada contém um inteiro N que indica a quantidade de idas à feira de dona Parcinova (que nada mais é do que o número de casos de teste que vem a seguir). 
    Cada caso de teste inicia com um inteiro M que indica a quantidade de produtos que estão disponíveis para venda na feira. Seguem os M produtos com seus preços respectivos por 
    unidade ou Kg. A próxima linha de entrada contém um inteiro P (1 ≤ P ≤ M) que indica a quantidade de diferentes produtos que dona Parcinova deseja comprar. Seguem P linhas 
    contendo cada uma delas um texto (com até 50 caracteres) e um valor inteiro, que indicam respectivamente o nome de cada produto e a quantidade deste produto.

    Saída
    Para cada caso de teste, imprima o valor que será gasto por dona Parcinova no seguinte formato: R$ seguido de um espaço e seguido do valor, com 2 casas decimais, 
    conforme o exemplo abaixo.
 * 
 * 
 */

import java.util.Locale;
import java.util.Scanner;

public class Feira {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.ENGLISH);

        int n = teclado.nextInt();

        for (int i = 0; i < n; i++) {
            int item = teclado.nextInt();
            float soma = 0;
    
            String[] produtoN = new String[item];
            float[] produtoP = new float[item];
    
            for (int j = 0; j < item; j++) {
                produtoN[j] = teclado.next();
                produtoP[j] = teclado.nextFloat();
                
            }

            int p = teclado.nextInt();

            for (int j = 0; j < p; j++) {
                String verd = teclado.next();
                int quant = teclado.nextInt();
                for (int k = 0; k < produtoN.length; k++) {
                    if (verd.equals(produtoN[k])) {
                        soma += produtoP[k] * quant;
                        k = produtoN.length;
                    }
                }

           }

           System.out.printf("R$ %.2f\n", soma);
        }


        teclado.close();
    }
}
