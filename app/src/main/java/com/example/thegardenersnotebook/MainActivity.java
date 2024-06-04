package com.example.thegardenersnotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void vegetables(View view) {
        Intent intent = new Intent(MainActivity.this, vegetables.class);
        startActivity(intent);
    }

    public void flowers(View view) {
        Intent intent = new Intent(MainActivity.this, flowers.class);
        startActivity(intent);
    }

    public void fruits(View view) {
        Intent intent = new Intent(MainActivity.this, fruits.class);
        startActivity(intent);
    }

    public void berries(View view) {
        Intent intent = new Intent(MainActivity.this, berries.class);
        startActivity(intent);
    }
}