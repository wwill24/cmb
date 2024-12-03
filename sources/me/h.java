package me;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f41261a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    public static boolean a(@NonNull Context context, @NonNull Throwable th2) {
        try {
            p.k(context);
            p.k(th2);
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
