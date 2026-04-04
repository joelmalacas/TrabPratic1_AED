package Algoritmos;

/*
    * Algoritmo Ordenação por Inserção,
    * vai colocando cada elemento na sua posição correta
    * considerando-se apenas os que estão à esquerda do elemento atual
    * Ao inserir um elemento os maiores são deslocados para a direita
*/

public class Insercao {

    private long inicio, fim;

    public long ordenaInsercao(String[] oVector) {
        inicio = System.currentTimeMillis();

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
        return fim - inicio;
    }
}