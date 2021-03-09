package com.example.aplikasipertama;

import androidx.appcompat.app.AppCompatActivity;

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
                passwordnya = "admin";

                sukses = "Login Sukses";
                pwsalah = "Password Salah";
                emailsalah = "Email Salah";
                salah = "Email dan Password Salah";

                if ((email.equals(emailnya)) && (password.equals(passwordnya))){
                    Toast t = Toast.makeText(getApplicationContext(),
                            sukses, Toast.LENGTH_LONG);
                    t.show();
                }
                else if ((email.equals(emailnya)) && (!password.equals(passwordnya))){
                    Toast t = Toast.makeText(getApplicationContext(),
                            pwsalah, Toast.LENGTH_LONG);
                    t.show();
                }
                else if ((!email.equals(emailnya)) && (password.equals(passwordnya))){
                    Toast t = Toast.makeText(getApplicationContext(),
                            emailsalah, Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(),
                            salah, Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }
}