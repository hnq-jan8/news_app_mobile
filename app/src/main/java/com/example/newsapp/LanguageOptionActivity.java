package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LanguageOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_opiton);
        Button us_button = findViewById(R.id.us_option);
        Button fr_button = findViewById(R.id.fr_option);

        us_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LanguageOptionActivity.this, MainActivity.class);
                startActivity(intent);

            }

        });

        fr_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LanguageOptionActivity.this, MainActivityFR.class);
                startActivity(intent);

            }
        });
    }
}