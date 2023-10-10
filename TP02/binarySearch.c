#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

typedef struct Jogador {
  int id;
  char nome[60];
  int altura;
  int peso;
  char universidade[60];
  int anoNascimento;
  char cidadeNascimento[60];
  char estadoNascimento[60];
} Jogador;

int getId(Jogador jogador) {
  return jogador.id;
}

void setId(Jogador *jogador, int novoId) {
  jogador->id = novoId;
}

char* getNome(Jogador jogador) {
  return strdup(jogador.nome); //strdup ??
}

void setNome(Jogador *jogador, char *novoNome) {
  strncpy(jogador->nome, novoNome, sizeof(jogador->nome));
  jogador->nome[sizeof(jogador->nome) - 1] = '\0';
}

int getAltura(Jogador jogador) {
  return jogador.altura;
}

void setAltura(Jogador *jogador, int novaAltura) {
  jogador->altura = novaAltura;
}

int getPeso(Jogador jogador) {
  return jogador.peso;
}

void setPeso(Jogador *jogador, int novoPeso) {
  jogador->peso = novoPeso;
}

char* getUniversidade(Jogador jogador) {
  return strdup(jogador.universidade);
}

void setUniversidade(Jogador *jogador, char *novaUniversidade) {
  strncpy(jogador->universidade, novaUniversidade, sizeof(jogador->universidade));
  jogador->universidade[sizeof(jogador->universidade) - 1] = '\0';
}

int getAnoNascimento(Jogador jogador) {
  return jogador.anoNascimento;
}

void setAnoNascimento(Jogador *jogador, int novoAnoNascimento) {
  jogador->anoNascimento = novoAnoNascimento;
}

char* getCidadeNascimento(Jogador jogador) {
  return strdup(jogador.cidadeNascimento);
}

void setCidadeNascimento(Jogador *jogador, char *novaCidadeNascimento) {
  strncpy(jogador->cidadeNascimento, novaCidadeNascimento, sizeof(jogador->cidadeNascimento));
  jogador->cidadeNascimento[sizeof(jogador->cidadeNascimento) - 1] = '\0';
}

char* getEstadoNascimento(Jogador jogador) {
  return strdup(jogador.estadoNascimento);
}

void setEstadoNascimento(Jogador *jogador, char *novoEstadoNascimento) {
  strncpy(jogador->estadoNascimento, novoEstadoNascimento, sizeof(jogador->estadoNascimento));
  jogador->estadoNascimento[sizeof(jogador->estadoNascimento) - 1] = '\0';
}

void imprimir(Jogador jogador) {
  printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
    getId(jogador),
    getNome(jogador),
    getAltura(jogador),
    getPeso(jogador),
    getAnoNascimento(jogador),
    getUniversidade(jogador),
    getCidadeNascimento(jogador),
    getEstadoNascimento(jogador)
  );
}

Jogador clone(Jogador jogador) {
  return jogador;
}

Jogador todosJogadores[3922]; // declara vetor de jogadores
int ultimoJogador = 1;

Jogador arrJogadores[200];
int nArrJogadores = 0;

int nComparacoes = 0;
clock_t tempoInicial, tempoFinal, duracao;

void ler(char* data) {
  Jogador jogador;
  int j = 0;
  char info[60];
  int i = 0; // constante

  // LOOP
    while(data[i] != ',') {
      info[j++] = data[i];
      i++;
    }
    info[j++] = '\0';
    setId(&jogador, atoi(info));

    //REPETE
    j = 0;
    info[j] = '\0';
    i++;
    while(data[i] != ',') {
      info[j++] = data[i];
      i++;
    }
    info[j++] = '\0';
    setNome(&jogador, info);

    //REPETE
    j = 0;
    info[j] = '\0';
    i++;
    while(data[i] != ',') {
      info[j++] = data[i];
      i++;
    }
    info[j++] = '\0';
    setAltura(&jogador, atoi(info));

    //REPETE
    j = 0;
    info[j] = '\0';
    i++;
    while(data[i] != ',') {
      info[j++] = data[i];
      i++;
    }
    info[j++] = '\0';
    setPeso(&jogador, atoi(info));

    //REPETE
    j = 0;
    info[j] = '\0';
    if (data[++i] == ',') {
      strcpy(info, "nao informado\0");
    } else {
      while(data[i] != ',') {
        info[j++] = data[i];
        i++;
      }
      info[j++] = '\0';
    }
    setUniversidade(&jogador, info);

    //REPETE
    j = 0;
    info[j] = '\0';
    i++;
    while(data[i] != ',') {
      info[j++] = data[i];
      i++;
    }
    info[j++] = '\0';
    setAnoNascimento(&jogador, atoi(info));

    //REPETE
    j = 0;
    info[j] = '\0';
    if (data[++i] == ',') {
      strcpy(info, "nao informado\0");
    } else {
      while(data[i] != ',') {
        info[j++] = data[i];
        i++;
      }
      info[j++] = '\0';
    }
    setCidadeNascimento(&jogador, info);

    //REPETE
    j = 0;
    info[j] = '\0';
    if (++i == strlen(data) - 1) {
      strcpy(info, "nao informado\0");
    } else {
      while(i != strlen(data) - 1) {
        info[j++] = data[i];
        i++;
      }
      info[j++] = '\0';
    }
    setEstadoNascimento(&jogador, info);

  // ENDLOOP

  todosJogadores[ultimoJogador++] = jogador;
}

bool isIgual(char *str1, char *str2) {
  return strcmp(str1, str2) == 0;
}

bool isMaior(char *str1, char *str2) {
  return strcmp(str1, str2) > 0;
}

bool pesquisaBinaria(char *key){
  int esq = 0;
  int dir = nArrJogadores - 1;
  int meio;
  while(esq <= dir) {
    nComparacoes++;
    meio = (esq + dir) / 2;
    if(isIgual(getNome(arrJogadores[meio]), key)) {
      nComparacoes++;
      return true;
    } else if (isMaior(getNome(arrJogadores[meio]), key)) {
      nComparacoes++;
      dir = meio - 1;
    } else {
      nComparacoes++;
      esq = meio + 1;
    }
  }
  return false;
}

void swap(int pJ1, int pJ2) {
  Jogador tmp = arrJogadores[pJ1];
  arrJogadores[pJ1] = arrJogadores[pJ2];
  arrJogadores[pJ2] = tmp;
}

void ordernarSelecao() {
  for(int i = 0; i < nArrJogadores; i++) {
    int menor = i;

    for (int j = i + 1; j < nArrJogadores; j++) {
      if (isMaior(getNome(arrJogadores[menor]), getNome(arrJogadores[j]))) {
        menor = j;
      }
    }

    swap(menor, i);
  }
}

void lerArq(char *path) {
  FILE *arq = fopen(path, "r");// declara um ponteiro do tipo file
  if (arq == NULL) {
    perror("Erro ao abrir o arquivo");
  }
  char linha[1024];// declara um vetor de chars(string) para ler a linha
  int isPrimeiraLinha = true;
  while (fgets(linha, sizeof(linha), arq)) {
    if (!isPrimeiraLinha) {
      ler(linha);
    } else {
      isPrimeiraLinha = false;
    }
  }
  fclose(arq);
}

bool isFim(char leitura[]) {
  if (leitura[0] == 'F' && leitura[1] == 'I' && leitura[2] == 'M') {
    return true;
  } else {
    return false;
  }
}

void logs() {
  const char *nomeArquivo = "789274_binaria.txt";
  char content[100];
  snprintf(content, sizeof(content), "789274\t%d", nComparacoes);
  double tempoDecorrido = (double)(duracao) / CLOCKS_PER_SEC;
  snprintf(content + strlen(content), sizeof(content) - strlen(content), "\t%.2f", tempoDecorrido);
  FILE *arquivo = fopen(nomeArquivo, "w");

  if (arquivo == NULL) {
    printf("Não foi possível abrir o arquivo para escrita.\n");
  }

  fputs(content, arquivo);
  fclose(arquivo);
}


int main() {
  lerArq("/tmp/players.csv");

  bool flag = true;
  while (flag) {
    char leitura[2000];
    scanf(" %[^\n]s", leitura);
    if (isFim(leitura)) {
      flag = false;
    } else {
      arrJogadores[nArrJogadores++] = todosJogadores[atoi(leitura) + 1];
    }
  }

  ordernarSelecao();

  bool flagSearch = true;
  tempoInicial = clock();
  while (flagSearch) {
    char leitura[2000];
    scanf(" %[^\n]s", leitura);
    if (isFim(leitura)) {
      flagSearch = false;
    } else {
      printf("%s\n", pesquisaBinaria(leitura) ? "SIM" : "NAO");
    }
  }
  tempoFinal = clock();

  logs();

  return 0;
}
