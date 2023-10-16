public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.inserir(7);
        pilha.printar();
        pilha.inserir(3);
        pilha.printar();
        pilha.inserir(6);
        pilha.printar();
        pilha.inserir(10);
        pilha.printar();
        System.out.println("Soma: " +pilha.somaChama());
        System.out.println("Maior elemento: " +pilha.maiorElementoChama());
        System.out.print("Contrário: ");
        pilha.printaReverseI();
        System.out.println();
        pilha.remover();
        pilha.printar();
        pilha.remover();
        pilha.printar();
    }
}
