import Algoritmos.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long inicio,fim,tempo;


        //==========Primeira Bateria de Testes==========
        inicio = System.currentTimeMillis();
 
        //TODO Chama método para contar e armazenar as palavras para o vetor Aux
        String[] palavras = LerFicheiro("palavras.txt");
        String[] Sucesso =  {"arruinai", "capitel", "curso", "eslavo", "gravataria", "longo", "obtenhais", "progenitor", "seria", "vaca"};
        String[] Insucesso = {"algoritmo", "condicional", "direita", "esquerda", "grande", "livros", "prata", "silencio", "verde", "xarões"};

        /*
            MergeSort.MergeSort(palavras);
            PrintVetor(palavras);
        */

        QuickSort.ordenaQuickSort(palavras);
        QuickSort.PrintVetor(palavras);
       
        fim=System.currentTimeMillis();
        tempo=fim-inicio;

        System.out.println("Tempo: " + tempo + "ms");

        //==========Segunda Bateria de Testes==========
        PesquisaLinear.Sucesso(palavras, Sucesso);
        PesquisaLinear.Insucesso(palavras, Insucesso);
    }

    static String[] LerFicheiro(String caminho) {

        File ficheiro=new File(caminho);
        
        Scanner leitor=null;

        try {
            leitor = new Scanner(ficheiro);
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
            System.out.println("Erro: " + e); //DEBUG
        }

        //While ==> Contar as palavras
        int count = 0;
        while(leitor.hasNext()){
            leitor.next();
            count++;
        }

        leitor.close();

        //============================

        String[] palavras = new String[count];

        try {
            leitor = new Scanner(ficheiro);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new String[0];
        }

        //While ==> Colocar as palavras no vetor Aux
        int i = 0;
        while (leitor.hasNext()) {
            palavras[i] = leitor.next();
            i++;
        }

        leitor.close();

        return palavras;
    }
}