package com.example.homework521;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText mLoginEditText;
    private EditText mPasswordEditText;
    Toast ex;
    Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginEditText = findViewById(R.id.edit_login);
        mPasswordEditText = findViewById(R.id.edit_password);
        registration = findViewById(R.id.buttonRegistration);
        registration.setOnClickListener(regListner);


    }

    private final View.OnClickListener regListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String fileNameLogin = "logFile";
            String fileNamePass = "passFile";
            FileOutputStream outputStreamLogin;
            FileOutputStream outputStreamPass;
            try {
                if (mLoginEditText.getText().length()!=0 && mPasswordEditText.getText().length()!=0) {
                    outputStreamLogin = openFileOutput(fileNameLogin, Context.MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriterLogin = new OutputStreamWriter(outputStreamLogin);
                    BufferedWriter bwLogin = new BufferedWriter(outputStreamWriterLogin);
                    bwLogin.write(mLoginEditText.toString());
                    bwLogin.close();

                    outputStreamPass = openFileOutput(fileNamePass, Context.MODE_PRIVATE);
                    OutputStreamWriter streamWriterPass = new OutputStreamWriter(outputStreamPass);
                    BufferedWriter bwPass = new BufferedWriter(streamWriterPass);
                    bwPass.write(mPasswordEditText.toString());
                    bwPass.close();
                    //ex.makeText(getApplicationContext(), "Успешная регистрация", Toast.LENGTH_LONG);
                    Toast.makeText(MainActivity.this, "Успешная регистрация", Toast.LENGTH_LONG).show();
                } else {
                    //ex.makeText(getApplicationContext(), "Не заполнено поле логин или пароль", Toast.LENGTH_LONG);
                    Toast.makeText(MainActivity.this, "Не заполнено поле логин или пароль", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    public void clickRegistration(View view) {

    }

    public void clickLogin(View view) {

    }
}