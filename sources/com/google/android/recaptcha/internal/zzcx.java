package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

final class zzcx extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzda zzb;
    int zzc;
    zzda zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcx(zzda zzda, c cVar) {
        super(cVar);
        this.zzb = zzda;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzg = this.zzb.zzg(this);
        return zzg == b.d() ? zzg : Result.a(zzg);
    }
}
