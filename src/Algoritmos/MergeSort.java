package Algoritmos;

public class MergeSort {

    public static void MergeSort(String[] v) {
        String[] aux = new String[v.length];
        MergeSortRec(v, aux, 0, v.length - 1);
    }

    private static void MergeSortRec(String[] v, String[] vAux, int esq, int dir) {
        if (esq >= dir) {
            return;
        }

        int centro = (esq + dir) / 2;
        MergeSortRec(v, vAux, esq, centro);
        MergeSortRec(v, vAux, centro + 1, dir);

        Reagrupar(v, vAux, esq, centro + 1, dir);
    }

    private static void Reagrupar(String[] v, String[] vAux, int i1, int i2, int fim2) {
        int fim1 = i2 - 1;
        int inicio = i1;
        int iAux = i1;

        while (i1 <= fim1 && i2 <= fim2) {
            if (v[i1].compareTo(v[i2]) < 0) {
                vAux[iAux] = v[i1];
                i1++;
            } else {
                vAux[iAux] = v[i2];
                i2++;
            }
            iAux++;
        }

        for (; i1 <= fim1; i1++, iAux++)
            vAux[iAux] = v[i1];
        for (; i2 <= fim2; i2++, iAux++)
            vAux[iAux] = v[i2];
        for (int i = inicio; i <= fim2; i++)
            v[i] = vAux[i];
    }

    public static void PrintVetor(String[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println("v[" + i + "]=" + v[i]);
        }
    }
}