import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
      "[" +
      id +
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
      "]"
    );
  }
}


class InsertionTP {

  public static void swap(int menor, int i, Jogador[] array) {
    Jogador temp = array[i];
    array[i] = array[menor];
    array[menor] = temp;

  }

  public static boolean comp(Jogador atual, Jogador temp) {

    return (atual.getAnoNascimento() == temp.getAnoNascimento() && temp.getNome().compareTo(atual.getNome()) < 0);
  }

  public static void ordena(Jogador[] array, int cont) {
    int comp = 0, mov = 0;
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < cont; i++) {
        Jogador temp = array[i];
        int j = (i-1);
        comp += 2;
        while (j > 0 && temp.getAnoNascimento() < array[j].getAnoNascimento() || comp(array[j], temp)) {
            array[j+1] = array[j];
            mov++;
            j--;
        }
        array[j+1] = temp;
    }
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    try {
      criarArq(executionTime, comp, mov);

    } catch (IOException e) {
      System.out.println("Deu erro aqui" + e);
    }


  }

  public static void criarArq(long time, int comp, int mov) throws IOException { 
    File logs = new File("/tmp/matrícula_sequencial.txt");
    FileWriter write = new FileWriter(logs);
    write.write("811694" + "\t" + comp + "\t" + mov + "\t" + time);
    write.close();

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

  public static void main(String[] args) {
    String[] arrData = lerArq("players.csv"); // le o arquivoe cada posiçao é uma linha
    Jogador[] jogadorData = new Jogador[arrData.length]; // array com todos os jogadores
    Jogador[] arrayPesquisa = new Jogador[470];
    int cont = 0;

    for(int i = 0; i < arrData.length; i++) {
      String data = arrData[i];
      Jogador jogador = new Jogador();
      jogador.ler(data);
      jogadorData[i] = jogador;
    }

    Scanner teclado = new Scanner(System.in);

    while (!teclado.hasNext("FIM")) {
      int aux = teclado.nextInt();
      arrayPesquisa[cont] = jogadorData[aux];
      cont++;
    }

    teclado.nextLine();
    teclado.nextLine();
    
    ordena(arrayPesquisa, cont);
    
    for (int i = 0; i < cont; i++) {
      arrayPesquisa[i].imprimir();
    }
    
    
      teclado.close();
  }
}


