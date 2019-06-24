package com.example.homework521;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText mLoginEditText;
    private EditText mPasswordEditText;
    Toast ex;
    Button registration;
    Button login;
    String fileNameLogin;
    String fileNamePass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginEditText = findViewById(R.id.edit_login);
        mPasswordEditText = findViewById(R.id.edit_password);

        fileNameLogin = "logFile";
        fileNamePass = "passFile";


        registration = findViewById(R.id.buttonRegistration);
        registration.setOnClickListener(regListner);
        login = findViewById(R.id.buttonLogin);
        login.setOnClickListener(loginListner);


    }

    private final View.OnClickListener regListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FileOutputStream outputStreamLogin;
            FileOutputStream outputStreamPass;
            try {
                if (mLoginEditText.getText().length()!=0 && mPasswordEditText.getText().length()!=0) {
                    outputStreamLogin = openFileOutput(fileNameLogin, Context.MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriterLogin = new OutputStreamWriter(outputStreamLogin);
                    BufferedWriter bwLogin = new BufferedWriter(outputStreamWriterLogin);
                    String textLogin = mLoginEditText.getText().toString();
                    bwLogin.write(textLogin);
                    bwLogin.close();

                    outputStreamPass = openFileOutput(fileNamePass, Context.MODE_PRIVATE);
                    OutputStreamWriter streamWriterPass = new OutputStreamWriter(outputStreamPass);
                    BufferedWriter bwPass = new BufferedWriter(streamWriterPass);
                    String textPass = mPasswordEditText.getText().toString();
                    bwPass.write(textPass);
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


    private final View.OnClickListener loginListner = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            try {
                FileInputStream fileInputLogin = openFileInput(fileNameLogin);
                InputStreamReader inputStreamReaderLogin = new InputStreamReader(fileInputLogin);
                BufferedReader bfrLogin = new BufferedReader(inputStreamReaderLogin);
                String lineLogin = bfrLogin.readLine();


                FileInputStream fileInputPass = openFileInput(fileNamePass);
                InputStreamReader inputStreamReaderPass = new InputStreamReader(fileInputPass);
                BufferedReader bfrPass = new BufferedReader(inputStreamReaderPass);
                String linePass = bfrPass.readLine();


                if(mLoginEditText.getText().toString().equals(lineLogin)
                        && mPasswordEditText.getText().toString().equals(linePass)){
                    Toast.makeText(MainActivity.this, "Успешный вход", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Неверный логин или пароль", Toast.LENGTH_LONG).show();
                }



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    public void clickRegistration(View view) {

    }

    public void clickLogin(View view) {

    }
}