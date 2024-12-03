package me;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.gms.common.e;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f41263a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f41264b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f41265c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f41266d;

    public static boolean a(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f41266d == null) {
            boolean z10 = false;
            if (p.h() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z10 = true;
            }
            f41266d = Boolean.valueOf(z10);
        }
        return f41266d.booleanValue();
    }

    @TargetApi(21)
    public static boolean b(@NonNull Context context) {
        return f(context);
    }

    public static boolean c() {
        int i10 = e.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean d(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f41263a == null) {
            boolean z10 = false;
            if (p.e() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z10 = true;
            }
            f41263a = Boolean.valueOf(z10);
        }
        return f41263a.booleanValue();
    }

    @TargetApi(26)
    public static boolean e(@NonNull Context context) {
        if (d(context) && !p.g()) {
            return true;
        }
        if (!f(context)) {
            return false;
        }
        if (!p.h() || p.k()) {
            return true;
        }
        return false;
    }

    @TargetApi(21)
    public static boolean f(@NonNull Context context) {
        if (f41264b == null) {
            boolean z10 = false;
            if (p.f() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z10 = true;
            }
            f41264b = Boolean.valueOf(z10);
        }
        return f41264b.booleanValue();
    }

    public static boolean g(@NonNull Context context) {
        if (f41265c == null) {
            boolean z10 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z10 = false;
            }
            f41265c = Boolean.valueOf(z10);
        }
        return f41265c.booleanValue();
    }
}
