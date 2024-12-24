package com.example.lab4;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnMorning;
    private Button btnDay;
    private Button btnEvening;
    private Button btnNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //вертикальное расположение
        btnMorning=findViewById(R.id.buttonMorning);
        btnDay=findViewById(R.id.buttonDay);
        btnEvening=findViewById(R.id.buttonEvening);
        btnNight=findViewById(R.id.buttonNight);
        //создание пуша
        MyPushNotification myPushNotification = new MyPushNotification(this,
                getSystemService(NotificationManager.class));
        btnMorning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MorningActivity.class);
                startActivity(intent);
            }
        });
        btnDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPushNotification.sendNotify("Предупреждение","Скоро конец рабочего дня ;)");
                Intent intent=new Intent(getApplicationContext(),DayActivity.class);
                startActivity(intent);
            }
        });
        btnEvening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPushNotification.sendNotify("Предупреждение","Спаааать!");
                Intent intent=new Intent(getApplicationContext(),EveningActivity.class);
                startActivity(intent);
            }
        });
        btnNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),NightActivity.class);
                startActivity(intent);
            }
        });
    }
}