package br.edu.fateczl.appsoi20212t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;

public class ResActivity extends AppCompatActivity {

    private Button btnVoltar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        tvResultado.setGravity(Gravity.CENTER);

        receberNum();

        btnVoltar.setOnClickListener(click -> voltar());
    }

    private void receberNum() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int num = bundle.getInt("numRandom");
        tvResultado.setText(getString(R.string.res)+" "+num);
    }

    private void voltar() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}