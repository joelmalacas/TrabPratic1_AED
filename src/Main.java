import Algoritmos.*;

public class Main {
    public static void main(String[] args) {
        //Instância
        PesquisaLinear PesquisaLinear = new PesquisaLinear();
        MergeSort MergeSort = new MergeSort();
        QuickSort QuickSort = new QuickSort();

        //==========Primeira Bateria de Testes==========
        //TODO Chama método para contar e armazenar as palavras para o vetor Aux
        String[] palavras = Ficheiro.LerFicheiro("palavras.txt");

        String[] Sucesso =  {"arruinai", "capitel", "curso", "eslavo", "gravataria", "longo", "obtenhais", "progenitor", "seria", "vaca"};
        String[] Insucesso = {"algoritmo", "condicional", "direita", "esquerda", "grande", "livros", "prata", "silencio", "verde", "xarões"};

        long resultMerge = MergeSort.MergeSort(palavras);
        long resultQuick = QuickSort.ordenaQuickSort(palavras);

        //==========Segunda Bateria de Testes==========
        PesquisaLinear.Existente(palavras, Sucesso);
        PesquisaLinear.Inexistente(palavras, Insucesso);

        //==========Output's==========
        System.out.println("Tempo de ordenação MergeSort: " + resultMerge + "ms");
        System.out.println("Tempo de ordenação QuickSort: " + resultQuick + "ms");
        System.out.println("==========Sucesso==========\n" + PesquisaLinear.PrintSucesso());
        System.out.println("==========Insucesso==========\n" + PesquisaLinear.PrintInsucesso());
    }
}