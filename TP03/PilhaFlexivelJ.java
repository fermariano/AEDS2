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

class Celula {
    Jogador elemento;
    Celula prox;

    Celula(Jogador x) {
        elemento = x;
        prox = null;
    }

    Celula() {
        prox = null;
    }

    public Jogador getElemento() {
        return this.elemento;
    }

    public void setElemento(Jogador elemento) {
        this.elemento = elemento;
    }

    public Celula getProx() {
        return this.prox;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }

}

public class PilhaFlexivel {
    Celula inicio, fim;

    PilhaFlexivel() {
        inicio = fim = null;
    }

    void inserir(Jogador x) {
        if (inicio == null) {
            inicio = new Celula(x);
            fim = inicio;
        } else {
            Celula tmp = new Celula(x);
            fim.setProx(tmp);
            fim = tmp;
        }
    }

    Jogador remover() throws NullPointerException {
        if (inicio == null) throw new NullPointerException("Pilha vazia");
        Celula tmp = inicio;
        while (tmp.getProx() != fim) {
            tmp = tmp.getProx();
        }

        Jogador aux = fim.getElemento();
        tmp.setProx(null);
        fim = tmp;
        return aux;

    }

    void mostrar() {
        Celula tmp = inicio;
        int cont = 0;
        while (tmp != null) {
            System.out.print("[" + cont + "]");
            tmp.getElemento().imprimir();
            cont++;
            tmp = tmp.getProx();
        }
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
        
    
        for(int i = 0; i < arrData.length; i++) {
          String data = arrData[i];
          Jogador jogador = new Jogador();
          jogador.ler(data);
          jogadorData[i] = jogador;
        }
    
        Scanner teclado = new Scanner(System.in);
       PilhaFlexivel pilha = new PilhaFlexivel();

        while(!teclado.hasNext("FIM")) {
            int aux = teclado.nextInt();
            pilha.inserir(jogadorData[aux]);
        }

        teclado.nextLine();
        teclado.nextLine();

        int n = teclado.nextInt();

        for (int i = 0; i < n; i++) {
            String opcao = teclado.next();

            if (opcao.equals("I")) {
                int aux = teclado.nextInt();
                pilha.inserir(jogadorData[aux]);
            } else if (opcao.equals("R")) {
                Jogador removido = pilha.remover();
                System.out.println("(R) " + removido.getNome());
            }

            
        }
        
        pilha.mostrar();
        teclado.close();
    }

    
}
