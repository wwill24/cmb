package com.google.android.gms.internal.p003firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.j;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeq  reason: invalid package */
final class zzaeq extends LifecycleCallback {
    private final List zza;

    private zzaeq(j jVar, List list) {
        super(jVar);
        this.mLifecycleFragment.p("PhoneAuthActivityStopCallback", this);
        this.zza = list;
    }

    public static void zza(Activity activity, List list) {
        j fragment = LifecycleCallback.getFragment(activity);
        if (((zzaeq) fragment.y("PhoneAuthActivityStopCallback", zzaeq.class)) == null) {
            new zzaeq(fragment, list);
        }
    }

    public final void onStop() {
        synchronized (this.zza) {
            this.zza.clear();
        }
    }
}
