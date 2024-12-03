package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.h0;
import com.google.android.gms.location.n;
import com.google.android.gms.location.zzb;
import com.google.android.gms.tasks.Task;

public final class zzag extends c {
    static final a.g zza;
    public static final a zzb;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzb = new a("ActivityRecognition.API", new zzad(), gVar);
    }

    public zzag(Activity activity) {
        super(activity, zzb, a.d.f38515i, c.a.f38516c);
    }

    public final Task<Void> removeActivityTransitionUpdates(PendingIntent pendingIntent) {
        return doWrite(v.a().b(new zzx(pendingIntent)).e(2406).a());
    }

    public final Task<Void> removeActivityUpdates(PendingIntent pendingIntent) {
        return doWrite(v.a().b(new zzy(pendingIntent)).e(2402).a());
    }

    public final Task<Void> removeSleepSegmentUpdates(PendingIntent pendingIntent) {
        return doWrite(v.a().b(new zzab(pendingIntent)).e(2411).a());
    }

    public final Task<Void> requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent) {
        activityTransitionRequest.S(getContextAttributionTag());
        return doWrite(v.a().b(new zzaa(activityTransitionRequest, pendingIntent)).e(2405).a());
    }

    public final Task<Void> requestActivityUpdates(long j10, PendingIntent pendingIntent) {
        n nVar = new n();
        nVar.a(j10);
        zzb b10 = nVar.b();
        b10.S(getContextAttributionTag());
        return doWrite(v.a().b(new zzz(b10, pendingIntent)).e(2401).a());
    }

    public final Task<Void> requestSleepSegmentUpdates(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest) {
        p.l(pendingIntent, "PendingIntent must be specified.");
        return doRead(v.a().b(new zzac(this, pendingIntent, sleepSegmentRequest)).d(h0.f39582b).e(2410).a());
    }

    public zzag(Context context) {
        super(context, zzb, a.d.f38515i, c.a.f38516c);
    }
}
