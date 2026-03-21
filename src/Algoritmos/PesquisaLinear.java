package Algoritmos;

import java.util.Objects;

public class PesquisaLinear {

    public static int ProcuraLinear(String[] v, String palavra) {

        for(int i = 0; i < v.length; i++) {
            if (Objects.equals(v[i], palavra)) {
                return i;
            }
        }
        return -1;
    }
}