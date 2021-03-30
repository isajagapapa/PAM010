package com.example.aplikasipertama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {

//    deklarasi variabel dengan jenis data TextView
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

//        Membuat variabel dengan data bundle dan
//        dan assign value dari variabel tersebut dengan
//        getIntent.getIntent()
        Bundle bundle = getIntent().getExtras();

//        Membuat variabel nama dan assign value dari pesa
//        yang dikirimkan dari activity sebelumnya
        String nama = bundle.getString("a");

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        switch (nama){
            case "Fais":
                tvnama.setText("Fais F");
                tvnomor.setText("081232434545");
                break;
            case "Fidi":
                tvnama.setText("Fidi Y");
                tvnomor.setText("088997766556");
                break;
            case "Ilham":
                tvnama.setText("Ilham K");
                tvnomor.setText("089078087991");
                break;
            case "Kurniawan":
                tvnama.setText("Kurniawan I");
                tvnomor.setText("086879964755");
                break;
            case "Baim":
                tvnama.setText("Baim W");
                tvnomor.setText("087738865900");
                break;
            case "Aldi":
                tvnama.setText("Aldi T");
                tvnomor.setText("085764775689");
                break;
            case "Taher":
                tvnama.setText("Taher A");
                tvnomor.setText("086654387890");
                break;
            case "Nissa":
                tvnama.setText("Nissa S");
                tvnomor.setText("081247823827");
                break;
            case "Riziex":
                tvnama.setText("Riziex S");
                tvnomor.setText("083388263527");
                break;
            case "Bening":
                tvnama.setText("Bening B");
                tvnomor.setText("082543712416");
                break;
        }
    }
}