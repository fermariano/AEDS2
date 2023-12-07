class No {
    int elemento;
    No esq, dir;
    int altura;

    No(int x) {
        elemento = x;
        esq = dir = null;
        altura = 0;
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

    public static int getAltura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    public void setAltura() {
       this.altura = (getAltura(dir) > getAltura(esq)) ?  1 + getAltura(dir) : 1 + getAltura(esq);
    }


}

public class AVLTree {
    No raiz;

    boolean pesquisar(int x) {
        return pesquisar(x, raiz);
    }

    boolean pesquisar(int x, No no) {
        boolean resp;
        if (no == null) {
            resp = false;
        } else if (no.elemento == x) {
            resp = true;
        } else if (x < no.elemento) {
            resp = pesquisar(x, no.esq);
        } else {
            resp = pesquisar(x, no.dir);
        } 
        return resp;
    }

    void caminharCentral() {
        caminharCentral(raiz);
    }

    void caminharCentral(No no) {
        if (no != null) {
            caminharCentral(no.esq);
            System.out.print(no.elemento + " ");
            caminharCentral(no.dir);
        }
    }

    void caminharPre() {
        caminharPre(raiz);
    }

    void caminharPre(No no) {
        if (no != null) {
            System.out.print(no.elemento + " ");
            caminharPre(no.esq);
            caminharPre(no.dir);
        }
    }

    void caminharPos() {
        caminharPos(raiz);
    }

    void caminharPos(No no) {
        if (no != null) {
            caminharPos(no.esq);
            caminharPos(no.dir);
            System.out.print(no.elemento + " ");
        }
    }

    No rotacionarEsq(No no) {
        No dir = no.dir;
        No dirEsq = dir.esq;

        dir.esq = no;
        no.dir = dirEsq;

        no.setAltura();
        dir.setAltura();

        return dir;
    }

    No rotacionarDir(No no) {
        No esq = no.esq;
        No esqDir = esq.dir;

        esq.dir = no;
        no.esq = esqDir;

        no.setAltura();
        esq.setAltura();

        return esq;
    }

    No balancear(No no) { 
        if (no != null) {
            int fator = No.getAltura(no.dir) - No.getAltura(no.esq);

            if (fator <= 1) {
                no.setAltura();
            } else if (fator == 2) {
                int fatorDir = No.getAltura(no.dir.dir) - No.getAltura(no.dir.esq);
                if (fatorDir == -1) {
                    no.dir = rotacionarDir(no.dir);
                }
                no = rotacionarEsq(no);
            } else if (fator == -2) {
                int fatorEsq = No.getAltura(no.esq.dir) - No.getAltura(no.esq.esq);
                if (fatorEsq == 1) {
                   no.esq = rotacionarEsq(no.esq);
                }
                no = rotacionarDir(no);
            }
        }
        return no;
    }

    No menorDir(No i, No j) { 
		if (j.esq == null) { 
			i.elemento = j.elemento; 
			j = j.dir; 
		
		} else { 
			j.esq = menorDir(i, j.esq);
		}
		return j;
	}

    void inserir(int x) {
        raiz = inserir(x, raiz);
    }

     No inserir(int x, No i) {
        if (i == null) {
            i = new No(x);
        } else if (x < i.getElemento()) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.getElemento()) {
            i.dir = inserir(x, i.dir);
        }
        return balancear(i);
    }

    void remover(int x) throws Exception {
        raiz = remover(x, raiz);
    } 

    No remover(int x, No i) throws Exception {
        if (i == null) {
            throw new Exception("Elemento não existe!");
        } else if (x < i.getElemento()) {
            i.esq = remover(x, i.esq);
        } else if (x > i.getElemento()) {
            i.dir = remover(x, i.dir);
        } else {
            if (i.dir == null) {
                i = i.esq;
            } else if (i.esq == null) {
                i = i.dir;
            } else {
                i.dir = menorDir(i, i.dir);
            }
        }
        return balancear(i);
    }

    public static void main(String[] args) {
		try {
			AVLTree avl = new AVLTree();
			
			int array[] = {1,2,3,4,5,6,7,8,9,10};
			for(int item: array){
				System.out.println("Inserindo -> " + item);
				avl.inserir(item);
				avl.caminharPre();
			}
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
    

