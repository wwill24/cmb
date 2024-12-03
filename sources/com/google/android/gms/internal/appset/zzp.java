package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.d;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import td.b;
import td.f;

public final class zzp extends c<a.d.c> implements b {
    private static final a.g<zzd> zza;
    private static final a.C0480a<zzd, a.d.c> zzb;
    private static final a<a.d.c> zzc;
    private final Context zzd;
    private final d zze;

    static {
        a.g<zzd> gVar = new a.g<>();
        zza = gVar;
        zzn zzn = new zzn();
        zzb = zzn;
        zzc = new a<>("AppSet.API", zzn, gVar);
    }

    zzp(Context context, d dVar) {
        super(context, zzc, a.d.f38515i, c.a.f38516c);
        this.zzd = context;
        this.zze = dVar;
    }

    public final Task<td.c> getAppSetIdInfo() {
        if (this.zze.j(this.zzd, 212800000) != 0) {
            return Tasks.forException(new ApiException(new Status(17)));
        }
        return doRead(v.a().d(f.f41947a).b(new zzm(this)).c(false).e(27601).a());
    }
}
