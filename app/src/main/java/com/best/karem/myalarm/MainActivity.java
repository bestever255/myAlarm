package com.best.karem.myalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText alarmEd;
    private Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        alarmEd = findViewById(R.id.alarmEd);
        confirmBtn = findViewById(R.id.alarmConfirmBtn);


        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int time = Integer.parseInt(alarmEd.getText().toString());

                Intent intent = new Intent(MainActivity.this , Alarm.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext() , 0 , intent , 0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP , System.currentTimeMillis() + time * 1000 , pendingIntent);

            }
        });

    }
}
