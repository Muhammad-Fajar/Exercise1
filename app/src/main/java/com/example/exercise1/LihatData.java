package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tvnama, tvnomor;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        tvnama.setText(nama);
        switch (nama){
            case"Maman":
                tvnama.setText("Maman M");
                tvnomor.setText("081234567809");
                break;
            case"Ilham":
                tvnama.setText("Ilham M");
                tvnomor.setText("081234565390");
                break;
            case"Jajang":
                tvnama.setText("Jajang J");
                tvnomor.setText("081234098809");
                break;
            case"Fikri":
                tvnama.setText("Fikri F");
                tvnomor.setText("083214567809");
                break;
            case"Udin":
                tvnama.setText("Udin U");
                tvnomor.setText("081287667809");
                break;
            case"Intan":
                tvnama.setText("Intan I");
                tvnomor.setText("081237897809");
                break;
            case"Vina":
                tvnama.setText("VIna V");
                tvnomor.setText("081234512309");
                break;
            case"Gigi":
                tvnama.setText("Gigi G");
                tvnomor.setText("081234534809");
                break;
            case"Vian":
                tvnama.setText("Vian V");
                tvnomor.setText("081231807809");
                break;
            case"Lutfi":
                tvnama.setText("Lutfi L");
                tvnomor.setText("081234309809");
                break;
        }
    }
}