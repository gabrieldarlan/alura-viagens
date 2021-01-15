package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);
        final Pacote pacoteSaoPaulo = new Pacote("São Paulo",
                "sao_paulo_sp",
                2,
                new BigDecimal("243.99"));
        mostraDadosPacoteEmTela(pacoteSaoPaulo);
        final Intent intent = new Intent(this, PagamentoActivity.class);
        startActivity(intent);
    }

    private void mostraDadosPacoteEmTela(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void mostraData(Pacote pacote) {
        final TextView data = findViewById(R.id.resumo_pacote_data);
        final String dataFormtadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormtadaDaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        final TextView preco = findViewById(R.id.resumo_pacote_preco);
        final String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(Pacote pacote) {
        final TextView dias = findViewById(R.id.resumo_pacote_dias);
        final String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        final ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        final Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this,
                pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        final TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}