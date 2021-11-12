package br.edu.fateczl.appsoi20212t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int numRandom;
    private EditText etNumero;
    private Button btnTentar;
    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = (EditText) findViewById(R.id.etNumero);
        etNumero.setGravity(Gravity.CENTER);
        btnTentar = (Button) findViewById(R.id.btnTentar);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        tvMsg.setGravity(Gravity.CENTER);

        numRandom = (int) ((Math.random() * 100) + 1);

        btnTentar.setOnClickListener(click -> joga());//Lâmbda
    }

    private void joga() {
        int numJogador = Integer.parseInt(etNumero.getText().toString());
        if (numJogador > numRandom) {
            tvMsg.setText(R.string.valor_menor);
        }
        if (numJogador < numRandom) {
            tvMsg.setText(R.string.valor_maior);
        }
        if (numJogador == numRandom) {
            finaliza();
        }
    }

    private void finaliza() {
        Bundle bundle = new Bundle();
        bundle.putInt("numRandom", numRandom);

        Intent intent = new Intent(this, ResActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }
}