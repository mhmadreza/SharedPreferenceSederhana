package com.mr.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tvUsername, tvPassword;
    AppCompatButton btnMasuk;
    Intent intent;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInit();
    }

    private void setInit() {
        tvUsername = findViewById(R.id.et_username);
        tvPassword = findViewById(R.id.et_password);
        btnMasuk = findViewById(R.id.btn_Masuk);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        sharedPreferences.contains("username");
        sharedPreferences.contains("password");

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = tvUsername.getText().toString();
                String pw = tvPassword.getText().toString();

                if (uname.equals("Reza") && pw.equals("reza123")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", uname);
                    editor.putString("password", pw);
                    editor.apply();
                    intent = new Intent(MainActivity.this, DetailActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "DATA TIDAK DITEMUKAN!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}