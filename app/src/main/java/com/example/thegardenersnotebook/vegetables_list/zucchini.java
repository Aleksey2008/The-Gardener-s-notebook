package com.example.thegardenersnotebook.vegetables_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.thegardenersnotebook.NotificationService1;
import com.example.thegardenersnotebook.R;
import com.example.thegardenersnotebook.vegetables;


public class zucchini extends AppCompatActivity {

private static final int NOTIFICATION_ID = 10; // Unique ID for tomatoes activity

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zucchini);

        EditText editText = findViewById(R.id.edtxt_tom);
        EditText edtxt_nt = findViewById(R.id.edtxt_nt);

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        String savedText = preferences.getString("savedText", "");

        editText.setText(savedText);

        editText.addTextChangedListener(new TextWatcher() {
@Override
public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
@Override
public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
@Override
public void afterTextChanged(Editable editable) {
        preferences.edit().putString("savedText", editable.toString()).apply();
        }
        });

        SharedPreferences preferences1 = getPreferences(Context.MODE_PRIVATE);
        String savedText1 = preferences.getString("savedText1", "");

        edtxt_nt.setText(savedText1);

        edtxt_nt.addTextChangedListener(new TextWatcher() {
@Override
public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
@Override
public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
@Override
public void afterTextChanged(Editable editable) {
        preferences1.edit().putString("savedText1", editable.toString()).apply();
        }
        });
        }

public void scheduleNotificationWithDelay(String title, String contentText, long triggerTimeMillis, long intervalMillis, int requestCode) {
        Intent intent = new Intent(this, NotificationService1.class);
        intent.putExtra("TITLE", title);
        intent.putExtra("CONTENT_TEXT", contentText);

        PendingIntent pendingIntent = PendingIntent.getService(this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, triggerTimeMillis, intervalMillis, pendingIntent);
        }

public void home(View view) {
        Intent intent = new Intent(zucchini.this, vegetables.class);
        startActivity(intent);
        }

public void btn_ad(View view) {
        EditText edtxt_nt = findViewById(R.id.edtxt_nt);
        int hours = Integer.parseInt(edtxt_nt.getText().toString());
        long intervalMillis = hours ;
        long triggerTimeMillis = System.currentTimeMillis() + intervalMillis;
        scheduleNotificationWithDelay("Полив кабачков", "Пора поливать кабачки", triggerTimeMillis, intervalMillis, NOTIFICATION_ID);
        }

public void btn_del(View view) {
        Intent intent = new Intent(this, NotificationService1.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
        }
        }

