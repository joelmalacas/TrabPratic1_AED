import Algoritmos.*;

/*
    * Classe Principal Main.java
    * Onde vai ser executado as 3 Baterias de testes com as respetivas classes
    * e mostradas as respetivas saídas
*/

public class Main {
    public static void main(String[] args) {
        //Constante do caminho do ficheiro .txt
        final String caminhoFicheiro = "palavras.txt";

        //Instâncias
        Selecao selecao = new Selecao();
        Insercao insercao = new Insercao();
        Permutacao permutacao = new Permutacao();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        PesquisaLinear pesquisaLinear = new PesquisaLinear();
        PesquisaBinaria pesquisaBinaria = new PesquisaBinaria();

        String[] palavras = Ficheiro.LerFicheiro(caminhoFicheiro);

        //==========Primeira Bateria de Testes==========
        long[] resultMerge = mergeSort.MergeSort(palavras.clone());
        long[] resultQuick = quickSort.ordenaQuickSort(palavras.clone());
        long[] resultSelecao = selecao.ordenaSelecao(palavras.clone());
        long[] resultInsercao = insercao.ordenaInsercao(palavras.clone());
        long[] resultPermutacao = permutacao.ordenaPermutacao(palavras.clone());

        //==========Segunda Bateria de Testes==========
        String[] Sucesso =  {"arruinai", "capitel", "curso", "eslavo", "gravataria", "longo", "obtenhais", "progenitor", "seria", "vaca"};
        String[] Insucesso = {"algoritmo", "condicional", "direita", "esquerda", "grande", "livros", "prata", "silencio", "verde", "xarões"};

        pesquisaLinear.Existente(palavras.clone(), Sucesso);
        pesquisaLinear.Inexistente(palavras.clone(), Insucesso);

        String linearSucesso2 = pesquisaLinear.PrintSucesso();
        String linearInsucesso2 = pesquisaLinear.PrintInsucesso();

        //==========Terceira Bateria de Testes==========
        String[] palavrasOrdenado = permutacao.getAuxOrdenado();

        pesquisaLinear.Existente(palavrasOrdenado,Sucesso);
        pesquisaLinear.Inexistente(palavrasOrdenado,Insucesso);

        String linearSucesso3 = pesquisaLinear.PrintSucesso();
        String linearInsucesso3 = pesquisaLinear.PrintInsucesso();

        pesquisaBinaria.Existente(palavrasOrdenado, Sucesso);
        pesquisaBinaria.Inexistente(palavrasOrdenado, Insucesso);

        String binariaSucesso3 = pesquisaBinaria.PrintSucesso();
        String binariaInsucesso3 = pesquisaBinaria.PrintInsucesso();

        //==========Output's==========
        System.out.println("Tempo de ordenação Seleção: " + resultSelecao[0] + "ms");
        System.out.println("Tempo de ordenação Seleção: " + resultSelecao[1] + "ns");
        System.out.println("Tempo de ordenação Inserção: " + resultInsercao[0] + "ms");
        System.out.println("Tempo de ordenação Inserção: " + resultInsercao[1] + "ns");
        System.out.println("Tempo de ordenação Permutação: " + resultPermutacao[0] + "ms");
        System.out.println("Tempo de ordenação Permutação: " + resultPermutacao[1] + "ns");
        System.out.println("Tempo de ordenação MergeSort: " + resultMerge[0] + "ms");
        System.out.println("Tempo de ordenação MergeSort: " + resultMerge[1] + "ns");
        System.out.println("Tempo de ordenação QuickSort:" + resultQuick[0] + "ms");
        System.out.println("Tempo de ordenação QuickSort:" + resultQuick[1] + "ns \n\n");

        System.out.println("==========Pesquisa Linear==========");
        System.out.println("==========Sucesso==========\n" + linearSucesso2);
        System.out.println("==========Insucesso==========\n" + linearInsucesso2);

        System.out.println("==========Vetor Ordenado==========");
        System.out.println("==========Pesquisa Linear==========");
        System.out.println("=============Sucesso==========\n" + linearSucesso3);
        System.out.println("==========Insucesso==========\n" + linearInsucesso3);
        System.out.println("\n==========Pesquisa Binária==========");
        System.out.println("=============Sucesso==========\n" + binariaSucesso3);
        System.out.println("==========Insucesso==========\n" + binariaInsucesso3);
    }
}