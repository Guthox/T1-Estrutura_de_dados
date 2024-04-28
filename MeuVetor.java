import java.util.Random;

public class MeuVetor {
    private double[] v;
    private int ultimaPos;

    public MeuVetor (int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }
    //métodos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }
    public double[] getV() {
        return v;
    }
    //métodos modificadores
    public void setUltimaPosicao(int pos) {
        if (pos >= 0 && pos < v.length) {
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length - 1;
        }
    }

    public boolean estaCheio () {
        return ultimaPos == v.length-1;
    }

    public boolean estaVazio () {
        return ultimaPos == -1;
    }

    public void resetVetor() {
        ultimaPos = -1;
    }

    public void adiciona(int elemento) {
        if (estaCheio()) {
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = elemento;
    }
    public void adiciona (double elemento) {
        if (estaCheio())
            redimensiona(v.length*2);
        v[++ultimaPos] = elemento;
    }
    public void adiciona (double elemento, int posicao) {
        if (estaCheio())
            redimensiona(v.length*2);
        if (posicao > ultimaPos)
            v[++ultimaPos] = elemento;
        else {
            //deslocar elementos
            int i;
            for (i=ultimaPos+1; i>posicao; i--)
                v[i] = v[i-1];
            v[i] = elemento;
            ultimaPos++;
        }
    }
    public double remove() {
        if (estaVazio()) return 0;
        double aux = v[ultimaPos--];
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return aux;
    }
    public double remove(int posicao) {
        if (estaVazio() || posicao > ultimaPos) return 0;
        double aux = v[posicao];
        for (int i = posicao; i<ultimaPos; i++)
            v[i] = v[i+1];
        ultimaPos--;
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return aux;
    }
    public int remove (double elemento) {
        if (estaVazio()) return 0;
        int cont = 0;
        for (int i=ultimaPos; i>=0; i--) {
            if (v[i] == elemento) {
                //arrasta
                for (int j=i; j<ultimaPos; j++)
                    v[j] = v[j+1];
                ultimaPos--;
                cont++;
            }
        }
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return cont;
    }
    private void redimensiona(int novaCapacidade) {
        double[] temp = new double[novaCapacidade];
        for (int i = 0; i <= ultimaPos; i++) {
            temp[i] = v[i];
        }
        v = temp;
    }

    @Override
    public String toString() {
        String s = "";
        if (estaVazio()) {
            s = s + "vetor vazio";
        }
        else {
            for (int i=0; i <= ultimaPos; i++) {
                s = s + String.format("%.0f ", v[i]);
            }
        }
        s = s + "\n";
        return s;
    }

    public void preencheVetor () {
        Random r = new Random();
        for (int i=0; i<v.length; i++) {
            adiciona(r.nextInt(v.length*10)+1);
        }
    }
    public void preencheVetor (int limite) {
        Random r = new Random();
        for (int i=0; i<v.length; i++) {
            adiciona(r.nextInt(limite));
        }
    }
    public int bubbleSort () {
        int cont = 0;
        for (int i=1; i<v.length; i++) {
            for (int j=0; j<v.length-i; j++) {
                cont++;
                if (v[j] > v[j+1]) {
                    double aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
        return cont;
    }
    
    public void selectionSort (){
        for (int i = 0; i < v.length - 1; ++i) {
            int min = i;
            for (int j = i+1; j < v.length; ++j){
                if (v[j] < v[min]) {
                    min = j;
                }
            }
            double x = v[i];
            v[i] = v[min];
            v[min] = x;
        }
    }

    public void insertionSort (){
       for (int j = 1; j < v.length; ++j) {
          double x = v[j];
          int i;
          for (i = j-1; i >= 0 && v[i] > x; --i)
          {
            v[i+1] = v[i];
          }
          v[i+1] = x;
       }
    }

}
















