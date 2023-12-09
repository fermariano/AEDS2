class No {
    int elemento;
    No esq, dir;
    boolean cor;

    No(int x) {
        elemento = x;
        esq = dir = null;
        cor = false;
    }

    No(int x, boolean cc) {
        elemento = x;
        esq = dir = null;
        cor = cc;
    } 

    public int getElemento() {
        return this.elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getEsq() {
        return this.esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return this.dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public boolean isCor() {
        return this.cor;
    }

    public boolean getCor() {
        return this.cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }

}

public class Redblack {
    No raiz;

    No rotacionarDir(No no) {
        No esq = no.esq;
        No esqDir = esq.dir;

        esq.dir = no;
        no.esq = esqDir;

        return esq;
    }  

    No rotacionarEsq(No no) {
        No dir = no.dir;
        No dirEsq = dir.esq;

        dir.esq = no;
        no.dir = dirEsq;

        return dir;
    }

    No rotacionarEsqDir(No no) {
        no.esq = rotacionarEsq(no.esq);
        return rotacionarDir(no);
    }

    No rotacionarDirEsq(No no) {
        no.dir = rotacionarDir(no.dir);
        return rotacionarEsq(no);
    }

    void inserir(int x) {
        if (raiz == null) {
            raiz = new No(x);
        } else if (raiz.esq == null && raiz.dir == null) {
            if (x < raiz.elemento) {
                raiz.esq = new No(x);
            } else if (x > raiz.elemento) {
                raiz.dir = new No(x);
            }
        }  else if (raiz.dir == null) {
            if (x > raiz.elemento) {
                raiz.dir = new No(x);
            } else if (x < raiz.esq.elemento) {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = x;
            } else if (x > raiz.esq.elemento) {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = x;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        } else if (raiz.esq == null) {
            if (x < raiz.elemento) {
                raiz.esq = new No(x);
            } else if (x > raiz.dir.elemento) {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = x;
            } else if (x < raiz.dir.elemento) {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = x;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        } else {
            inserir(x, raiz, null, null, null);
        }
    }

    boolean hasFilhoColorido(No no) {
        return no.esq != null && no.dir != null && no.esq.cor && no.dir.cor;
    }

    void inserir(int x, No i, No pai, No avo, No bisavo) {
        if (i == null) {
            if (x < pai.elemento) {
                i = pai.esq = new No(x, true);
            } else if (x > pai.elemento) {
                i = pai.dir = new No(x, true);
            }
            if (pai.cor == true) {
                balancear(i, pai, avo, bisavo);
            }
        } else {
            if (hasFilhoColorido(i)) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz) {
                    i.cor = false;
                } else if (pai.cor == true) {
                    balancear(i, pai, avo, bisavo);
                }
            }

            if (x < i.elemento) {
                inserir(x, i.esq, i, pai, avo);
            } else if (x > i.elemento) {
                inserir(x, i.dir, i, pai, avo);
            }

        }
    }

    void balancear(No i, No pai, No avo, No bisavo) {
        if (pai.cor) {
            if (pai.elemento > avo.elemento) { // se o pai for maior que o avo 
                if (i.elemento > pai.elemento) { // se o i for maior que o pai (todo para a direita)
                    // nota que vc sempre chama o avo porque voce rotaciona nele!
                   avo = rotacionarEsq(avo); // rotaçao simples a esquerda
                } else { // se for o cotovelo
                   avo = rotacionarDirEsq(avo); // rotaçao dupla direita-esquerda
                }
             } else { // se o pai for menor que o avo
                if (i.elemento < pai.elemento) { // se o elemento for menor que o pai quer dizer que ta tudo pra esquerda
                   avo = rotacionarDir(avo); // ai rotaciona pra direita!
                } else { // se for cotovelo
                   avo = rotacionarEsqDir(avo); // rotaciona esq-dir no avo
                }
             }
            if (bisavo == null) {
                raiz = avo;
            } else if (avo.elemento < bisavo.elemento) {
                bisavo.esq = avo;
            } else if (avo.elemento > bisavo.elemento) {
                bisavo.dir = avo;
            }

            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;

        }
    }

    // imprime os pais primeiro e depois os filhos
    public void caminharPre() {
        System.out.print("[ ");
        caminharPre(raiz);
        System.out.println("]");
    }

    private void caminharPre(No i) {
        if (i != null) {
        System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); 
        caminharPre(i.esq); 
        caminharPre(i.dir); 
        }
    }

    public static void main(String[] args) {
        Redblack arvore = new Redblack();
  
           arvore.inserir(4);
           arvore.caminharPre();
           arvore.inserir(35);
           arvore.caminharPre();
           arvore.inserir(10);
           arvore.caminharPre();
           arvore.inserir(13);
           arvore.caminharPre();
           arvore.inserir(3);
           arvore.caminharPre();
           arvore.inserir(30);
           arvore.caminharPre();
           arvore.inserir(15);
           arvore.caminharPre();
           arvore.inserir(12);
           arvore.caminharPre();
           arvore.inserir(7);
           arvore.caminharPre();
           arvore.inserir(40);
           arvore.caminharPre();
           arvore.inserir(20);
           arvore.caminharPre();
  
        
  
     }

    
}
