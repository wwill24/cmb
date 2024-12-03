package me;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.f;
import oe.d;

public final class s {
    public static boolean a(@NonNull Context context, int i10) {
        if (!b(context, i10, "com.google.android.gms")) {
            return false;
        }
        try {
            return f.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            Log.isLoggable("UidVerifier", 3);
            return false;
        }
    }

    @TargetApi(19)
    public static boolean b(@NonNull Context context, int i10, @NonNull String str) {
        return d.a(context).g(i10, str);
    }
}
