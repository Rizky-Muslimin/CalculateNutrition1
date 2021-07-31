package com.example.nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class KaloriActivity extends AppCompatActivity {

    EditText txtKalori;
    EditText txtProtein;
    EditText txtKarbo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalori);

        txtKalori = findViewById(R.id.txtKalori);
        txtProtein = findViewById(R.id.txtProtein);
        txtKarbo = findViewById(R.id.txtKarbo);

        Bundle extras = getIntent().getExtras();
        float kalori = extras.getFloat("kalori");
        float protein = extras.getFloat("protein");
        float karbo = extras.getFloat("karbo");

        txtKalori.setText(Float.toString(kalori));
        txtProtein.setText(Float.toString(protein));
        txtKarbo.setText(Float.toString(karbo));

    }

    public void BackToCalculate(View view){
        ActivityManager.GoToActivity(this, HomeActivity.class);
    }
}