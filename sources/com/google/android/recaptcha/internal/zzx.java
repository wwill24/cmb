package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

final class zzx extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaa zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzx(zzaa zzaa, c cVar) {
        super(cVar);
        this.zzb = zzaa;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r22 = this.zzb.m2executegIAlus((RecaptchaAction) null, this);
        return r22 == b.d() ? r22 : Result.a(r22);
    }
}
