package com.example.monpremierprojet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        Recuperation du composant TextView par son id
        TextView monTexte = findViewById(R.id.tvMessage);
        monTexte.setText("J'apprend le code en ligne");
        Button button;
        button = findViewById(R.id.btnAction);
        EditText editText;
        editText = findViewById(R.id.etSaisie);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ICI : Écris la ligne de code pour changer le texte de monTexte
//                monTexte.setText("Nonveau texte");

                // 1. On récupère ce que l'utilisateur a écrit et on le transforme en chaîne de texte (String)
                String messageUtilisateur = editText.getText().toString();

                // 2. On affiche ce message dans le TextView
//                monTexte.setText(messageUtilisateur);

                // 3. On affiche un message toast
//                Toast.makeText(MainActivity.this, "Bravo, ça fonctionne !", Toast.LENGTH_SHORT).show();

// 2. ON VERIFIE AVEC UN IF LA CONDITION DE SAISIE EST VIDE OU PAS
                if (messageUtilisateur.isEmpty()) {
                    // Si c'est vide (isEmpty), on affiche une alerte
                    Toast.makeText(MainActivity.this, "Vous n'avez rien écrit !", Toast.LENGTH_SHORT).show();
                } else {
                    // SINON (si il y a du texte), on fait le travail normal
                    monTexte.setText(messageUtilisateur);
                    Toast.makeText(MainActivity.this, "Message modifié !", Toast.LENGTH_SHORT).show();

                    // Changer de page
                    Intent intent = new Intent(MainActivity.this, PageDeuxActivity.class);
                    intent.putExtra("message", messageUtilisateur);
                    startActivity(intent);
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvResultat), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}