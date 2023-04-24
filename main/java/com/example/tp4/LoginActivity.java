package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tp4.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityMainBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // initialisation interne de l'activité
        super.onCreate(savedInstanceState);
        EditText username =(EditText)findViewById(R.id.username);
        // mise en place du layout par un view binding
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        //titre de l'activité
        setTitle(getLocalClassName());
        //écouteur quand on valide la saisie du pseudo
        username.setOnEditorActionListener(this::onEditorAction);
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