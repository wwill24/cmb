package com.google.android.gms.internal.p001authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzr  reason: invalid package */
public final class zzr extends c<a.d.c> {
    private static final a.g<zzw> zza;
    private static final a.C0480a<zzw, a.d.c> zzb;
    private static final a<a.d.c> zzc;

    static {
        a.g<zzw> gVar = new a.g<>();
        zza = gVar;
        zzn zzn = new zzn();
        zzb = zzn;
        zzc = new a<>("SmsCodeAutofill.API", zzn, gVar);
    }

    public zzr(Activity activity) {
        super(activity, zzc, a.d.f38515i, c.a.f38516c);
    }

    public final Task<Integer> checkPermissionState() {
        return doRead(v.a().d(zzac.zza).b(new zzk(this)).e(1564).a());
    }

    public final Task<Boolean> hasOngoingSmsRequest(String str) {
        p.k(str);
        p.b(!str.isEmpty(), "The package name cannot be empty.");
        return doRead(v.a().d(zzac.zza).b(new zzm(this, str)).e(1565).a());
    }

    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(v.a().d(zzac.zza).b(new zzl(this)).e(1563).a());
    }

    public zzr(Context context) {
        super(context, zzc, a.d.f38515i, c.a.f38516c);
    }
}
