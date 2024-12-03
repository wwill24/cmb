package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import oe.d;

public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f39067a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f39068b;

    /* renamed from: c  reason: collision with root package name */
    private static String f39069c;

    /* renamed from: d  reason: collision with root package name */
    private static int f39070d;

    public static int a(Context context) {
        b(context);
        return f39070d;
    }

    private static void b(Context context) {
        synchronized (f39067a) {
            if (!f39068b) {
                f39068b = true;
                try {
                    Bundle bundle = d.a(context).c(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f39069c = bundle.getString("com.google.app.id");
                        f39070d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e10);
                }
            }
        }
    }
}
