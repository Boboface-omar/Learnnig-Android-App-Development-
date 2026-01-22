package com.example.monpremierprojet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PageDeuxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page_deux);
        // Affiche la flèche de retour dans la barre en haut
        // On vérifie d'abord si la barre existe pour éviter le crash
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        // Récupération du message depuis l'activité précédente
        TextView resultat = findViewById(R.id.tvResult);
        // On récupère le message depuis l'intent
        String message = getIntent().getStringExtra("message");
        // On affiche le message dans le TextView
        resultat.setText(message);
        // 1. On récupère le composant Button par son id
        Button button;
        button = findViewById(R.id.btnSend);
        // 2. On prépare l'action du clic
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain"); // On dit qu'on envoie du texte simple
                String texteAPartager = resultat.getText().toString();
                shareIntent.putExtra(Intent.EXTRA_TEXT, texteAPartager); // On met le message dans la valise

// On lance le menu de choix d'Android
                startActivity(Intent.createChooser(shareIntent, "Partager via..."));

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvResultat), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}