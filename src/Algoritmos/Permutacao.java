package Algoritmos;

public class Permutacao {

    private long inicio, fim;

    public long ordenaPermutacao(String[] oVector) {
        inicio = System.currentTimeMillis();

        boolean ordenado = false;
        int i = 0;
        while (i < oVector.length - 1 && !ordenado) {
            ordenado = true;
            for (int j = oVector.length - 1; j > i; j--) {
                if (oVector[j - 1].compareTo(oVector[j]) > 0) {
                    String aux = oVector[j - 1];
                    oVector[j - 1] = oVector[j];
                    oVector[j] = aux;
                    ordenado = false;
                }
            }
            i++;
        }

        fim=System.currentTimeMillis();

        return fim - inicio;
    }
}