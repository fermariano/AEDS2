import java.util.Scanner;

class Celula {
    Celula prox;
    String produto;

    Celula(String produto) {
        prox = null;
        this.produto = produto;
    }


    public Celula getProx() {
        return this.prox;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }

    public String getProduto() {
        return this.produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }


}

class Lista {
    Celula inicio, fim;

    Lista() {
        inicio = fim = null;
    }

    boolean confere(String add) {

        Celula i = inicio;

        if (inicio == null) return true;

        while (i != null) {
            if (i.getProduto().equals(add)) return false;
            i = i.getProx();
        }

        return true;
    }

    void inserir(String produto) {
        if (inicio == null) {
           inicio = new Celula(produto);
            fim = inicio;
        } else {
            Celula aux = new Celula(produto);
            fim.setProx(aux);
            fim = fim.getProx();
        }
    }

    void swap(Celula i, Celula pivo) {
        String tmp = i.getProduto();
        i.setProduto(pivo.getProduto());
        pivo.setProduto(tmp);
    }

    void quicksort() {
        quicksort(inicio, fim);
    }

    void quicksort(Celula begin, Celula end) {
        Celula i = begin;
        Celula divisor = begin;
        String pivo = begin.getProduto();

        while (i != end.getProx()) {

            if (i.getProduto().compareTo(pivo) < 0) {
                swap(i, divisor);
                divisor = divisor.getProx();
            }
            
                i = i.getProx();
    
            
        }

        if (begin != divisor) {
            quicksort(begin, divisor);
        }

        if (end != divisor) {
            quicksort(divisor.getProx(), end);
        }

    }

    void mostrar() {
        Celula i = inicio;
        while (i != null) {
            System.out.print(i.getProduto() + " ");
            i = i.getProx();
        }
        System.out.println();
    }
}

public class ListaCompra {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        int n = teclado.nextInt();
        teclado.nextLine();
        
        for (int i = 0; i < n; i++) {
            Lista lista = new Lista();

            String produto = teclado.nextLine();

            String[] produtos = produto.split(" ");

            for (int j = 0; j < produtos.length; j++) {
                if (lista.confere(produtos[j])) {
                lista.inserir(produtos[j]);
              } 
            }

            lista.quicksort();
            lista.mostrar();
            
        }

        teclado.close();
    }

    
}
