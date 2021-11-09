package com.herorickystudios.chamadas;
//PROGRAMADO POR  HERORICKY_GAMES!
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

                Aluno.setText(name);
                primeirobimestre.setText(primeirob);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });
    }

}