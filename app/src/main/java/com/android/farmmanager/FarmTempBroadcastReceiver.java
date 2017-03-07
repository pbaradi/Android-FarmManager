package com.android.farmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by pavanibaradi on 9/19/16.
 */
public class FarmTempBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        if(intent.getAction().equals("com.android.farm.temperature.broadcast.request")){
            ActivityFarmManager.temperature = intent.getExtras().getInt("temperature");
            ActivityFarmManager.humidity = intent.getExtras().getInt("humidity");
        }
    }
}
