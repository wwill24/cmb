package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.tasks.Task;
import java.util.List;

public final class zzbz extends c {
    public static final /* synthetic */ int zza = 0;

    public zzbz(@NonNull Activity activity) {
        super(activity, zzbp.zzb, a.d.f38515i, c.a.f38516c);
    }

    public final Task<Void> addGeofences(GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return doWrite(v.a().b(new zzbw(geofencingRequest.Y(getContextAttributionTag()), pendingIntent)).e(2424).a());
    }

    public final Task<Void> removeGeofences(PendingIntent pendingIntent) {
        return doWrite(v.a().b(new zzby(pendingIntent)).e(2425).a());
    }

    public zzbz(@NonNull Context context) {
        super(context, zzbp.zzb, a.d.f38515i, c.a.f38516c);
    }

    public final Task<Void> removeGeofences(List<String> list) {
        return doWrite(v.a().b(new zzbx(list)).e(2425).a());
    }
}
