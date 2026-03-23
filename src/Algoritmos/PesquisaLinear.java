package Algoritmos;

import java.util.Objects;

public class PesquisaLinear {

    private long inicio,fim;
    private long ResultsExis[], ResultsIns[];

    private void ProcuraLinear(String[] v, String palavra) {
        for(int i = 0; i < v.length; i++) {
            if (Objects.equals(v[i], palavra)) {
                return;
            }
        }
    }

    public void Existente(String[] palavras, String[] Sucesso) {
        ResultsExis = new long[Sucesso.length];

        for (int i = 0; i < Sucesso.length; i++) {
            inicio = System.currentTimeMillis();
            ProcuraLinear(palavras, Sucesso[i]);
            fim = System.currentTimeMillis();

            ResultsExis[i] = fim - inicio;
        }
    }

    public void Inexistente(String[] palavras, String[] Insucesso) {
        ResultsIns = new long[Insucesso.length];

        for (int j = 0; j < Insucesso.length; j++) { //Palavras inexistentes na wordlist
            inicio = System.currentTimeMillis();
            ProcuraLinear(palavras, Insucesso[j]);
            fim = System.currentTimeMillis();

            ResultsIns[j] = fim - inicio;
        }
    }

    public String PrintSucesso() {
        String result = "";
        for (int i = 0; i < ResultsExis.length; i++) {
            result += "v[" + i + "] = " + ResultsExis[i] + "ms\n";
        }
        return result;
    }

    public String PrintInsucesso() {
        String result = "";
        for (int j = 0; j < ResultsIns.length; j++) {
            result += "v[" + j + "] = " + ResultsIns[j] + "ms\n";
        }
        return result;
    }
}