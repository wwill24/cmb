package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.core.app.p;
import androidx.fragment.app.h;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.r1;
import com.google.android.gms.common.api.internal.s1;
import com.google.android.gms.common.internal.a0;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import com.google.errorprone.annotations.RestrictedInheritance;
import de.a;
import de.b;
import me.j;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {zad.class, zae.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
public class c extends d {

    /* renamed from: d  reason: collision with root package name */
    public static final int f38865d = d.f38874a;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f38866e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static final c f38867f = new c();

    /* renamed from: c  reason: collision with root package name */
    private String f38868c;

    @NonNull
    public static c p() {
        return f38867f;
    }

    public Intent d(Context context, int i10, String str) {
        return super.d(context, i10, str);
    }

    public PendingIntent e(@NonNull Context context, int i10, int i11) {
        return super.e(context, i10, i11);
    }

    @NonNull
    public final String g(int i10) {
        return super.g(i10);
    }

    public int i(@NonNull Context context) {
        return super.i(context);
    }

    public int j(@NonNull Context context, int i10) {
        return super.j(context, i10);
    }

    public final boolean m(int i10) {
        return super.m(i10);
    }

    public Dialog n(@NonNull Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        return s(activity, i10, e0.b(activity, d(activity, i10, "d"), i11), onCancelListener);
    }

    public PendingIntent o(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        if (connectionResult.f0()) {
            return connectionResult.c0();
        }
        return e(context, connectionResult.S(), 0);
    }

    public boolean q(@NonNull Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog n10 = n(activity, i10, i11, onCancelListener);
        if (n10 == null) {
            return false;
        }
        v(activity, n10, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public void r(@NonNull Context context, int i10) {
        w(context, i10, (String) null, f(context, i10, 0, "n"));
    }

    /* access modifiers changed from: package-private */
    public final Dialog s(@NonNull Context context, int i10, e0 e0Var, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(a0.d(context, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c10 = a0.c(context, i10);
        if (c10 != null) {
            builder.setPositiveButton(c10, e0Var);
        }
        String g10 = a0.g(context, i10);
        if (g10 != null) {
            builder.setTitle(g10);
        }
        String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[]{Integer.valueOf(i10)});
        new IllegalArgumentException();
        return builder.create();
    }

    @NonNull
    public final Dialog t(@NonNull Activity activity, @NonNull DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(a0.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        v(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final s1 u(Context context, r1 r1Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        s1 s1Var = new s1(r1Var);
        zao.zaa(context, s1Var, intentFilter);
        s1Var.a(context);
        if (l(context, "com.google.android.gms")) {
            return s1Var;
        }
        r1Var.a();
        s1Var.b();
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void v(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof h) {
                h.z0(dialog, onCancelListener).show(((h) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* access modifiers changed from: package-private */
    @TargetApi(20)
    public final void w(Context context, int i10, String str, PendingIntent pendingIntent) {
        int i11;
        String str2;
        String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i10), null});
        new IllegalArgumentException();
        if (i10 == 18) {
            x(context);
        } else if (pendingIntent != null) {
            String f10 = a0.f(context, i10);
            String e10 = a0.e(context, i10);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) p.k(context.getSystemService("notification"));
            p.e z10 = new p.e(context).s(true).f(true).m(f10).z(new p.c().h(e10));
            if (j.d(context)) {
                com.google.android.gms.common.internal.p.o(me.p.e());
                z10.x(context.getApplicationInfo().icon).v(2);
                if (j.e(context)) {
                    z10.a(a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent);
                } else {
                    z10.k(pendingIntent);
                }
            } else {
                z10.x(17301642).B(resources.getString(b.common_google_play_services_notification_ticker)).E(System.currentTimeMillis()).k(pendingIntent).l(e10);
            }
            if (me.p.h()) {
                com.google.android.gms.common.internal.p.o(me.p.h());
                synchronized (f38866e) {
                    str2 = this.f38868c;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    NotificationChannel a10 = notificationManager.getNotificationChannel(str2);
                    String b10 = a0.b(context);
                    if (a10 == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(str2, b10, 4));
                    } else if (!b10.contentEquals(a10.getName())) {
                        a10.setName(b10);
                        notificationManager.createNotificationChannel(a10);
                    }
                }
                z10.h(str2);
            }
            Notification b11 = z10.b();
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                e.sCanceledAvailabilityNotification.set(false);
                i11 = 10436;
            } else {
                i11 = 39789;
            }
            notificationManager.notify(i11, b11);
        }
    }

    /* access modifiers changed from: package-private */
    public final void x(Context context) {
        new i(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public final boolean y(@NonNull Activity activity, @NonNull com.google.android.gms.common.api.internal.j jVar, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog s10 = s(activity, i10, e0.d(jVar, d(activity, i10, "d"), 2), onCancelListener);
        if (s10 == null) {
            return false;
        }
        v(activity, s10, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public final boolean z(@NonNull Context context, @NonNull ConnectionResult connectionResult, int i10) {
        PendingIntent o10;
        if (oe.a.a(context) || (o10 = o(context, connectionResult)) == null) {
            return false;
        }
        w(context, connectionResult.S(), (String) null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, o10, i10, true), zap.zaa | 134217728));
        return true;
    }
}
