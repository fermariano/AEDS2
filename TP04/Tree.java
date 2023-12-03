import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Jogador {

  private int id;
  private String nome;
  private int altura;
  private int peso;
  private String universidade;
  private int anoNascimento;
  private String cidadeNascimento;
  private String estadoNascimento;

  public Jogador() {
    this.id = -1;
    this.nome = "";
    this.altura = -1;
    this.peso = -1;
    this.universidade = "";
    this.anoNascimento = -1;
    this.cidadeNascimento = "";
    this.estadoNascimento = "";
  }

  public Jogador(
    int id,
    String nome,
    int altura,
    int peso,
    String universidade,
    int anoNascimento,
    String cidadeNascimento,
    String estadoNascimento
  ) {
    this.id = id;
    this.nome = nome;
    this.altura = altura;
    this.peso = peso;
    this.universidade = universidade;
    this.anoNascimento = anoNascimento;
    this.cidadeNascimento = cidadeNascimento;
    this.estadoNascimento = estadoNascimento;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public int getAltura() {
    return altura;
  }

  public int getPeso() {
    return peso;
  }

  public String getUniversidade() {
    return universidade;
  }

  public int getAnoNascimento() {
    return anoNascimento;
  }

  public String getCidadeNascimento() {
    return cidadeNascimento;
  }

  public String getEstadoNascimento() {
    return estadoNascimento;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setId(String id) {
    int convertedId = id.equals("nao informado") ? -1 : Integer.parseInt(id);
    setId(convertedId);
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  public void setAltura(String altura) {
    int convertedAltura = altura.equals("nao informado") ? 0 : Integer.parseInt(altura);
    setAltura(convertedAltura);
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public void setPeso(String peso) {
    int convertedPeso = peso.equals("nao informado") ? 0 : Integer.parseInt(peso);
    setPeso(convertedPeso);
  }

  public void setUniversidade(String universidade) {
    this.universidade = universidade;
  }

  public void setAnoNascimento(int anoNascimento) {
    this.anoNascimento = anoNascimento;
  }

  public void setAnoNascimento(String anoNascimento) {
    int convertedAnoNascimento = anoNascimento.equals("nao informado") ? 0 : Integer.parseInt(anoNascimento);
    setAnoNascimento(convertedAnoNascimento);
  }

  public void setCidadeNascimento(String cidadeNascimento) {
    this.cidadeNascimento = cidadeNascimento;
  }

  public void setEstadoNascimento(String estadoNascimento) {
    this.estadoNascimento = estadoNascimento;
  }


  public Jogador clone() throws CloneNotSupportedException {
    Jogador clone = new Jogador();
    clone.nome = this.nome;
    clone.altura = this.altura;
    clone.peso = this.peso;
    clone.universidade = this.universidade;
    clone.anoNascimento =this.anoNascimento;
    clone.cidadeNascimento =this.cidadeNascimento;
    clone.estadoNascimento =this.estadoNascimento;
    return clone;

  }

  public void ler(String data) { // le e separa cada atributo bonitinho 
    String newData = "";
    if (data != null) {
      int aux = data.length();
      for(int j = 0; j < aux; j++) { 
        char letter = data.charAt(j); 
        char letter2 = (j + 1 == data.length()) ? ' ' : data.charAt(j + 1); 
        if(letter == ',' && letter2 == ',') { // se for duas virgulas substitui
          newData += ",nao informado";
        } else {
          if (j == data.length() - 1 && letter == ',' ) { // se for a ultima virgula tambem substitui
            newData += ",nao informado";
          } else {
            newData += letter;
          }
        }
      } 
      String[] infos = newData.split(","); // divide a string e separa as variaveis
      this.setId(infos[0]); 
      this.setNome(infos[1]);
      this.setAltura(infos[2]);
      this.setPeso(infos[3]);
      this.setUniversidade(infos[4]);
      this.setAnoNascimento(infos[5]);
      this.setCidadeNascimento(infos[6]);
      this.setEstadoNascimento(infos[7]);

    }
  }

  public void imprimir() {
    System.out.println(
      " ## " +
      nome +
      " ## " +
      altura +
      " ## " +
      peso +
      " ## " +
      anoNascimento +
      " ## " +
      universidade +
      " ## " +
      cidadeNascimento +
      " ## " +
      estadoNascimento +
      " ##"
    );
  }

}

class No {
    Jogador elemento;
    No dir, esq;

    No() {
        dir = esq = null;
    }

    No(Jogador x) {
        dir = esq = null;
        elemento = x;
    }


    public Jogador getElemento() {
        return this.elemento;
    }

    public void setElemento(Jogador elemento) {
        this.elemento = elemento;
    }

    public No getDir() {
        return this.dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public No getEsq() {
        return this.esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

}

public class Tree {
  No inicio;

  Tree() {
      inicio = null;
  }

  // inserir com passagem de pai
  // esse serve para testar a raiz
  void inserir(Jogador x) { // metodo que recebe o numero a ser inserido apenas 
      if (inicio == null) { // testa se ela ta vazia
          inicio = new No(x); // se river ela seta a raiz como o novo no
      } else if (x.getNome().compareTo(inicio.getElemento().getNome()) < 0) { // se nao tiver, testa se o elemento é menor
          inserir(x, inicio, inicio.getEsq()); // se for chama o outro metodo (que tem pai e filho) passando os respectivos nós
      } else if (x.getNome().compareTo(inicio.getElemento().getNome()) > 0) { // se o elemento for maior
          inserir(x, inicio, inicio.getDir()); // faz a mesma coisa com a direita
      }
  }

  // esse testa os elementos abaixo da raiz
  void inserir(Jogador x, No pai, No filho) {

      if (filho == null) { // "condição de parada" -> o filho ser null = achar um espaço livre para inserir
          filho = new No(x); // ai ele insere
          // aqui embaixo ele seta a ligaçao do pai
          if (x.getNome().compareTo(pai.getElemento().getNome()) > 0) { // se for maior
              pai.setDir(filho); // ele seta na direita
          } else if (x.getNome().compareTo(pai.getElemento().getNome()) < 0) { // se for menor
              pai.setEsq(filho); // ele seta na esquerda
          }
          // se nao achar um livre ele chama a função de novo descendo com o pai e o filho
      } else {
          if (x.getNome().compareTo(filho.getElemento().getNome()) < 0) { // se o elemento for menor que o filho
              inserir(x, filho, filho.getEsq()); // chama andando pra esquerda
          } else if (x.getNome().compareTo(filho.getElemento().getNome()) > 0) { // se for maior que o filho
              inserir(x, filho, filho.getDir()); // chama andando pra direita
          }
          
      }
    }

    No getMenorDir(No i) {
      No pai = i.getDir(); // seta o pai como a direita (porque é o menor da DIREITA!)
      No filho = pai; // seta o filho igual ao pai

      while (filho.getEsq() != null) { // anda com o filho ate achar o menor (ate nao existir mais esquerda)
          pai = filho;
          filho = filho.getEsq();
      }

      if (pai == filho) { // se ele nao andou nada é pq tem um so (tipo o filho nao tem filho)
          i.setDir(pai.getDir()); // ai ele so seta mesmo
      } else {
          pai.setEsq(filho.getDir()); // se ele andou é pq pegou certinho o menor filho. ai seta que a esquerda do pai (pq é menor) é a direita do filho
          // ele pula o filho
      }


      return filho;
    }

    // remover caminhando o pai e o filho
    void remover(Jogador x) { // essa função chama passando o inicio
      if (inicio == null) throw new NullPointerException("Árvore vazia"); // se o inicio tiver null a arvore ta vazia
      else if (x.getNome().compareTo(inicio.getElemento().getNome()) < 0) remover(x, inicio.getEsq(), inicio); // se o elemento for menor, chama a função pra esquerda
      else if (x.getNome().compareTo(inicio.getElemento().getNome()) > 0) remover(x, inicio.getDir(), inicio); // se o elemento for maior, chama a função pra direita
      else { // se achar o elemento
          if (inicio.getDir() == null) { // se o da direita for null
              inicio = inicio.getEsq(); // seta a raiz como esquerda
          } else if (inicio.getEsq() == null) { // se a esuqerda for null
              inicio = inicio.getDir(); // seta a raiz como direita
          } else { // se tiver os dois filhos
              inicio.setElemento(getMenorDir(inicio).getElemento()); // chama a funçao de pegar o menor da direita
          }
      }
    }      

    void remover(Jogador x, No i, No pai) throws NullPointerException {
          if (x.getNome().equals(i.getElemento().getNome())) { // essa é a condição de parada -> quando acha o elemento que quer remover
          if (x.getNome().compareTo(pai.getElemento().getNome()) < 0) { // se o elemento for menor que o pai
              if (i.getDir() == null) {  // se ele nao tiver o filho da direita
                  pai.setEsq(i.getEsq()); // seta o filho como a esquerda
              } else if (i.getEsq() == null) { // se ele nao tiver o filho da esquerda
                  pai.setEsq(i.getDir()); // seta o filho como a direita
              } else { // se ele tiver os dois filhos
                  Jogador novo = getMenorDir(i).getElemento(); // chama a funçao getMenorDir para pegar o menor da direita e ja refaz a ligação
                  i.setElemento(novo); // coloca o novo elemento onde o outro foi removido
              }
          } else if (x.getNome().compareTo(pai.getElemento().getNome()) > 0) { // se o elemento for maior que o pai
              if (i.getDir() == null) { // se ele nao tiver o filho da direita
                  pai.setDir(i.getEsq()); // seta o filho como esquerda
              } else if (i.getEsq() == null) { // se ele nao tiver o filho da esquerda
                  pai.setDir(i.getDir()); // seta o filho como direita
              } else {
                  Jogador novo = getMenorDir(i).getElemento(); // chama a funçao getMenorDir para pegar o menor da direita e ja refaz a ligação
                  i.setElemento(novo); // coloca o novo elemento onde o outro foi removido
              }
          } 
          } 
          // se nao tiver achado o elemento
          else if (x.getNome().compareTo(i.getElemento().getNome()) < 0) { // se ele for menor
              remover(x, i.getEsq(), i); // caminha pra esquerda
          } else if (x.getNome().compareTo(i.getElemento().getNome()) > 0) { // se ele for maior
              remover(x, i.getDir(), i); // caminha pra direita
          }
      

    }

    boolean pesquisa(String x) {
      System.out.print(x + " raiz ");
      boolean resp = false;
      if (inicio.getElemento().getNome().equals(x)) {
          resp = true;
      } else if (inicio.getElemento().getNome().compareTo(x) < 0) {
          System.out.print("dir ");
          resp = pesquisa(inicio.getDir(), x);
      } else if (inicio.getElemento().getNome().compareTo(x) > 0) {
          System.out.print("esq ");
          resp = pesquisa(inicio.getEsq(), x);
      }
  
      return resp;
  }
  
  boolean pesquisa(No i, String x) {
      boolean resp = false;
      if (i != null) {
          if (i.getElemento().getNome().equals(x)) {
              resp = true;
          } else if (i.getElemento().getNome().compareTo(x) < 0) {
              System.out.print("dir ");
              resp = pesquisa(i.getDir(), x);
          } else if (i.getElemento().getNome().compareTo(x) > 0) {
              System.out.print("esq ");
              resp = pesquisa(i.getEsq(), x);
          }
      }
  
      return resp;
  }
  


    public static String[] lerArq(String path) {
        File file = new File(path); // le o arquivo
        String[] arrData = new String[3922]; // array com linha por linha do arquivo
        int i = 0; 
        try {
          Scanner scanner = new Scanner(file); 
          scanner.nextLine(); 
          while (scanner.hasNext()) {
            arrData[i] = scanner.nextLine(); // le linha por linha e salva no array
            i++;
          }
          scanner.close();
        } catch (FileNotFoundException e) {
          System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
        return arrData;
      }
    
      public static void main(String[] args) throws Exception {
        String[] arrData = lerArq("/tmp/players.csv"); // le o arquivoe cada posiçao é uma linha
        Jogador[] jogadorData = new Jogador[arrData.length]; // array com todos os jogadores
        Scanner teclado = new Scanner(System.in);
        Tree arvore = new Tree();
    
        for(int i = 0; i < arrData.length; i++) {
          String data = arrData[i];
          Jogador jogador = new Jogador();
          jogador.ler(data);
          jogadorData[i] = jogador;
        }

        while(!teclado.hasNext("FIM")) {
          int aux = teclado.nextInt();
          arvore.inserir(jogadorData[aux]);
        }

        teclado.nextLine();
        teclado.nextLine();

        while (!teclado.hasNext("FIM")) {
          String aux = teclado.nextLine();
          if (arvore.pesquisa(aux)) {
            System.out.print("SIM");
          } else {
            System.out.print("NAO");
          }
          System.out.println();
        }

  

    
        
        

     
        teclado.close();
    }
    
}
