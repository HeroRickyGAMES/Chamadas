package com.herorickystudios.chamadas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("Aluno1");
    private FirebaseDatabase database;
    private ValueEventListener valueEventListener;
    private EditText presencas,faltas;
    private TextView nome;
    private Button buttonPresenca,buttonFalta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //aluno1
        nome = findViewById(R.id.textAluno2);
        presencas = findViewById(R.id.textPresenca);
        faltas = findViewById(R.id.textFaltas);
        buttonPresenca = findViewById(R.id.buttonPresenca);
        buttonFalta = findViewById(R.id.buttonFalta);

        database = FirebaseDatabase.getInstance();

        ouvinte_1();

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    private void ouvinte_1(){
        DatabaseReference reference = database.getReference().child("Aluno1");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String p = snapshot.child("Presenca").getValue().toString();
                String f = snapshot.child("Faltas").getValue().toString();

                nome.setText(name);
                faltas.setText(f);
                presencas.setText(p);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });

    }
    public void Btnpresenca1(View view){

        presencas.getText();

        Integer campoA = Integer.parseInt(presencas.getText().toString());
        Integer campoB = Integer.valueOf(1);

        int resultado = campoA + campoB;

        presencas.setText(String.valueOf(resultado));


        referencia.child("Presenca").setValue(resultado);


    }

    public void faltasbtn1(View view){

        faltas.getText();
        Integer campoAf = Integer.parseInt(faltas.getText().toString());
        Integer campoBf = Integer.valueOf(1);

        int resultadof1 = campoAf + campoBf;

        faltas.setText(String.valueOf(resultadof1));

        referencia.child("Faltas").setValue(resultadof1);
    }


}
