package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import gk.g;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

final class zzy extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzaa zzb;
    final /* synthetic */ RecaptchaAction zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzy(zzaa zzaa, RecaptchaAction recaptchaAction, c cVar) {
        super(2, cVar);
        this.zzb = zzaa;
        this.zzc = recaptchaAction;
    }

    public final c create(Object obj, c cVar) {
        return new zzy(this.zzb, this.zzc, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzy) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object d10 = b.d();
        int i10 = this.zza;
        g.b(obj);
        if (i10 != 0) {
            obj2 = ((Result) obj).j();
        } else {
            zzda zzb2 = this.zzb.zzb();
            RecaptchaAction recaptchaAction = this.zzc;
            this.zza = 1;
            obj2 = zzb2.zzf(recaptchaAction, this);
            if (obj2 == d10) {
                return d10;
            }
        }
        return Result.a(obj2);
    }
}
