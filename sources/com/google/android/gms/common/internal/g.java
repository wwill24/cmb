package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private static int f38996a = 4225;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f38997b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static s1 f38998c = null;

    /* renamed from: d  reason: collision with root package name */
    static HandlerThread f38999d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f39000e = false;

    public static int a() {
        return f38996a;
    }

    @NonNull
    public static g b(@NonNull Context context) {
        Looper looper;
        synchronized (f38997b) {
            if (f38998c == null) {
                Context applicationContext = context.getApplicationContext();
                if (f39000e) {
                    looper = c().getLooper();
                } else {
                    looper = context.getMainLooper();
                }
                f38998c = new s1(applicationContext, looper);
            }
        }
        return f38998c;
    }

    @NonNull
    public static HandlerThread c() {
        synchronized (f38997b) {
            HandlerThread handlerThread = f38999d;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f38999d = handlerThread2;
            handlerThread2.start();
            HandlerThread handlerThread3 = f38999d;
            return handlerThread3;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void d(n1 n1Var, ServiceConnection serviceConnection, String str);

    public final void e(@NonNull String str, @NonNull String str2, int i10, @NonNull ServiceConnection serviceConnection, @NonNull String str3, boolean z10) {
        d(new n1(str, str2, i10, z10), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean f(n1 n1Var, ServiceConnection serviceConnection, String str, Executor executor);
}
