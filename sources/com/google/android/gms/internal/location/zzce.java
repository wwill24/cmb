package com.google.android.gms.internal.location;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.k;
import com.google.android.gms.location.m;
import com.google.android.gms.tasks.Task;

public final class zzce extends c implements m {
    public static final /* synthetic */ int zza = 0;

    public zzce(@NonNull Activity activity) {
        super(activity, zzbp.zzb, a.d.f38515i, c.a.f38516c);
    }

    public final Task<k> checkLocationSettings(LocationSettingsRequest locationSettingsRequest) {
        return doRead(v.a().b(new zzcd(locationSettingsRequest)).e(2426).a());
    }

    public zzce(@NonNull Context context) {
        super(context, zzbp.zzb, a.d.f38515i, c.a.f38516c);
    }
}
