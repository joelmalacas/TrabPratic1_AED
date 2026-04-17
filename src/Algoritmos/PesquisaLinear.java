package Algoritmos;

/*
    * Classe PesquisaLinear
    * Algoritmo de Pesquisa Linear
    * Nesta procura o vetor é percorrido, elemento a elemento,
    * desde o primeiro até ao último
    * Termina-se a procura quando ocorre uma de duas situações:
        *O elemento é encontrado
        *todo o vetor foi pesquisado e não se encontrou o elemento
*/

import java.util.Objects;

public class PesquisaLinear {

    private long inicio,fim, inicio2, fim2;
    private long[][] ResultsExis, ResultsIns;

    private void ProcuraLinear(String[] v, String palavra) {
        for(int i = 0; i < v.length; i++) {
            if (Objects.equals(v[i], palavra)) {
                return;
            }
        }
    }

    public void Existente(String[] palavras, String[] Sucesso) {
        ResultsExis = new long[Sucesso.length][2];

        for (int i = 0; i < Sucesso.length; i++) {
            inicio = System.currentTimeMillis();
            inicio2 = System.nanoTime();
            ProcuraLinear(palavras, Sucesso[i]);
            fim = System.currentTimeMillis();
            fim2 = System.nanoTime();

            long millis = fim - inicio;
            long nanos = fim2 - inicio2;


            ResultsExis[i][0] = millis;
            ResultsExis[i][1] = nanos;
        }
    }

    public void Inexistente(String[] palavras, String[] Insucesso) {
        ResultsIns = new long[Insucesso.length][2];

        for (int j = 0; j < Insucesso.length; j++) { //Palavras inexistentes na wordlist
            inicio = System.currentTimeMillis();
            inicio2 = System.nanoTime();
            ProcuraLinear(palavras, Insucesso[j]);
            fim = System.currentTimeMillis();
            fim2 = System.nanoTime();

            long millis = fim - inicio;
            long nanos = fim2 - inicio2;


            ResultsIns[j][0] = millis;
            ResultsIns[j][1] = nanos;
        }
    }

    public String PrintSucesso() {
        String result = "";
        for (int i = 0; i < ResultsExis.length; i++) {
            result += "v[" + i + "] = " + ResultsExis[i][0] + "ms\n" + "v[" + i + "] = " + ResultsExis[i][1] + "ns\n";
        }
        return result;
    }

    public String PrintInsucesso() {
        String result = "";
        for (int j = 0; j < ResultsIns.length; j++) {
            result += "v[" + j + "] = " + ResultsIns[j][0] + "ms\n" + "v[" + j + "] = " + ResultsIns[j][1] + "ns\n";
        }
        return result;
    }
}