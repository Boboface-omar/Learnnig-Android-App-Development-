package com.example.monpremierprojet;

import android.os.Bundle;
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
        // Récupération du message depuis l'activité précédente
        TextView resultat = findViewById(R.id.tvResult);
        // On récupère le message depuis l'intent
        String message = getIntent().getStringExtra("message");
        // On affiche le message dans le TextView
        resultat.setText(message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvResultat), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}