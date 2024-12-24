package com.example.lab4;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MorningActivity extends AppCompatActivity {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morning_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        next=findViewById(R.id.buttonMD);
        MyPushNotification myPushNotification = new MyPushNotification(this,
                getSystemService(NotificationManager.class));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPushNotification.sendNotify("Предупреждение","Скоро конец рабочего дня ;)");
                Intent intent=new Intent(getApplicationContext(),DayActivity.class);
                startActivity(intent);
            }
        });
    }
}