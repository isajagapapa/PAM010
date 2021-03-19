package com.example.aplikasipertama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnsignin;
    EditText edemail, edpassword;
    String email, password, emailnya, passwordnya, sukses, pwsalah, emailsalah, salah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsignin = findViewById(R.id.btnSignin);
        edemail = findViewById(R.id.edEmail);
        edpassword = findViewById(R.id.edPassword);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edemail.getText().toString();
                password = edpassword.getText().toString();

                emailnya = "admin@mail.com";
                passwordnya = "123";

                sukses = "Login Sukses";
                pwsalah = "Password Salah";
                emailsalah = "Email Salah";
                salah = "Email dan Password Salah";

                if (email.isEmpty() || password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    if ((email.equals(emailnya)) && (password.equals(passwordnya))){
                        Toast t = Toast.makeText(getApplicationContext(),
                                sukses, Toast.LENGTH_LONG);
                        t.show(); //menampilkan toast

                        //Membuat objek bundle
                        Bundle b =new Bundle();

                        //Memasukkan value dari variabel email dengan kunci "a"
                        //dan dimasukkan ke dalam bundle
                        b.putString("a", email.trim());

                        //Memasukkan value dari variabel email dengan kunci "a"
                        //dan dimasukkan ke dalam bundle
                        b.putString("b", password.trim());

                        //Membuat objek intent berpindah activity dari main ke hasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                        //Memasukkan bundle ke dalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);

                        //berpindah ke ActivityHasil
                        startActivity(i);
                    }
                    else {
                        if ((email.equals(emailnya)) && (!password.equals(passwordnya))){
                            Toast t = Toast.makeText(getApplicationContext(),
                                    pwsalah, Toast.LENGTH_LONG);
                            t.show();
                        }
                        else if ((!email.equals(emailnya)) && (password.equals(passwordnya))){
                            Toast t = Toast.makeText(getApplicationContext(),
                                    emailsalah, Toast.LENGTH_LONG);
                            t.show();
                        }
                        else{
                            Toast t = Toast.makeText(getApplicationContext(),
                                    salah, Toast.LENGTH_LONG);
                            t.show();
                        }

                    }
                }
            }
        });
    }
}