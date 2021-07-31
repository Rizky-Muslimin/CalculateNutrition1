package com.example.nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Spinner kelaminSpinner;
    EditText txtBerat;
    EditText txtTinggi;
    EditText txtUsia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        kelaminSpinner = findViewById(R.id.jk_spinner);
        txtBerat = findViewById(R.id.txtBerat);
        txtTinggi = findViewById(R.id.txtTinggi);
        txtUsia = findViewById(R.id.txtUmur);

        txtBerat.setInputType(InputType.TYPE_CLASS_NUMBER );
        txtTinggi.setInputType(InputType.TYPE_CLASS_NUMBER );
        txtUsia.setInputType(InputType.TYPE_CLASS_NUMBER );
    }

    public void OnCalculate(View view){
        if(txtBerat.getText().toString().equals("") || txtTinggi.getText().toString().equals("") || txtUsia.getText().toString().equals("")){
            Toast.makeText(this, "Mohon lengkapi data!", Toast.LENGTH_SHORT).show();
            return;
        }
        
        boolean isPria = kelaminSpinner.getSelectedItem() == "Pria";
        float berat = txtBerat.getText().toString().equals("") ? 0 : Float.parseFloat(txtBerat.getText().toString());
        float tinggi =  txtTinggi.getText().toString().equals("") ? 0 : Float.parseFloat(txtTinggi.getText().toString());
        float umur =  txtUsia.getText().toString().equals("") ? 0 : Float.parseFloat(txtUsia.getText().toString());




        float kalori = CalculateCalorie(isPria, berat, tinggi, umur);
        float protein = GetProtein(kalori);
        float karbo = GetKarbo(kalori);

        //Toast.makeText(this, "Berat : "+ berat + " Tinggi : " + tinggi + " Usia : " + umur +  " JK : " + isPria, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(HomeActivity.this, KaloriActivity.class);
        intent.putExtra("kalori", kalori);
        intent.putExtra("protein", protein);
        intent.putExtra("karbo", karbo);

        startActivity(intent);
    }

    private float CalculateCalorie(boolean isPria, float berat, float tinggi, float usia){
        if(isPria){
            return (float)(66 + (13.7 * berat) + (5 * tinggi) - (6.8 * usia));
        }
        return (float)(665 + (9.6 * berat) + (1.8 * tinggi) - (4.7 * usia));
    }

    private float GetProtein(float calorie){
        return (0.15f * calorie) / 4f;
    }

    private float GetKarbo(float calorie){
        return (0.6f * calorie) / 4f;
    }

    public void BackToHome(View view){
        ActivityManager.GoToActivity(this, MainActivity.class);
    }
}