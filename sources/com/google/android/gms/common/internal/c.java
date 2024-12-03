package com.google.android.gms.common.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class c {
    public static void a(@NonNull String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkMainThread: current thread ");
            sb2.append(valueOf);
            sb2.append(" IS NOT the main thread ");
            sb2.append(valueOf2);
            sb2.append("!");
            throw new IllegalStateException(str);
        }
    }

    public static void b(@NonNull String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkNotMainThread: current thread ");
            sb2.append(valueOf);
            sb2.append(" IS the main thread ");
            sb2.append(valueOf2);
            sb2.append("!");
            throw new IllegalStateException(str);
        }
    }

    @EnsuresNonNull({"#1"})
    public static void c(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }
}
