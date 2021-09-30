package com.herorickystudios.chamadas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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
    private DatabaseReference referencia2 = FirebaseDatabase.getInstance().getReference("Aluno2");
    private DatabaseReference referencia3 = FirebaseDatabase.getInstance().getReference("Aluno3");
    private FirebaseDatabase database;
    private ValueEventListener valueEventListener;
    private EditText presencas,faltas;
    private TextView nome;
    private Button buttonPresenca,buttonFalta;
    private TextView textAluno2;
    private EditText textPresenca2, textFaltas2;
    private TextView textAluno3;
    private EditText textPresenca3, textFaltas3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ALUNO1
        nome = findViewById(R.id.textAluno);
        presencas = findViewById(R.id.textPresenca);
        faltas = findViewById(R.id.textFaltas);
        buttonPresenca = findViewById(R.id.buttonPresenca);
        buttonFalta = findViewById(R.id.buttonFalta);

        //ALUNO 2
        textAluno2 = findViewById(R.id.textAluno2);
        textPresenca2 = findViewById(R.id.textPresenca2);
        textFaltas2 = findViewById(R.id.textFaltas2);

        //ALUNO3
        textAluno3 = findViewById(R.id.textAluno3);
        textPresenca3 = findViewById(R.id.textPresenca3);
        textFaltas3 = findViewById(R.id.textFaltas3);

            //db
        database = FirebaseDatabase.getInstance();


        //ouvintes
        ouvinte_1();
        ouvinte_2();
        ouvinte_3();

    }

    @Override
    protected void onStart() {
        super.onStart();


    }


    //Ouvinte do Aluno 1
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

        if(resultadof1 > 9){

            nome.setTextColor(Color.parseColor("#808000"));

        }if(resultadof1 > 12){

            nome.setTextColor(Color.parseColor("#FF0000"));
        }
    }


    //Ouvinte do Aluno 2
    private void ouvinte_2(){
        DatabaseReference reference = database.getReference().child("Aluno2");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String p1 = snapshot.child("Presenca").getValue().toString();
                String f1 = snapshot.child("Faltas").getValue().toString();

                textAluno2.setText(name);
                textPresenca2.setText(p1);
                textFaltas2.setText(f1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });

    }
    public void Btnpresenca2(View view){

        textPresenca2.getText();

        Integer campoA = Integer.parseInt(textPresenca2.getText().toString());
        Integer campoB = Integer.valueOf(1);

        int resultado2 = campoA + campoB;

        textPresenca2.setText(String.valueOf(resultado2));


        referencia2.child("Presenca").setValue(resultado2);


    }

    public void faltasbtn2(View view){

        textFaltas2.getText();
        Integer campoAf = Integer.parseInt(textFaltas2.getText().toString());
        Integer campoBf = Integer.valueOf(1);

        int resultadof2 = campoAf + campoBf;

        textFaltas2.setText(String.valueOf(resultadof2));

        referencia2.child("Faltas").setValue(resultadof2);

        if(resultadof2 > 9){

            textAluno2.setTextColor(Color.parseColor("#808000"));

        }if(resultadof2 > 12){

            textAluno2.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    //Ouvinte do Aluno 3
    private void ouvinte_3(){
        DatabaseReference reference = database.getReference().child("Aluno3");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String p3 = snapshot.child("Presenca").getValue().toString();
                String f3 = snapshot.child("Faltas").getValue().toString();

                textAluno3.setText(name);
                textPresenca3.setText(p3);
                textFaltas3.setText(f3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });

    }
    public void Btnpresenca3(View view){

        textPresenca3.getText();

        Integer campoA = Integer.parseInt(textPresenca3.getText().toString());
        Integer campoB = Integer.valueOf(1);

        int resultado2 = campoA + campoB;

        textPresenca3.setText(String.valueOf(resultado2));


        referencia3.child("Presenca").setValue(resultado2);

    }
    public void faltasbtn3(View view){

        textFaltas3.getText();
        Integer campoAf = Integer.parseInt(textFaltas3.getText().toString());
        Integer campoBf = Integer.valueOf(1);

        int resultadof3 = campoAf + campoBf;

        textFaltas3.setText(String.valueOf(resultadof3));

        referencia3.child("Faltas").setValue(resultadof3);

        if(resultadof3 > 9){

            textAluno3.setTextColor(Color.parseColor("#808000"));

        }if(resultadof3 > 12){

            textAluno3.setTextColor(Color.parseColor("#FF0000"));
        }
    }



}
