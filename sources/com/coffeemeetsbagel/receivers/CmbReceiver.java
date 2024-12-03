package com.coffeemeetsbagel.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appsflyer.SingleInstallBroadcastReceiver;
import com.mparticle.MPReceiver;

public class CmbReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        new SingleInstallBroadcastReceiver().onReceive(context, intent);
        new MPReceiver().onReceive(context, intent);
    }
}
