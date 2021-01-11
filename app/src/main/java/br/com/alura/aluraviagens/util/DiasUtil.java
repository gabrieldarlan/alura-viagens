package br.com.alura.aluraviagens.util;

public class DiasUtil {

    private static final String PLURAL = " dias";
    private static final String SINGULAR = " dia";

    public static String formataEmTexto(int quantidadeDias) {
        if (quantidadeDias <= 1) {
            return quantidadeDias + SINGULAR;
        }
        return quantidadeDias + PLURAL;
    }
}
