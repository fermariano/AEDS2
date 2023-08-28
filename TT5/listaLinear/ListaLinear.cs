public class Program {

    public class Lista {
        int[] vetor;
        int cont;

        public Lista() {
            vetor = new int[6]; //tamanho padrao de 6
            cont = 0;
        }

         public Lista(int t) {
            vetor = new int[t];
            cont = 0;
        }

        public void InserirInicio(int n) {
            if (cont == 0) {
                vetor[0] = n;
                cont++;
            } else {
                for (int i = cont; i > 0; i--) {
                    vetor[i] = vetor[i - 1];
                }
                vetor[0] = n;
                cont++;
            }
        }

        public void InserirFim(int n) {
            if (cont >= vetor.Length) {
                Console.WriteLine("[ERRO] Out of range");
            }

            vetor[cont] = n;
            cont++;

        }

        public void Inserir(int n, int pos) {
            if (cont >= vetor.Length) Console.WriteLine("[ERRO] Out of range");
            if (pos == 0) {
                InserirInicio(n);
            } else if (pos == cont) {
                InserirFim(n);
            } else {
                for (int i = cont; i > pos; i--) {
                    vetor[i] = vetor[i - 1];
                }
            }

            vetor[pos] = n;
            cont++;
        }

        public int RemoverInicio() {
            if (cont == 0) Console.WriteLine("[ERRO] Out of range");
            int temp = vetor[0];

            cont--;

            for (int i = 0; i < cont; i++) {
                vetor[i] = vetor[i + 1];
            }

            return temp;

        }

        public int RemoverFim() {
            if (cont == 0) Console.WriteLine("[ERRO] Out of range");
            return vetor[--cont]; // tira uma posiçao do array
        }

        public int Remover(int pos) {
            if (pos > vetor.Length || pos < 0) Console.WriteLine("[ERRO]Out of range");

            int aux = vetor[pos];

            for (int i = pos; i < cont; i++) {
                vetor[i] = vetor[i + 1];
            }

            cont--;

            return aux;

        }

        public void Mostrar() {

            Console.Write("Lista sequencial: ");
            for (int i = 0; i < cont; i++) {
                Console.Write(vetor[i] + " ");
            }
            Console.WriteLine();

        }




    }
    public static void Main(String[] args) {

        Console.WriteLine("==== LISTA LINEAR ====");

        Lista lista = new Lista(6);
        int x1, x2, x3;

        lista.InserirInicio(1);
        lista.InserirFim(7);
        lista.InserirFim(9);
        lista.InserirInicio(3);
        lista.Inserir(8, 3);
        lista.Inserir(4, 2);
        lista.Mostrar();
        x1 = lista.RemoverInicio();
        x2 = lista.RemoverFim();
        x3 = lista.Remover(2);
        Console.WriteLine(x1 + ", " + x2 + ", " + x3);
        lista.Mostrar();

    }
}