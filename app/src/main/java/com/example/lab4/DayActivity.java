package com.example.lab4;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DayActivity extends AppCompatActivity {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        next=findViewById(R.id.buttonDD);
        MyPushNotification myPushNotification = new MyPushNotification(this,
                getSystemService(NotificationManager.class));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPushNotification.sendNotify("Предупреждение","Спаааать!");
                Intent intent=new Intent(getApplicationContext(),EveningActivity.class);
                startActivity(intent);
            }
        });
    }
}
