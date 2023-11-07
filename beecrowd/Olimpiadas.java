import java.util.Scanner;

class Pais {
    int ouro, prata, bronze;
    String pais;

    Pais(String nome) {
        ouro = prata = bronze = 0;
        pais = nome;
    }


    public int getOuro() {
        return this.ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void addOuro() {
        ouro++;
    }

    public int getPrata() {
        return this.prata;
    }

    public void setPrata(int prata) {
        this.prata = prata;
    }

    public void addPrata() {
        prata++;
    }

    public int getBronze() {
        return this.bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public void addBronze() {
        bronze++;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


}

public class Olimpiadas {

    public static int existe(Pais[] mundo, String nome, int cont) { // retorna a posiçao que ele ta
        for (int i = 0; i < cont; i++) {
            if (mundo[i].getPais().equals(nome)) {
                return i;
            }
        }

        return -1;

    }

    public static boolean confere(Pais tmp, Pais j) {

        if (tmp.getOuro() < j.getOuro()) return true;
        else if (tmp.getOuro() == j.getOuro() && tmp.getPrata() < j.getPrata()) return true;
        else if (tmp.getOuro() == j.getOuro() && tmp.getPrata() == j.getPrata() && tmp.getBronze() < j.getBronze()) return true;
        else if (tmp.getOuro() == j.getOuro() && tmp.getPrata() == j.getPrata() && tmp.getBronze() == j.getBronze() && tmp.getPais().compareTo(j.getPais()) > 0) return true;
        
        return false;

    }

    public static void ordena(Pais[] mundo, int cont) {
        for (int i = 1; i < cont; i++) {
            Pais tmp = mundo[i];
            int j = i-1;

            while ((j >= 0) && confere(mundo[j], tmp)) {
                mundo[j+1] = mundo[j];
                j--;
            }

            mundo[j+1] = tmp;
        }
    }

    public static void printar(int cont, Pais[] mundo) {
        System.out.println("Quadro de medalhas");
        for (int i = 0; i < cont; i++) {
            System.out.println(mundo[i].getPais() + " " + mundo[i].getOuro() + " " + mundo[i].getPrata() + " " + mundo[i].getBronze());
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Pais[] mundo = new Pais[15];
        int cont = 0;

        while (teclado.hasNext()) {
            teclado.nextLine();
            
            for (int i = 0; i < 3; i++) {
                String nome = teclado.nextLine();
                if (i == 0) { // medalha de ouro
                    if (existe(mundo, nome, cont) == -1) { // se nao existir ele cria e adiciona
                        mundo[cont] = new Pais(nome);
                        mundo[cont].addOuro();
                        cont++;
                    } else { // se existir ele so adiciona
                        mundo[existe(mundo, nome, cont)].addOuro();
                    }
                } else if (i == 1) { // medalha de prata  
                    if (existe(mundo, nome, cont) == -1) { // se nao existir ele cria e adiciona
                        mundo[cont] = new Pais(nome);
                        mundo[cont].addPrata();
                        cont++;
                    } else { // se existir ele so adiciona
                        mundo[existe(mundo, nome, cont)].addPrata();
                    }
                } else { // medalha de bronze
                    if (existe(mundo, nome, cont) == -1) {   // se nao existir ele cria e adiciona
                        mundo[cont] = new Pais(nome);
                        mundo[cont].addBronze();
                        cont++;
                    } else { // se existir ele so adiciona
                        mundo[existe(mundo, nome, cont)].addBronze();
                    }
                }
            }

            
            
            
        }
        
        ordena(mundo, cont);
        printar(cont, mundo);
        teclado.close();
    }
}