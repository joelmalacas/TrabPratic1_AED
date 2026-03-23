package Algoritmos;

public class Selecao {
    private long inicio, fim;

    public long ordenaSelecao(String[] oVector) {
        inicio = System.currentTimeMillis();

        for (int i = 0; i < oVector.length; i++) {
            String min = oVector[i];
            int minIndex = i;
            for (int j = i + 1; j < oVector.length; j++)
                if (oVector[j].compareTo(min) < 0) {
                    min = oVector[j];
                    minIndex = j;
                }

            String aux = oVector[minIndex];
            oVector[minIndex] = oVector[i];
            oVector[i] = aux;
        }

        fim=System.currentTimeMillis();

        return fim - inicio;
    }
}
