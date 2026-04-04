package Algoritmos;

/*Classe Permutacao.java
* Algoritmo de Ordenação por Permutação
* Neste caso percorre-se o vetor, do último para o primeiro:
    *Comparando elementos consecutivos dois a dois
    * Trocando-os se estiverem na ordem inversa
*Após a primeira iteração o menor valor estará na primeira posição
    * Pelo que as repetições seguintes, deverão ter em conta apenas os restantes
    * elementos e assim sucessivamente
*/

public class Permutacao {

    private long inicio, fim;
    private String[] auxOrdenado;

    public long ordenaPermutacao(String[] oVector) {
        inicio = System.currentTimeMillis();
        auxOrdenado = new String[oVector.length];


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

        for (int l = 0; l < oVector.length; l++) {
            auxOrdenado[l] = oVector[l];
        }
        return fim - inicio;
    }

    public String[] getAuxOrdenado () {
        return auxOrdenado;
    }
}