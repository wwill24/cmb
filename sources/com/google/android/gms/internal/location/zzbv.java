package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.g;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

public final class zzbv implements g {
    static /* bridge */ /* synthetic */ TaskCompletionSource zza(e eVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.getTask().addOnCompleteListener(new zzbq(eVar));
        return taskCompletionSource;
    }

    public final f<Status> addGeofences(d dVar, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return dVar.h(new zzbr(this, dVar, geofencingRequest, pendingIntent));
    }

    public final f<Status> removeGeofences(d dVar, PendingIntent pendingIntent) {
        return dVar.h(new zzbs(this, dVar, pendingIntent));
    }

    @Deprecated
    public final f<Status> addGeofences(d dVar, List<com.google.android.gms.location.e> list, PendingIntent pendingIntent) {
        GeofencingRequest.a aVar = new GeofencingRequest.a();
        aVar.b(list);
        aVar.d(5);
        return dVar.h(new zzbr(this, dVar, aVar.c(), pendingIntent));
    }

    public final f<Status> removeGeofences(d dVar, List<String> list) {
        return dVar.h(new zzbt(this, dVar, list));
    }
}
