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

Jogador arrJogadores[500];
int nArrJogadores = 0;

int nComparacoes = 0;
int nMovimentacoes = 0;
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


  todosJogadores[ultimoJogador++] = jogador;
}

void swap(int pJ1, int pJ2) {
  nMovimentacoes+=3;
  Jogador tmp = arrJogadores[pJ1];
  arrJogadores[pJ1] = arrJogadores[pJ2];
  arrJogadores[pJ2] = tmp;
}

bool isMaior(char *str1, char *str2) {
  return strcmp(str1, str2) > 0;
}

bool isMenor(char *str1, char *str2) {
  return strcmp(str1, str2) < 0;
}

bool isIgual(char *str1, char *str2) {
  return strcmp(str1, str2) == 0;
}


Jogador getMax() {
    Jogador maior = arrJogadores[0];
    for (int i = 1; i < nArrJogadores; i++) {
        if (getId(maior) < getId(arrJogadores[i])) {
            maior = arrJogadores[i];
        }
    }
    return maior;
}

int getMaiorFilho(int i, int tam) {
    int filho = i;
    int esquerda = 2 * i + 1;
    int direita = 2 * i + 2;

    if (esquerda < tam &&
        ( getAltura(arrJogadores[esquerda]) > getAltura(arrJogadores[filho]) ||
         (getAltura(arrJogadores[esquerda]) == getAltura(arrJogadores[filho]) &&
          strcmp(getNome(arrJogadores[esquerda]), getNome(arrJogadores[filho])) > 0))) {
        filho = esquerda;
    }

    if (direita < tam &&
        (getAltura(arrJogadores[direita]) > getAltura(arrJogadores[filho]) ||
         (getAltura(arrJogadores[direita]) == getAltura(arrJogadores[filho]) &&
          strcmp(getNome(arrJogadores[direita]), getNome(arrJogadores[filho])) > 0))) {
        filho = direita;
    }

    return filho;
}

void construir(int tam) {
    for (int i = tam / 2 - 1; i >= 0; i--) {
        int maior = getMaiorFilho(i, tam);
        if (maior != i) {
            swap(i, maior);
        }
    }
}

void heapsort() {

    int tam = nArrJogadores;

    for (int i = tam / 2 - 1; i >= 0; i--) {
        construir(tam);
    }

    for (int i = tam - 1; i > 0; i--) {
        swap(0, i);
        construir(i);
    }

}


void lerArq(char *path) {
  FILE *arq = fopen(path, "r");
  if (arq == NULL) {
    perror("Erro ao abrir o arquivo");
  }
  char linha[1024];
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
  const char *nomeArquivo = "matrícula_radixsort.txt";
  char content[100];
  snprintf(content, sizeof(content), "811694\t%d", nComparacoes);
  snprintf(content + strlen(content), sizeof(content) - strlen(content), "\t%d", nMovimentacoes);
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

  tempoInicial = clock();
  heapsort();
  tempoFinal = clock();

  duracao = tempoFinal - tempoInicial;

  for(int i = 0; i < 10; i++) {
    imprimir(arrJogadores[i]);
  }


  return 0;
}