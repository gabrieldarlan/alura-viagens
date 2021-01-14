package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        final Pacote pacoteSaoPaulo = new Pacote("São Paulo",
                "sao_paulo_sp",
                2,
                new BigDecimal("243.99"));

        final TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSaoPaulo.getLocal());

        final ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        final Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this,
                pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableDoPacote);

        final TextView dias = findViewById(R.id.resumo_pacote_dias);
        final String diasEmTexto = DiasUtil.formataEmTexto(pacoteSaoPaulo.getDias());
        dias.setText(diasEmTexto);

        final TextView preco = findViewById(R.id.resumo_pacote_preco);
        final String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBrasileira);

    }
}