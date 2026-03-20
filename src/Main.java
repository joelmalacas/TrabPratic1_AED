import Algoritmos.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Algoritmos.MergeSort.PrintVetor;

public class Main {
    public static void main(String[] args) {
        long inicio,fim,tempo;

        inicio = System.currentTimeMillis();
 
        //TODO Chama método para contar e armazenar as palavras para o vetor Aux
        String[] palavras = LerFicheiro("palavras.txt");

        MergeSort.MergeSort(palavras);

        PrintVetor(palavras);
       
        fim=System.currentTimeMillis();
        tempo=fim-inicio;

        System.out.println("Tempo: " + tempo + "ms");
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