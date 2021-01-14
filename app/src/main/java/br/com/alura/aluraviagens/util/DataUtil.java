package br.com.alura.aluraviagens.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    private static final String DIA_E_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        final Calendar dataIda = Calendar.getInstance();
        final Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        @SuppressLint("SimpleDateFormat") final SimpleDateFormat formatoBrasileiro
                = new SimpleDateFormat(DIA_E_MES);
        final String dataFormtadaIda = formatoBrasileiro.format(dataIda.getTime());
        final String dataFormtadaVolta = formatoBrasileiro.format(dataVolta.getTime());
        return dataFormtadaIda + " - "
                + dataFormtadaVolta + " de "
                + dataVolta.get(Calendar.YEAR);
    }

}
