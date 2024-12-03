package com.google.android.gms.internal.p001authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzv  reason: invalid package */
public final class zzv extends c<a.d.c> {
    private static final a.g<zzw> zza;
    private static final a.C0480a<zzw, a.d.c> zzb;
    private static final a<a.d.c> zzc;

    static {
        a.g<zzw> gVar = new a.g<>();
        zza = gVar;
        zzt zzt = new zzt();
        zzb = zzt;
        zzc = new a<>("SmsCodeBrowser.API", zzt, gVar);
    }

    public zzv(Activity activity) {
        super(activity, zzc, a.d.f38515i, c.a.f38516c);
    }

    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(v.a().d(zzac.zzb).b(new zzs(this)).e(1566).a());
    }

    public zzv(Context context) {
        super(context, zzc, a.d.f38515i, c.a.f38516c);
    }
}
