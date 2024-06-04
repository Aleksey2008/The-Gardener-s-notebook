package com.example.thegardenersnotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.thegardenersnotebook.vegetables_list.bean;
import com.example.thegardenersnotebook.vegetables_list.beet;
import com.example.thegardenersnotebook.vegetables_list.cabbage;
import com.example.thegardenersnotebook.vegetables_list.carrot;
import com.example.thegardenersnotebook.vegetables_list.cucumber;
import com.example.thegardenersnotebook.vegetables_list.eggplants;
import com.example.thegardenersnotebook.vegetables_list.onion;
import com.example.thegardenersnotebook.vegetables_list.pepper;
import com.example.thegardenersnotebook.vegetables_list.tomatoes;
import com.example.thegardenersnotebook.vegetables_list.zucchini;

public class vegetables extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);
    }

    public void home(View view) {
        Intent intent = new Intent(vegetables.this, MainActivity.class);
        startActivity(intent);
    }

    public void tomatoes(View view) {
        Intent intent = new Intent(vegetables.this, tomatoes.class);
        startActivity(intent);
    }

    public void pepper(View view) {
        Intent intent = new Intent(vegetables.this, pepper.class);
        startActivity(intent);
    }

    public void cucumber(View view) {
        Intent intent = new Intent(vegetables.this, cucumber.class);
        startActivity(intent);
    }

    public void carrot(View view) {
        Intent intent = new Intent(vegetables.this, carrot.class);
        startActivity(intent);
    }

    public void onion(View view) {
        Intent intent = new Intent(vegetables.this, onion.class);
        startActivity(intent);
    }

    public void beet(View view) {
        Intent intent = new Intent(vegetables.this, beet.class);
        startActivity(intent);
    }

    public void eggplants(View view) {
        Intent intent = new Intent(vegetables.this, eggplants.class);
        startActivity(intent);
    }

    public void bean(View view) {
        Intent intent = new Intent(vegetables.this, bean.class);
        startActivity(intent);
    }

    public void cabbage(View view) {
        Intent intent = new Intent(vegetables.this, cabbage.class);
        startActivity(intent);
    }

    public void zucchini(View view) {
        Intent intent = new Intent(vegetables.this, zucchini.class);
        startActivity(intent);
    }
}