package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tp4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TP4";
    private ActivityMainBinding ui;
    private int compteur = 0;


    //TextView texte = findViewById(R.id.texte);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // initialisation de l'activité
        super.onCreate(savedInstanceState);

        // mise en place du layout par un view binding
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        // titre de l'activité
        setTitle(getLocalClassName());
        //texte.setText("Bonjour");
        // message d'information
        Log.i(TAG, "dans "+getLocalClassName()+".onCreate");

        //écouteur pour le bouton 2 lambda
        /*ui.bouton2.setOnClickListener(btn -> {
                compteur += 2;
                ui.texte.setText("compteur = "+compteur);
             }

        );*/

        //écouteur pour le bouton 2 classe privée anonyme
        ui.bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int k;
                compteur += 5; //                compteur += K;

                ui.texte.setText("compteur = " + compteur);
            }

        });

        // écouteur pour le bouton3, référence de méthode
        ui.bouton3.setOnClickListener(this::onBouton3Click);

        // écouteur pour le bouton4, l'activité elle-meme
        ui.bouton4.setOnClickListener(this);




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "dans "+getLocalClassName()+".onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "dans "+getLocalClassName()+".onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "dans "+getLocalClassName()+".onResume");
    }


    public void onBouton1Click(View view){
        compteur += 1;
        ui.texte.setText("compteur ="+compteur);
    }

    private void onBouton3Click(View view){
        compteur *= 2;
        ui.texte.setText("compteur ="+compteur);
    }

    @Override
    public void onClick(View view) {
        compteur *= 5;
        ui.texte.setText("compteur = " + compteur);


        Button btn_information;
        btn_information = (Button)findViewById(R.id.informations);
        btn_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfosActivity.class);
                startActivity(intent);
            }
        });


    }
    private boolean onEditorAction(TextView textView,int actionId, KeyEvent event){
        if (actionId == EditorInfo.IME_ACTION_DONE){
            EditText username =(EditText)findViewById(R.id.username);
            // texte saisi
            String ui =username.getText().toString();
            //TODO lancement de MainActivity avec username,sans retour possible
            String information = null;
            int nombre = 0;
            Intent intent = new Intent(this,InfosActivity.class);
            intent.putExtra("information",information);
            intent.putExtra("nombre",nombre);
            startActivity(intent);


            return true;
        }else{
            //évènement non consommé

            return false;




        }



    }




    }


