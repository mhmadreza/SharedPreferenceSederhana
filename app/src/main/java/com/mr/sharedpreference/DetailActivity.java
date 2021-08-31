package com.mr.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setInitDetail();
    }

    private void setInitDetail() {

        TextView detUser = findViewById(R.id.tv_detailUser);
        AppCompatButton btnKeluar = findViewById(R.id.btn_keluar);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);

        detUser.setText(sharedPreferences.getString("username", null));
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}