package com.example.exercicio3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private EditText inputCharName;
//    private EditText inputCharRace;
    private Spinner inputCharRace;
//    private EditText inputCharClass;
    private Spinner inputCharClass;

    private int forca;
    private int inteligencia;
    private int destreza;

    private TextView textForca;
    private TextView textInteligencia;
    private TextView textDestreza;

    private Button btnIncreaseForca;
    private Button btnDecreaseForca;
    private Button btnIncreaseInteligencia;
    private Button btnDecreaseInteligencia;
    private Button btnIncreaseDestreza;
    private Button btnDecreaseDestreza;

    private Button btnSave;

    private TextView textCharSheet;

    private int pointsLeft = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputCharName = findViewById(R.id.inputCharName);
        inputCharRace = findViewById(R.id.inputCharRace);
        inputCharClass = findViewById(R.id.inputCharClass);

        textForca = findViewById(R.id.textForca);
        textInteligencia = findViewById(R.id.textInteligencia);
        textDestreza = findViewById(R.id.textDestreza);

        btnIncreaseForca = findViewById(R.id.btnIncreaseForca);
        btnDecreaseForca = findViewById(R.id.btnDecreaseForca);
        btnIncreaseInteligencia = findViewById(R.id.btnIncreaseInteligencia);
        btnDecreaseInteligencia = findViewById(R.id.btnDecreaseInteligencia);
        btnIncreaseDestreza = findViewById(R.id.btnIncreaseDestreza);
        btnDecreaseDestreza = findViewById(R.id.btnDecreaseDestreza);

        btnSave = findViewById(R.id.btnSave);

        textCharSheet = findViewById(R.id.charSheet);

        btnIncreaseForca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pointsLeft > 0) {
                    forca++;
                    pointsLeft--;

                    textForca.setText("" + forca);
                } else {
                    Toast.makeText(getApplicationContext(), "Você não tem mais pontos sobrando", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDecreaseForca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(forca > 0) {
                    forca--;
                    pointsLeft++;

                    textForca.setText("" + forca);
                } else {
                    Toast.makeText(getApplicationContext(), "O valor não pode ser menor que 0", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnIncreaseInteligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pointsLeft > 0) {
                    inteligencia++;
                    pointsLeft--;

                    textInteligencia.setText("" + inteligencia);
                } else {
                    Toast.makeText(getApplicationContext(), "Você não tem mais pontos sobrando", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDecreaseInteligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inteligencia > 0) {
                    inteligencia--;
                    pointsLeft++;

                    textInteligencia.setText("" + inteligencia);
                } else {
                    Toast.makeText(getApplicationContext(), "O valor não pode ser menor que 0", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnIncreaseDestreza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pointsLeft > 0) {
                    destreza++;
                    pointsLeft--;

                    textDestreza.setText("" + destreza);
                } else {
                    Toast.makeText(getApplicationContext(), "Você não tem mais pontos sobrando", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDecreaseDestreza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(destreza > 0) {
                    destreza--;
                    pointsLeft++;

                    textDestreza.setText("" + destreza);
                } else {
                    Toast.makeText(getApplicationContext(), "O valor não pode ser menor que 0", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String charName = inputCharName.getText().toString();
                String charRace = inputCharRace.getSelectedItem().toString();
                String charClass = inputCharClass.getSelectedItem().toString();

                int hp = forca * 5;

                String s = "Ficha do personagem" + "\n";
                s += "Nome: " + charName + "\n";
                s += "Raça: " + charRace + "\n";
                s += "Classe: " + charClass + "\n";

                // TODO modificar forca, inteligencia e destreza de acordo com a raça do personagem

                s += "HP: " + hp + "\n";
                s += "Força: " + forca + "\n";
                s += "Inteligencia: " + inteligencia + "\n";
                s += "Destreza: " + destreza + "\n";

                textCharSheet.setText(s);
            }
        });
    }
}
