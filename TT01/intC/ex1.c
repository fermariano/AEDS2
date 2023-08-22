#include <stdio.h>

int main(void) {

  FILE *arqPrint = fopen("entrada.txt", "w");

  int t;

  printf("Tamanho do vetor: ");
  scanf("%d", &t);

  int vetor[t];

  for (int i = 0; i < t; i++) {
    printf("Posição %d: ", i);
    scanf("%d", &vetor[i]);
    fprintf(arqPrint, "%d", vetor[i]);
  }

  fclose(arqPrint);
  FILE *arqScan = fopen("entrada.txt", "r");

  while (fscanf(arqPrint, "%d", &t) != EOF) {
    printf("%d\n", t);
  }

  return 0;
}