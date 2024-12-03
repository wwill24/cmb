package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

final class zzv extends LifecycleCallback {
    private final List zza = new ArrayList();

    private zzv(j jVar) {
        super(jVar);
        this.mLifecycleFragment.p("TaskOnStopCallback", this);
    }

    public static zzv zza(Activity activity) {
        j fragment = LifecycleCallback.getFragment(activity);
        zzv zzv = (zzv) fragment.y("TaskOnStopCallback", zzv.class);
        if (zzv == null) {
            return new zzv(fragment);
        }
        return zzv;
    }

    public final void onStop() {
        synchronized (this.zza) {
            for (WeakReference weakReference : this.zza) {
                zzq zzq = (zzq) weakReference.get();
                if (zzq != null) {
                    zzq.zzc();
                }
            }
            this.zza.clear();
        }
    }

    public final void zzb(zzq zzq) {
        synchronized (this.zza) {
            this.zza.add(new WeakReference(zzq));
        }
    }
}
