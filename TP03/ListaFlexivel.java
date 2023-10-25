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


    Celula() {

    }

    Celula(Jogador x) {
        elemento = x;
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

class Lista {
    Celula inicio, fim;
    int cont;

    Lista() {
        inicio = fim = null;
    }

    void add() {
        cont++;
    }

    int getCont() {
        return cont;
    }

    void inserirInicio(Jogador inserir) {
        Celula tmp = new Celula(inserir);
        tmp.setProx(inicio);
        inicio = tmp;
        if (fim == inicio) fim = tmp;
        cont++;
    }

    void inserirFim(Jogador inserir) {
        if (fim == null) {
            fim = new Celula(inserir);
            inicio = fim;
        } else {
            Celula tmp = new Celula(inserir);
            fim.setProx(tmp);
            fim = tmp;
        
        }
        add();
    }

    void inserirPos(Jogador inserir, int pos) throws NullPointerException {
        if (pos == 0) inserirInicio(inserir);
        else if (pos == cont-1) inserirFim(inserir);
        else if (pos < 0 || pos > cont-1) throw new NullPointerException("Posição inválida");
        
        else {
            Celula tmp = inicio;
            int cont = pos; // cria um contador com a posiçao
            Celula aux = new Celula(inserir);

            while(cont > 2) {
                tmp = tmp.getProx();
                cont--;
            } 

            aux.setProx(tmp.getProx());
            tmp.setProx(aux);
            add();
            
        }
        
    }

    String removerInicio() throws NullPointerException {
        if (inicio == fim) throw new NullPointerException("Lista vazia");
        
        Jogador aux = inicio.getElemento();

        inicio = inicio.getProx();

        cont--;

        return aux.getNome();

    }

    String removerFim() throws NullPointerException {
        if (inicio == fim) throw new NullPointerException("Lista vazia");

        Celula tmp = inicio;

        while (tmp.getProx() != null) tmp = tmp.getProx();

        Jogador aux = tmp.getProx().getElemento();

        tmp.setProx(null);
        fim = tmp;
        cont--;

        return aux.getNome();

    }

    String removerPos(int pos) throws NullPointerException {
        String aux = "";
        if (inicio == fim) throw new NullPointerException("Lista vazia");
        else if (pos == 0) aux = removerInicio();
        else if (pos == cont) aux = removerFim();
        else if (pos < 0 || pos >= cont) throw new NullPointerException("Posição inválida");
        else {
            Celula tmp = inicio;
            for (int i = 1; i < pos; i++) tmp = tmp.getProx();

            Celula remover = tmp.getProx();
            aux = remover.getElemento().getNome();
            tmp.setProx(tmp.getProx().getProx());
        }

        cont--;

        return aux;
        
    }

    void mostrar() {
        Celula aux = inicio;
        int conta = 0;
        while(aux != null) {
            System.out.print("[" + conta + "] ");
            aux.getElemento().imprimir();
            aux = aux.getProx();
            conta++;
        }
    }

}


class ListaFlexivel {

    static int cont = 0;

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
    String[] arrData = lerArq("players.csv"); // le o arquivoe cada posiçao é uma linha
    Jogador[] jogadorData = new Jogador[arrData.length]; // array com todos os jogadores
    

    for(int i = 0; i < arrData.length; i++) {
      String data = arrData[i];
      Jogador jogador = new Jogador();
      jogador.ler(data);
      jogadorData[i] = jogador;
    }

    Scanner teclado = new Scanner(System.in);
    Lista lista = new Lista();

    while (!teclado.hasNext("FIM")) {
      int aux = teclado.nextInt();
      lista.inserirFim(jogadorData[aux]);
      lista.add();


    }

    lista.mostrar();

    teclado.nextLine();
    teclado.nextLine();

    int aux = teclado.nextInt();

    for (int i = 0; i < aux; i++) {
        String action = teclado.next();
        if (action.equals("II")) {
            int id = teclado.nextInt();
            lista.inserirInicio(jogadorData[id]);
        } else if (action.equals("IF")) {
            int id = teclado.nextInt();
            lista.inserirFim(jogadorData[id]);
        } else if (action.equals("I*")) {
            int pos = teclado.nextInt();
            int id = teclado.nextInt();
            lista.inserirPos(jogadorData[id], pos);
        } else if (action.equals("RI")) {
            System.out.println("(R) " +lista.removerInicio());
        } else if (action.equals("RF")) {
            System.out.println("(R) " +lista.removerFim());
        } else if (action.equals("R*")) {
            int pos = teclado.nextInt();
            System.out.println("(R) " +lista.removerPos(pos));
        }
    }


       lista.mostrar();
    

    teclado.close();

}

}