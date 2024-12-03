package com.google.mlkit.common.internal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;

public class MlKitComponentDiscoveryService extends Service {
    public final IBinder onBind(@NonNull Intent intent) {
        return null;
    }
}
