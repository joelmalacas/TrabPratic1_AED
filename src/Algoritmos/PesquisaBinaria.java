package Algoritmos;

import java.util.Objects;

/*
    * Classe PesquisaBinaria.java
    * Algoritmo de Pesquisa Binária
    * Na pesquisa binária o vetor é divido em 2 zonas
    * A divisão pode ser feita de qualquer maneira, mas
    * os melhores resultados (em média) obtêm-se quando
    * se divide o vetor (e as zonas seguintes) em duas partes iguais
    * Comparando elemento a procurar (x) com o elemento divisor
    * escolhe-se a próxima zona a dividir:
        *Se x for menor procurar na zona da esquerda
        * Se x for maior procurar na zona da direita
    * E assim sucessivamente até encontrar o valor ou a zona estar vazia
*/

public class PesquisaBinaria {

    private long inicio,fim, inicio2, fim2;
    private long[][] ResultsExis, ResultsIns;

    private void ProcuraBinaria (String[] v, String palavra) {
        boolean encontrou = false;
        int esq = 0, dir = v.length - 1, meio = 0;

        while (esq <= dir && !encontrou) {
            meio = (esq + dir) / 2;

            if (Objects.equals(v[meio], palavra))
                encontrou = true;
            else if (v[meio].compareTo(palavra) < 0)
                esq = meio + 1;
            else
                dir = meio - 1;
        }
    }

    public void Existente(String[] palavras, String[] Sucesso) {
        ResultsExis = new long[Sucesso.length][2];

        for (int i = 0; i < Sucesso.length; i++) {
            inicio = System.currentTimeMillis();
            inicio2 = System.nanoTime();
            ProcuraBinaria(palavras, Sucesso[i]);
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
            ProcuraBinaria(palavras, Insucesso[j]);
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
            result += "v[" + i + "] = " + ResultsExis[i][0] + "ms\n" + "v[" + i + "] = " + ResultsExis[i][1] + " ns\n";
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

