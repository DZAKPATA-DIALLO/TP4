package com.example.tp4;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class InfosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // initialisation de l'activité
        super.onCreate(savedInstanceState);
        // mise en place du layout
        setContentView(R.layout.activity_infos);
        // titre de l'activité
        setTitle(getLocalClassName());
        // message d'information
        Log.i(TAG, "dans "+getLocalClassName()+".onCreate");

        Button btn_retour;
        btn_retour = (Button)findViewById(R.id.Retour);
        btn_retour.setOnClickListener(new View.OnClickListener() {   @Override
        public void onClick(View view) {
            finish();
        }

        });

    }
   // Intent intent =getIntent();
   // String information = intent.getStringExtra("information");
    //int nombre = intent.getIntExtra("nombre",-1)


}