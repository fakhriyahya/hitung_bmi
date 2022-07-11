package com.example.dbsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {
    EditText berat, tinggi;
    TextView tampilhasil;
    String perhitungan, hasilBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        berat = findViewById(R.id.berat);
        tinggi = findViewById(R.id.tinggi);
        tampilhasil = findViewById(R.id.tampil);
    }

    public void hitung(View view) {
        String S1 = berat.getText().toString();
        String S2 = tinggi.getText().toString();

        float beratValue = Float.parseFloat(S1);
        float tinggiValue = Float.parseFloat(S2) / 100;

        float bmi = beratValue / (tinggiValue * tinggiValue);

        if(bmi < 16){
            hasilBMI = "Kurang Gizi";
        }else if(bmi < 18.5){
            hasilBMI = "Kurus";
        }else if(bmi >= 18.5 && bmi <= 24.9){
            hasilBMI = "Normal";
        }else if (bmi >= 25 && bmi <= 29.9){
            hasilBMI = "Gemukt";
        }else{
            hasilBMI = "Obesitas";
        }

        perhitungan = "BMI anda adalah : " + bmi + ", Kategori BMI : " + hasilBMI;

        tampilhasil.setText(perhitungan);
    }

    public void Kembali(View view) {
        Intent intent = new Intent(HasilActivity.this,MainActivity.class);
        startActivity(intent);
    }

}