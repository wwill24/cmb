package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.location.b;

public final class zzw implements b {
    public final f<Status> removeActivityUpdates(d dVar, PendingIntent pendingIntent) {
        return dVar.h(new zzu(this, dVar, pendingIntent));
    }

    public final f<Status> requestActivityUpdates(d dVar, long j10, PendingIntent pendingIntent) {
        return dVar.h(new zzt(this, dVar, j10, pendingIntent));
    }
}
