package Algoritmos;

/*
    * Classe QuickSort
    * Algoritmo de Ordenação QuickSort
    * é um algoritmo recursivo
    * é o algoritmo mais rápido de ordenação
    * escolhe primeiramente um valot, também chamado de pivot
    * divide o vetor em duas partes:
        * a primeira parte contém elementos menores que o pivot
        * a segunda parte contém elementos maiores que o pivot
        * o pivot é colocado no meio das duas partes
    * para ordenar as partes daí resultantes aplica-se o mesmo raciocínio
*/

public class QuickSort {

    private long inicio,fim;

    public long ordenaQuickSort(String[] v) {
        inicio = System.currentTimeMillis();

        quickSortRec(v, 0, v.length - 1);

        fim=System.currentTimeMillis();

        return fim-inicio;
    }

    private void quickSortRec(String[] v, int ini, int fim) {
        if (ini >= fim) {
            return;
        }

        String pivot = pivotMediana(v, ini, fim);
        int i = DivideMaiores(v, ini, fim, pivot);

        quickSortRec(v, ini, i - 1);
        quickSortRec(v, i + 1, fim);
    }

    private int DivideMaiores(String[] v, int ini, int fim, String pivot) {
        int i = ini;
        int j = fim - 1;

        while (true) {
            while (v[++i].compareTo(pivot) < 0);
            while (j > 0 && v[--j].compareTo(pivot) > 0);

            if (i < j) {
                troca(v, i, j);
            } else {
                break;
            }
        }

        troca(v, i, fim - 1);
        return i;
    }

    private String pivotMediana(String[] v, int ini, int fim) {
        int centro = (ini + fim) / 2;
        if (v[ini].compareTo(v[centro]) > 0)
            troca(v, ini, centro);
        if (v[ini].compareTo(v[fim]) > 0)
            troca(v, ini, fim);
        if (v[centro].compareTo(v[fim]) > 0)
            troca(v, centro, fim);

        troca(v, centro, fim - 1);
        return v[fim - 1];
    }

    private void troca(String[] v, int i, int j) {
        String aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public void PrintVetor(String[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println("v[" + i + "] = " + v[i]);
        }
    }

}
