package com.nazim2.mediatest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by BaRon45 on 12/06/2015.
 */
public class PhoneReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extra=intent.getExtras();
        if(extra!=null) {

          String state=extra.getString(TelephonyManager.EXTRA_STATE);
            Log.d("Nazim",state);
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {

          String phoneNum=extra.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("Nazim",phoneNum);

            }

            }
        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){

Log.i("Nazim","SCREEN IS OFFF");

        }

        else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)){

            Log.i("Nazim","SCREEN IS ON");
        }
    }
}
