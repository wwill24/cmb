package com.leanplum.internal;

import android.os.Handler;
import android.os.Looper;

public abstract class Operation implements Runnable {
    private static final Handler handler = new Handler(Looper.getMainLooper());

    public static void removeOperationOnUiThread(Runnable runnable) {
        handler.removeCallbacks(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        handler.post(runnable);
    }

    public static void runOnUiThreadAfterDelay(Runnable runnable, long j10) {
        handler.postDelayed(runnable, j10);
    }
}
