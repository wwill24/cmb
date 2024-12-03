package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import ud.b;

final class zzab extends c implements zzg {
    private static final a.g zza;
    private static final a.C0480a zzb;
    private static final a zzc;
    private static final he.a zzd = ud.a.a("GoogleAuthServiceClient");
    private final Context zze;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzv zzv = new zzv();
        zzb = zzv;
        zzc = new a("GoogleAuthService.API", zzv, gVar);
    }

    zzab(@NonNull Context context) {
        super(context, zzc, a.d.f38515i, c.a.f38516c);
        this.zze = context;
    }

    static /* bridge */ /* synthetic */ void zzf(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (!w.c(status, obj, taskCompletionSource)) {
            zzd.h("The task is already complete.", new Object[0]);
        }
    }

    public final Task zza(zzbw zzbw) {
        return doWrite(v.a().d(b.f42035j).b(new zzt(this, zzbw)).e(1513).a());
    }

    public final Task zzb(@NonNull AccountChangeEventsRequest accountChangeEventsRequest) {
        p.l(accountChangeEventsRequest, "request cannot be null.");
        return doWrite(v.a().d(b.f42034i).b(new zzu(this, accountChangeEventsRequest)).e(1515).a());
    }

    public final Task zzc(@NonNull Account account, @NonNull String str, Bundle bundle) {
        p.l(account, "Account name cannot be null!");
        p.h(str, "Scope cannot be null!");
        return doWrite(v.a().d(b.f42035j).b(new zzs(this, account, str, bundle)).e(1512).a());
    }

    public final Task zzd(@NonNull Account account) {
        p.l(account, "account cannot be null.");
        return doWrite(v.a().d(b.f42034i).b(new zzr(this, account)).e(1517).a());
    }

    public final Task zze(@NonNull String str) {
        p.l(str, "Client package name cannot be null!");
        return doWrite(v.a().d(b.f42034i).b(new zzq(this, str)).e(1514).a());
    }
}
