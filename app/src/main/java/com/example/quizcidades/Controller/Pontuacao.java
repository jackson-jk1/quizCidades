package com.example.quizcidades.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.quizcidades.R;

public class Pontuacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        Intent it = getIntent();

        TextView pontuacao = findViewById(R.id.output);

        if(it!=null) {
            Bundle params = it.getExtras();
            if (params != null) {
                String points = params.getString("pontos");
                pontuacao.setText(points + " pontos!");
            }
        }
    }

    public void restart(View view){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

}