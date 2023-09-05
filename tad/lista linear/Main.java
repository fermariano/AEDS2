public class Main {
    public static void main (String[] args) {

        Fila teste = new Fila();

        teste.inserir(4);
        teste.inserir(7);
        teste.inserir(8);
        teste.inserir(9);
        teste.inserir(10);
        teste.inserir(3);
        
        teste.mostrar();


        System.out.println(teste.remover());

        teste.mostrar();

        System.out.println("-------------");

        Pilha pilha = new Pilha();

        pilha.inserir(5);
        pilha.mostrar();
        pilha.inserir(6);
        pilha.mostrar();

        System.out.println(pilha.remover());

        pilha.mostrar();
        

    }
}