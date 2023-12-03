import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Arvore {
    Node raiz;
    

    Arvore() {
        raiz = null;
    }

    public void inicia(int num) {
        raiz = inicia(raiz, num);
    }

    private Node inicia(Node i, int num) {
        if (i == null) {
            i = new Node(num);
        }
        else if (num < i.valor) {
            i.esq = inicia(i.esq, num);
        }
        else if(num > i.valor){
            i.dir = inicia(i.dir, num);
        }
        return i;
    }

    public void pesquisa(Jogador x){
        boolean resp = false;
        System.out.print("raiz" + " ");
        resp = pesquisa(x, raiz, resp);
        if (resp != true) {
            System.out.println("NAO");
        }
        else{
            System.out.println("SIM");
        }
    }

    private boolean pesquisa(Jogador x, Node i, boolean resp){
        if (i != null && resp != true) {
            //visitar
            resp = pesquisaSub(x.getNome(), i.raiz, resp);

            if (resp != true) {
                System.out.print("esq" + " ");
                resp = pesquisa(x, i.esq,resp);
    
                System.out.print("dir" + " ");
                resp = pesquisa(x, i.dir,resp);
            }
        }
        return resp;
    }

    private boolean pesquisaSub(String x, NodeSub i, boolean resp){
        if (resp != true && i != null) {
            //visitar
            if (i.valor.getNome().equals(x)) {
                resp = true;
                return resp;
            }
            
            System.out.print("ESQ" + " ");
            resp = pesquisaSub(x, i.esq, resp);

            System.out.print("DIR" + " ");
            resp = pesquisaSub(x, i.dir, resp);
        }
        return resp;
    }

    public void inserir(Jogador x) {
        raiz = inserir(x, raiz);
    }

    private Node inserir(Jogador x, Node i) {
        int h = x.getAltura() % 15;
        if (i == null) {
            i = new Node(h);
        } else if (h < i.valor % 15) {
            i.esq = inserir(x, i.esq);
        } else if (h > i.valor % 15) {
            i.dir = inserir(x, i.dir);
        } else {
            i.raiz = inserir(x, i.raiz);
        }
        return i;
    }

    private NodeSub inserir(Jogador x, NodeSub i) {
        if (i == null) {
            i = new NodeSub(x);
        } else if (x.getNome().compareTo(i.valor.getNome()) < 0) {
            i.esq = inserir(x, i.esq);
        } else if (x.getNome().compareTo(i.valor.getNome()) > 0) {
            i.dir = inserir(x, i.dir);
        } else {
            System.out.println("Erro");
        }
        return i;
    }

    public void caminharCentral() {
        caminharCentral(raiz);
    }

    public void caminharCentral(Node i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.println(i.valor + " ");
            caminharCentral(i.dir);
        }
    }

    public void caminharPos(Node i) {
        if (i != null) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.println(i.valor + " ");
        }
    }
}

class Node {
    Node esq, dir;
    int valor;
    NodeSub raiz;

    Node(int valor) {
        this.valor = valor;
        esq = dir = null;
    }
}

class NodeSub{
    NodeSub esq, dir;
    Jogador valor;

    NodeSub(Jogador valor) {
        this.valor = valor;
        esq = dir = null;
    }
}

public class Jogador {

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
    Arvore arvore = new Arvore();

    for(int i = 0; i < arrData.length; i++) {
      String data = arrData[i];
      Jogador jogador = new Jogador();
      jogador.ler(data);
      jogadorData[i] = jogador;
    }

    arvore.inicia(7);
    arvore.inicia(3);
    arvore.inicia(11);
    arvore.inicia(1);
    arvore.inicia(5);
    arvore.inicia(9);
    arvore.inicia(13);
    arvore.inicia(0);
    arvore.inicia(2);
    arvore.inicia(4);
    arvore.inicia(6);
    arvore.inicia(8);
    arvore.inicia(10);
    arvore.inicia(12);
    arvore.inicia(14);


        while (!teclado.hasNext("FIM")) {
            int aux = teclado.nextInt();
            arvore.inserir(jogadorData[aux]);
        }

        teclado.nextLine();
        teclado.nextLine();

        while (!teclado.hasNext("FIM")) {
                String aux = teclado.nextLine();
                System.out.print(aux + " ");
                Jogador teste = null;
                for (int i = 0; i < jogadorData.length; i++) {
                    if (aux.equals(jogadorData[i].getNome())) {
                        teste = jogadorData[i];
                        break;
                    }
                }
                if (teste != null) {
                    arvore.pesquisa(teste); 
                }
            }


            
            teclado.close();
        }


}





