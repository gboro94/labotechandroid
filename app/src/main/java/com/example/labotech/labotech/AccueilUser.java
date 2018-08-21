package com.example.labotech.labotech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class AccueilUser extends AppCompatActivity {
    CardView cvnouveau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueiluser);

        cvnouveau = (CardView)findViewById(R.id.nouveau);
        cvnouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Nouveau",Toast.LENGTH_LONG).show();
            }
        });
    }
}
