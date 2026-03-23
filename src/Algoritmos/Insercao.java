package Algoritmos;

public class Insercao {

    private long inicio, fim;

    public long ordenaInsercao(String[] oVector) {
        inicio = System.currentTimeMillis();

        for (int i = 1; i < oVector.length; i++) {
            String x = oVector[i];          // ← int para String
            int j = i;
            while (j > 0 && oVector[j - 1].compareTo(x) > 0) {  // ← > para .compareTo() > 0
                oVector[j] = oVector[j - 1];
                j--;
            }
            oVector[j] = x;
        }

        fim = System.currentTimeMillis();
        return fim - inicio;
    }
}