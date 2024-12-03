package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.location.f;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzci extends zzl {
    final /* synthetic */ TaskCompletionSource zza;

    zzci(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(int i10, String[] strArr) {
        w.a(new Status(f.b(i10)), this.zza);
    }

    public final void zzc(int i10, PendingIntent pendingIntent) {
        w.a(new Status(f.b(i10)), this.zza);
    }

    public final void zzd(int i10, String[] strArr) {
        w.a(new Status(f.b(i10)), this.zza);
    }
}
