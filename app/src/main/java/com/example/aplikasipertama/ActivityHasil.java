package com.example.aplikasipertama;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityHasil extends AppCompatActivity {

    TextView txEmail, txPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        //Menghubungkan variabel disini dengan componen textview pada layout
        txEmail = findViewById(R.id.txemail);
        txPassword = findViewById(R.id.txpassword);

        //mendeklarasikan variabel bundle yang akan digunakan
        //untuk mengambul pesan yang dikirimkan melalui methos intent
        Bundle bundle = getIntent().getExtras();

        /* membuat variabel string yang digunakan untuk menyimpan
        * data yang dikirimkan dari activity sebelumnya melalui kunci*/
        String email = bundle.getString("a");
        String pass = bundle.getString("b");

        //menampilkan value dari variabel ke dalam text view
        txEmail.setText(email);
        txPassword.setText(pass);
    }
}
