package Algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ficheiro {

    public static String[] LerFicheiro(String caminho) {

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
            System.out.println("Erro: " + e);
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
