#include <stdio.h>

int main() {
    int linha, coluna, numeros;
    scanf("%d", &linha);
    scanf("%d", &coluna);
    scanf("%d", &numeros);


    int matriz[linha][coluna+1];

    for (int ln = 0; ln < linha; ln++) {
        for (int col = 0; col < coluna; col++) {
            scanf("%d", &matriz[ln][col]);
        }
    }

    int vetor[numeros];

    for (int i = 0; i < numeros; i++) {
        scanf("%d", &vetor[i]);
    }

    for (int i = 0; i < numeros; i++) {
        int comp = vetor[i];

        for (int ln = 0; ln < linha; ln++) {
            for (int col = 0; col < coluna; col++) {
                if (matriz[ln][col] == comp) {
                    if (matriz[ln][coluna] == coluna) {
                        printf("%d", ln);
                        ln = linha;
                        col = coluna;
                        i = numeros;
                    } 
                }
            }
        }
    }

}