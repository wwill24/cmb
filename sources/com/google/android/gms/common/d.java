package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.u1;
import com.google.android.gms.internal.common.zzd;
import me.j;
import org.apache.commons.cli.HelpFormatter;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f38874a = e.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* renamed from: b  reason: collision with root package name */
    private static final d f38875b = new d();

    d() {
    }

    @NonNull
    public static d h() {
        return f38875b;
    }

    public void a(@NonNull Context context) {
        e.cancelAvailabilityErrorNotifications(context);
    }

    public int b(@NonNull Context context) {
        return e.getApkVersion(context);
    }

    @Deprecated
    public Intent c(int i10) {
        return d((Context) null, i10, (String) null);
    }

    public Intent d(Context context, int i10, String str) {
        if (i10 == 1 || i10 == 2) {
            if (context != null && j.e(context)) {
                return u1.a();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("gcore_");
            sb2.append(f38874a);
            sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            if (!TextUtils.isEmpty(str)) {
                sb2.append(str);
            }
            sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            if (context != null) {
                sb2.append(context.getPackageName());
            }
            sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            if (context != null) {
                try {
                    sb2.append(oe.d.a(context).e(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return u1.b("com.google.android.gms", sb2.toString());
        } else if (i10 != 3) {
            return null;
        } else {
            return u1.c("com.google.android.gms");
        }
    }

    public PendingIntent e(@NonNull Context context, int i10, int i11) {
        return f(context, i10, i11, (String) null);
    }

    public PendingIntent f(@NonNull Context context, int i10, int i11, String str) {
        Intent d10 = d(context, i10, str);
        if (d10 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i11, d10, zzd.zza | 134217728);
    }

    @NonNull
    public String g(int i10) {
        return e.getErrorString(i10);
    }

    public int i(@NonNull Context context) {
        return j(context, f38874a);
    }

    public int j(@NonNull Context context, int i10) {
        int isGooglePlayServicesAvailable = e.isGooglePlayServicesAvailable(context, i10);
        if (e.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    public boolean k(@NonNull Context context, int i10) {
        return e.isPlayServicesPossiblyUpdating(context, i10);
    }

    public boolean l(@NonNull Context context, @NonNull String str) {
        return e.zza(context, str);
    }

    public boolean m(int i10) {
        return e.isUserRecoverableError(i10);
    }
}
