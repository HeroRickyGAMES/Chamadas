package com.herorickystudios.chamadas;

//PROGRAMADO POR  HERORICKY_GAMES!

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

    //Referencias para a adição e subtração do Codigo lá no database
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("Aluno1");
    private DatabaseReference referencia2 = FirebaseDatabase.getInstance().getReference("Aluno2");
    private DatabaseReference referencia3 = FirebaseDatabase.getInstance().getReference("Aluno3");
    private DatabaseReference referencia4 = FirebaseDatabase.getInstance().getReference("Aluno4");
    private DatabaseReference referencia5 = FirebaseDatabase.getInstance().getReference("Aluno5");
    private DatabaseReference referencia6 = FirebaseDatabase.getInstance().getReference("Aluno6");
    private DatabaseReference referencia7 = FirebaseDatabase.getInstance().getReference("Aluno7");
    private DatabaseReference referencia8 = FirebaseDatabase.getInstance().getReference("Aluno8");
    private DatabaseReference referencia9 = FirebaseDatabase.getInstance().getReference("Aluno9");

    //Data base
    private FirebaseDatabase database;
    private ValueEventListener valueEventListener;

    //Primeiro Aluno
    private EditText presencas,faltas;
    private TextView nome;

    //Botões não usados
    private Button buttonPresenca,buttonFalta;

    //Referencias da Interface com o Codigo para retornar no db e na tela
    private TextView textAluno2, textAluno3, textAluno4, textAluno5, textAluno6, textAluno7, textAluno8, textAluno9;
    private EditText textPresenca2, textFaltas2, textPresenca3, textFaltas3, textPresenca5, textFaltas4, textPresenca4, textFaltas5, textPresenca6, textFaltas6,
            textPresenca7, textFaltas7, textPresenca8, textFaltas8, textPresenca9, textFaltas9;

    //OnCreate
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

        //ALUNO4
        textAluno4 = findViewById(R.id.textAluno4);
        textPresenca5 = findViewById(R.id.textPresenca5);
        textFaltas4 = findViewById(R.id.textFaltas4);

        //ALUNO5
        textAluno5 = findViewById(R.id.textAluno5);
        textPresenca4 = findViewById(R.id.textPresenca4);
        textFaltas5 = findViewById(R.id.textFaltas5);

        //ALUNO6
        textAluno6 = findViewById(R.id.textAluno6);
        textPresenca6 = findViewById(R.id.textPresenca6);
        textFaltas6 = findViewById(R.id.textFaltas6);

        //ALUNO7
        textAluno7 = findViewById(R.id.textAluno7);
        textPresenca7 = findViewById(R.id.textPresenca7);
        textFaltas7 = findViewById(R.id.textFaltas7);

        //ALUNO8
        textAluno8 = findViewById(R.id.textAluno8);
        textPresenca8 = findViewById(R.id.textPresenca8);
        textFaltas8 = findViewById(R.id.textFaltas8);

        //ALUNO9
        textAluno9 = findViewById(R.id.textAluno9);
        textPresenca9 = findViewById(R.id.textPresenca9);
        textFaltas9 = findViewById(R.id.textFaltas9);

            //db
        database = FirebaseDatabase.getInstance();


        //ouvintes
        ouvinte_1();
        ouvinte_2();
        ouvinte_3();
        ouvinte_4();
        ouvinte_5();
        ouvinte_6();
        ouvinte_7();
        ouvinte_8();
        ouvinte_9();

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

        if(resultadof1 > 7){

            nome.setTextColor(Color.parseColor("#808000"));

        }if(resultadof1 > 11){

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

        if(resultadof2 > 7){

            textAluno2.setTextColor(Color.parseColor("#808000"));

        }if(resultadof2 > 11){

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

        if(resultadof3 > 7){

            textAluno3.setTextColor(Color.parseColor("#808000"));

        }if(resultadof3 > 11){

            textAluno3.setTextColor(Color.parseColor("#FF0000"));
        }
    }
    //Ouvinte do Aluno 4
    private void ouvinte_4(){
        DatabaseReference reference = database.getReference().child("Aluno4");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String p4 = snapshot.child("Presenca").getValue().toString();
                String f4 = snapshot.child("Faltas").getValue().toString();

                textAluno4.setText(name);
                textPresenca5.setText(p4);
                textFaltas4.setText(f4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });

    }
    public void Btnpresenca4(View view){

        textPresenca5.getText();

        Integer campoA = Integer.parseInt(textPresenca5.getText().toString());
        Integer campoB = Integer.valueOf(1);

        int resultado2 = campoA + campoB;

        textPresenca5.setText(String.valueOf(resultado2));


        referencia4.child("Presenca").setValue(resultado2);

    }

    public void faltasbtn4(View view){

        textFaltas4.getText();
        Integer campoAf = Integer.parseInt(textFaltas4.getText().toString());
        Integer campoBf = Integer.valueOf(1);

        int resultadof3 = campoAf + campoBf;

        textFaltas4.setText(String.valueOf(resultadof3));

        referencia4.child("Faltas").setValue(resultadof3);

        if(resultadof3 > 7){

            textAluno4.setTextColor(Color.parseColor("#808000"));

        }if(resultadof3 > 11){

            textAluno4.setTextColor(Color.parseColor("#FF0000"));
        }
    }
    //Ouvinte do Aluno 5
    private void ouvinte_5(){
        DatabaseReference reference = database.getReference().child("Aluno5");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String p4 = snapshot.child("Presenca").getValue().toString();
                String f4 = snapshot.child("Faltas").getValue().toString();

                textAluno5.setText(name);
                textPresenca4.setText(p4);
                textFaltas5.setText(f4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });

    }
    public void Btnpresenca5(View view){

        textPresenca4.getText();

        Integer campoA = Integer.parseInt(textPresenca4.getText().toString());
        Integer campoB = Integer.valueOf(1);

        int resultado2 = campoA + campoB;

        textPresenca4.setText(String.valueOf(resultado2));


        referencia5.child("Presenca").setValue(resultado2);

    }

    public void faltasbtn5(View view){

        textFaltas5.getText();
        Integer campoAf = Integer.parseInt(textFaltas5.getText().toString());
        Integer campoBf = Integer.valueOf(1);

        int resultadof3 = campoAf + campoBf;

        textFaltas5.setText(String.valueOf(resultadof3));

        referencia5.child("Faltas").setValue(resultadof3);

        if(resultadof3 > 7){

            textAluno5.setTextColor(Color.parseColor("#808000"));

        }if(resultadof3 > 11){

            textAluno5.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    //Ouvinte do Aluno 6
    private void ouvinte_6(){
        DatabaseReference reference = database.getReference().child("Aluno6");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String p4 = snapshot.child("Presenca").getValue().toString();
                String f4 = snapshot.child("Faltas").getValue().toString();

                textAluno6.setText(name);
                textPresenca6.setText(p4);
                textFaltas6.setText(f4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });

    }

    public void Btnpresenca6(View view){

        textPresenca6.getText();

        Integer campoA = Integer.parseInt(textPresenca6.getText().toString());
        Integer campoB = Integer.valueOf(1);

        int resultado2 = campoA + campoB;

        textPresenca6.setText(String.valueOf(resultado2));


        referencia6.child("Presenca").setValue(resultado2);

    }

    public void faltasbtn6(View view){

        textFaltas6.getText();
        Integer campoAf = Integer.parseInt(textFaltas6.getText().toString());
        Integer campoBf = Integer.valueOf(1);

        int resultadof3 = campoAf + campoBf;

        textFaltas6.setText(String.valueOf(resultadof3));

        referencia6.child("Faltas").setValue(resultadof3);

        if(resultadof3 > 7){

            textAluno6.setTextColor(Color.parseColor("#808000"));

        }if(resultadof3 > 11){

            textAluno6.setTextColor(Color.parseColor("#FF0000"));
        }
    }
    //Ouvinte do Aluno 7
    private void ouvinte_7(){
        DatabaseReference reference = database.getReference().child("Aluno7");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String p4 = snapshot.child("Presenca").getValue().toString();
                String f4 = snapshot.child("Faltas").getValue().toString();

                textAluno7.setText(name);
                textPresenca7.setText(p4);
                textFaltas7.setText(f4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });

    }
    public void Btnpresenca7(View view){

        textPresenca7.getText();

        Integer campoA = Integer.parseInt(textPresenca7.getText().toString());
        Integer campoB = Integer.valueOf(1);

        int resultado2 = campoA + campoB;

        textAluno7.setText(String.valueOf(resultado2));


        referencia7.child("Presenca").setValue(resultado2);

    }
    public void faltasbtn7(View view){

        textFaltas7.getText();
        Integer campoAf = Integer.parseInt(textFaltas7.getText().toString());
        Integer campoBf = Integer.valueOf(1);

        int resultadof3 = campoAf + campoBf;

        textFaltas7.setText(String.valueOf(resultadof3));

        referencia7.child("Faltas").setValue(resultadof3);

        if(resultadof3 > 7){

            textAluno7.setTextColor(Color.parseColor("#808000"));

        }if(resultadof3 > 11){

            textAluno7.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    //Ouvinte do Aluno 8
    private void ouvinte_8(){
        DatabaseReference reference = database.getReference().child("Aluno8");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String p5 = snapshot.child("Presenca").getValue().toString();
                String f5 = snapshot.child("Faltas").getValue().toString();

                textAluno8.setText(name);
                textPresenca8.setText(p5);
                textFaltas8.setText(f5);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });

    }
    public void Btnpresenca8(View view){

        textPresenca8.getText();

        Integer campoA = Integer.parseInt(textPresenca8.getText().toString());
        Integer campoB = Integer.valueOf(1);

        int resultado2 = campoA + campoB;

        textAluno8.setText(String.valueOf(resultado2));


        referencia8.child("Presenca").setValue(resultado2);

    }
    public void faltasbtn8(View view){

        textFaltas8.getText();
        Integer campoAf = Integer.parseInt(textFaltas8.getText().toString());
        Integer campoBf = Integer.valueOf(1);

        int resultadof3 = campoAf + campoBf;

        textFaltas8.setText(String.valueOf(resultadof3));

        referencia8.child("Faltas").setValue(resultadof3);

        if(resultadof3 > 7){

            textAluno8.setTextColor(Color.parseColor("#808000"));

        }if(resultadof3 > 11){

            textAluno8.setTextColor(Color.parseColor("#FF0000"));
        }
    }
    //Ouvinte do Aluno 9
    private void ouvinte_9(){
        DatabaseReference reference = database.getReference().child("Aluno9");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());

                String name = snapshot.child("nome").getValue().toString();
                String p5 = snapshot.child("Presenca").getValue().toString();
                String f5 = snapshot.child("Faltas").getValue().toString();

                textAluno9.setText(name);
                textPresenca9.setText(p5);
                textFaltas9.setText(f5);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("FIREBASE", "Ocorreu um erro ao acessar o banco de dados da aplicação, certifique-se se está tudo certo com o codigo ou a internet" + error);
            }
        });

    }
    public void Btnpresenca9(View view){

        textPresenca9.getText();

        Integer campoA = Integer.parseInt(textPresenca9.getText().toString());
        Integer campoB = Integer.valueOf(1);

        int resultado2 = campoA + campoB;

        textAluno9.setText(String.valueOf(resultado2));


        referencia9.child("Presenca").setValue(resultado2);

    }
    public void faltasbtn9(View view){

        textFaltas9.getText();
        Integer campoAf = Integer.parseInt(textFaltas9.getText().toString());
        Integer campoBf = Integer.valueOf(1);

        int resultadof3 = campoAf + campoBf;

        textFaltas9.setText(String.valueOf(resultadof3));

        referencia9.child("Faltas").setValue(resultadof3);

        if(resultadof3 > 7){

            textAluno9.setTextColor(Color.parseColor("#808000"));

        }if(resultadof3 > 11){

            textAluno9.setTextColor(Color.parseColor("#FF0000"));
        }
    }

}