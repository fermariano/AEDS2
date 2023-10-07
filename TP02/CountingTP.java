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

  public void ler(String data) {
    String newData = "";
    if (data != null) {
      int aux = data.length();
      for(int j = 0; j < aux; j++) {
        char letter = data.charAt(j);
        char letter2 = (j + 1 == data.length()) ? ' ' : data.charAt(j + 1);
        if(letter == ',' && letter2 == ',') {
          newData += ",nao informado";
        } else {
          if (j == data.length() - 1 && letter == ',' ) {
            newData += ",nao informado";
          } else {
            newData += letter;
          }
        }
      }
      String[] infos = newData.split(",");
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


class CountingTP {

  static int comp = 0;
  static int mov = 0;

  public static void criarArq(long temp) throws IOException { 
    File logs = new File("/tmp/matrícula_sequencial.txt");
      FileWriter write = new FileWriter(logs);
      write.write("811694" + '\t' + temp + '\t' + comp + '\t' + mov);
      write.close();
  }

  public static void escArq(String info, File write, FileWriter escreve) throws IOException {
    escreve.write(info + '\t');
  }

  public static void swap(int a, int b, Jogador[] array) {
    mov+=3;
    Jogador temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  public static void inserction(Jogador[] array, int n) {
    for (int i = 0; i < n; i++) {
      int menor = i;
      for (int j = i+1; j < n; j++) {
        if (array[menor].getNome().compareTo(array[j].getNome()) > 0) {
          menor = j;
        }
      }
      swap(menor, i, array);
    }
  }

  public static int getMaior(Jogador[] array, int cont) {
    int maior = array[0].getAltura();
    for (int i = 1; i < cont; i++) {
        if (array[i].getAltura() > maior) maior = array[i].getAltura();
    } 
    return maior;
  }

  public static void countingsort(Jogador[] array, int n) {
    //Array para contar o numero de ocorrencias de cada elemento
    int[] count = new int[getMaior(array, n) + 1];
    Jogador[] ordenado = new Jogador[n];

    // Contagem das alturas
    for (int i = 0; i < n; i++) {
        count[array[i].getAltura()]++;
    }
    // Atualize o array de contagem para representar a posição correta de cada elemento
    for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1];
    }
    // Construa o array ordenado
    for (int i = n - 1; i >= 0; i--) {
        int altura = array[i].getAltura();
        ordenado[count[altura] - 1] = array[i];
        count[altura]--;
    }

    
    
    System.arraycopy(ordenado, 0, array, 0, n);
    }

  public static String[] lerArq(String path) {
    File file = new File("/tmp/"+path);
    String[] arrData = new String[3922];
    int i = 0;
    try {
      Scanner scanner = new Scanner(file);
      scanner.nextLine();
      while (scanner.hasNext()) {
        arrData[i] = scanner.nextLine();
        i++;
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado: " + e.getMessage());
    }
    return arrData;
  }

  public static void main(String[] args) {
    String[] arrData = lerArq("players.csv");
    Jogador[] jogadorData = new Jogador[arrData.length];
    Jogador[] arrayOrdena = new Jogador[470];
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
      arrayOrdena[cont] = jogadorData[aux];
      cont++;
    }
    

      long startTime = System.currentTimeMillis();
      inserction(arrayOrdena, cont);
      countingsort(arrayOrdena, cont);
      long endTime = System.currentTimeMillis();
      long executionTime = endTime - startTime;

      try {
        criarArq(executionTime);
      } catch (IOException e) {
        System.out.println("Erro aqui: " + e);
      }

      for (int i = 0; i < cont; i++) {
        arrayOrdena[i].imprimir();
      }

      teclado.close();
  }
}


