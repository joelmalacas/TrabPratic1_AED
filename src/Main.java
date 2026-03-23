import Algoritmos.*;

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

        //TODO Chama método para contar e armazenar as palavras para o vetor Aux
        String[] palavras = Ficheiro.LerFicheiro(caminhoFicheiro);

        //==========Primeira Bateria de Testes==========
        long resultMerge = mergeSort.MergeSort(palavras);
        long resultQuick = quickSort.ordenaQuickSort(palavras);
        long resultSelecao = selecao.ordenaSelecao(palavras);
        long resultInsercao = insercao.ordenaInsercao(palavras);
        long resultPermutacao = permutacao.ordenaPermutacao(palavras);

        //==========Segunda Bateria de Testes==========
        String[] Sucesso =  {"arruinai", "capitel", "curso", "eslavo", "gravataria", "longo", "obtenhais", "progenitor", "seria", "vaca"};
        String[] Insucesso = {"algoritmo", "condicional", "direita", "esquerda", "grande", "livros", "prata", "silencio", "verde", "xarões"};

        pesquisaLinear.Existente(palavras, Sucesso);
        pesquisaLinear.Inexistente(palavras, Insucesso);

        //==========Terceira Bateria de Testes==========
        //TODO

        //==========Output's==========
        System.out.println("Tempo de ordenação Seleção: " + resultSelecao + "ms");
        System.out.println("Tempo de ordenação Inserção: " + resultInsercao + "ms");
        System.out.println("Tempo de ordenação Permutação: " + resultPermutacao + "ms");
        System.out.println("Tempo de ordenação MergeSort: " + resultMerge + "ms");
        System.out.println("Tempo de ordenação QuickSort: " + resultQuick + "ms");
        System.out.println("==========Sucesso==========\n" + pesquisaLinear.PrintSucesso());
        System.out.println("==========Insucesso==========\n" + pesquisaLinear.PrintInsucesso());
    }
}