package com.mparticle;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import androidx.annotation.NonNull;

@SuppressLint({"Registered"})
public class MPService extends IntentService {
    public MPService() {
        super("com.mparticle.MPService");
    }

    public final void onHandleIntent(@NonNull Intent intent) {
        new a0(this).e(intent);
    }
}
