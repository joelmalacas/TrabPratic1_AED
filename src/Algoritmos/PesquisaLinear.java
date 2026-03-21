package Algoritmos;

import java.util.Objects;

public class PesquisaLinear {

    private static long inicio,fim,tempo;

    public static int ProcuraLinear(String[] v, String palavra) {

        for(int i = 0; i < v.length; i++) {
            if (Objects.equals(v[i], palavra)) {
                return i;
            }
        }
        return -1;
    }

    public static void Sucesso(String[] palavras,String[] Sucesso) {
        for (int i = 0; i < Sucesso.length; i++) { //Palavras existentes na wordlist
            inicio = System.currentTimeMillis();

            int res = PesquisaLinear.ProcuraLinear(palavras, Sucesso[i]);

            if (res == -1 ) {
                fim = System.currentTimeMillis();
                tempo = fim - inicio;

                System.out.println("Tempo de pesquisa: " + tempo + "ms Palavra: " + Sucesso[i] + " | Resultado: Falha");
            } else {
                fim = System.currentTimeMillis();
                tempo = fim - inicio;

                System.out.println("Tempo de pesquisa: " + tempo + "ms Palavra: " + Sucesso[i] + " | Resultado: Sucesso");
            }
        }
    }

    public static void Insucesso(String[] palavras, String[] Insucesso) {
        for (int j = 0; j < Insucesso.length; j++) { //Palavras inexistentes na wordlist
            inicio = System.currentTimeMillis();

            int res = PesquisaLinear.ProcuraLinear(palavras, Insucesso[j]);

            if (res == -1 ) {
                inicio = System.currentTimeMillis();
                tempo = fim - inicio;

                System.out.println("Tempo de pesquisa: " + tempo + "ms Palavra: " + Insucesso[j] + " | Resultado: Falha");
            } else {
                fim = System.currentTimeMillis();
                tempo = fim - inicio;

                System.out.println("Tempo de pesquisa: " + tempo + "ms Palavra: " + Insucesso[j] + " | Resultado: Sucesso");
            }
        }
    }
}