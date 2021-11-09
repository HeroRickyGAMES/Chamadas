package com.herorickystudios.chamadas;
//PROGRAMADO POR  HERORICKY_GAMES!
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Notas extends AppCompatActivity {

    //Referencia para o DB
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("Aluno1");

    //Data base
    private FirebaseDatabase database;


    private EditText primeirobimestre;
    private EditText segundobimestre;
    private EditText terceirobimestre;
    private EditText quartobimestre;
    private TextView Aluno;
    private TextView Notafinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        primeirobimestre = findViewById(R.id.Nota1B);
        segundobimestre = findViewById(R.id.Nota2B);
        terceirobimestre = findViewById(R.id.Nota3B);
        quartobimestre = findViewById(R.id.Nota4B);
        Aluno = findViewById(R.id.Aluno);
        Notafinal = findViewById(R.id.Notafinal);

        //db
        database = FirebaseDatabase.getInstance();

        //ouvintes
        ouvinte_1();
    }
    private void ouvinte_1(){
        DatabaseReference reference = database.getReference().child("Aluno1");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String primeirob = snapshot.child("Nota 1B").getValue().toString();
                String segundob = snapshot.child("Nota2B").getValue().toString();
                String terceirob = snapshot.child("Nota3B").getValue().toString();
                String quartob = snapshot.child("Nota4B").getValue().toString();

                Aluno.setText(name);
                primeirobimestre.setText(primeirob);
                segundobimestre.setText(segundob);
                terceirobimestre.setText(terceirob);
                quartobimestre.setText(quartob);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });
    }

    public void adçãodoaluno1(View view){
        primeirobimestre.getText();
        segundobimestre.getText();
        terceirobimestre.getText();
        quartobimestre.getText();

        Integer campoA = Integer.parseInt(primeirobimestre.getText().toString());
        Integer campoB = Integer.parseInt(segundobimestre.getText().toString());
        Integer campoC = Integer.parseInt(terceirobimestre.getText().toString());
        Integer campoD = Integer.parseInt(quartobimestre.getText().toString());
        //Integer campoB = Integer.valueOf(1);

        int primeirobim = campoA;
        int segundobim = campoB;
        int terceirobim = campoC;
        int quartobim = campoD;
        int numero = 4;

        int resultado = primeirobim + segundobim + terceirobim + quartobim;
        int resultado2 = resultado / numero;

        primeirobimestre.setText(String.valueOf(primeirobim));
        segundobimestre.setText(String.valueOf(segundobim));
        terceirobimestre.setText(String.valueOf(terceirobim));
        quartobimestre.setText(String.valueOf(quartobim));

        Notafinal.setText(String.valueOf(resultado2));



        referencia.child("NotaFinal").setValue(resultado2);
        referencia.child("Nota 1B").setValue(primeirobim);
        referencia.child("Nota2B").setValue(segundobim);
        referencia.child("Nota3B").setValue(terceirobim);
        referencia.child("Nota4B").setValue(quartobim);
    }

}