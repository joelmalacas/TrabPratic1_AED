package Algoritmos;

/*
    * Algoritmo Ordenação por Inserção,
    * vai colocando cada elemento na sua posição correta
    * considerando-se apenas os que estão à esquerda do elemento atual
    * Ao inserir um elemento os maiores são deslocados para a direita
*/

public class Insercao {

    private long inicio, fim, inicio2, fim2;

    public long[] ordenaInsercao(String[] oVector) {
        inicio = System.currentTimeMillis();
        inicio2 = System.nanoTime();

        for (int i = 1; i < oVector.length; i++) {
            String x = oVector[i];
            int j = i;
            while (j > 0 && oVector[j - 1].compareTo(x) > 0) {
                oVector[j] = oVector[j - 1];
                j--;
            }
            oVector[j] = x;
        }

        fim = System.currentTimeMillis();
        fim2 = System.nanoTime();

        long millis = fim - inicio;
        long nanos = fim2 - inicio2;

        return new long[] {millis, nanos};
    }
}