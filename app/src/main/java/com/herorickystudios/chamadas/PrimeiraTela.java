package com.herorickystudios.chamadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrimeiraTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);
    }

    //Botão para a tela de chamadas
    public void BtnACChamadas(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}