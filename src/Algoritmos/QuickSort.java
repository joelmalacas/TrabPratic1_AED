package Algoritmos;

public class QuickSort {

    private long inicio,fim,tempo;

    public long ordenaQuickSort(String[] v) {
        inicio = System.currentTimeMillis();

        quickSortRec(v, 0, v.length - 1);

        fim=System.currentTimeMillis();
        tempo=fim-inicio;

        return tempo;
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
