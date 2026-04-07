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

    private long inicio,fim;
    private long[] ResultsExis, ResultsIns;

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
        ResultsExis = new long[Sucesso.length];

        for (int i = 0; i < Sucesso.length; i++) {
            inicio = System.currentTimeMillis();
            ProcuraBinaria(palavras, Sucesso[i]);
            fim = System.currentTimeMillis();

            ResultsExis[i] = fim - inicio;
        }
    }

    public void Inexistente(String[] palavras, String[] Insucesso) {
        ResultsIns = new long[Insucesso.length];

        for (int j = 0; j < Insucesso.length; j++) { //Palavras inexistentes na wordlist
            inicio = System.currentTimeMillis();
            ProcuraBinaria(palavras, Insucesso[j]);
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

