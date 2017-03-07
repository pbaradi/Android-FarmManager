package com.android.farmmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityFarmManager extends AppCompatActivity {
    public static int temperature;
    public static int humidity;
    private TextView temperature_id;
    private TextView humidity_id;
    private TextView txt_temperature;
    private TextView txt_humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
    }

    @Override
    protected void onResume(){
        super.onResume();


    }

    public void turnFan(View view){
        if(temperature >= 70 && temperature < 90){
            Intent intent = new Intent("com.android.farm.temperature.broadcast.response");
            intent.putExtra("switch", "fan");
            sendBroadcast(intent);
            Toast.makeText(ActivityFarmManager.this, "Fan Turned On!",
                    Toast.LENGTH_LONG).show();
        }else if(temperature >=90){
            Toast.makeText(ActivityFarmManager.this, "Please turn on Fan & Sprinkler.",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ActivityFarmManager.this, "Cannot switch on Fan. Please check temperature.",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void turnBoth(View view){
        if(temperature >= 90 && temperature < 1250){
            Intent intent = new Intent("com.android.farm.temperature.broadcast.response");
            intent.putExtra("switch", "both");
            sendBroadcast(intent);
            Toast.makeText(ActivityFarmManager.this, "Fan & Sprinkler Turned On!",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ActivityFarmManager.this, "Cannot switch on Fan and sprinkler. Please check temperature.",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void onClickTemperature(View view){
        temperature_id = (TextView)findViewById(R.id.temp_id);
        humidity_id = (TextView)findViewById(R.id.humidity_id);
        txt_humidity = (TextView)findViewById(R.id.txt_humidity);
        txt_temperature = (TextView)findViewById(R.id.txt_temp);
        txt_temperature.setEnabled(false);
        txt_humidity.setEnabled(false);
        temperature_id.setEnabled(false);
        humidity_id.setEnabled(false);
        temperature_id.setText(Integer.toString(temperature));
        humidity_id.setText(Integer.toString(humidity));
    }


}
