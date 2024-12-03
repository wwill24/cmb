package com.google.android.recaptcha.internal;

import gk.g;
import java.util.Timer;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

final class zzam extends SuspendLambda implements Function2 {
    final /* synthetic */ zzao zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzao zzao, c cVar) {
        super(2, cVar);
        this.zza = zzao;
    }

    public final c create(Object obj, c cVar) {
        return new zzam(this.zza, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzam) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        g.b(obj);
        zzao zzao = this.zza;
        synchronized (zzaj.class) {
            if (zzao.zze.zzb() == 0) {
                Timer zzb = zzao.zzb;
                if (zzb != null) {
                    zzb.cancel();
                }
                zzao.zzb = null;
            }
            zzao.zzg();
        }
        return Unit.f32013a;
    }
}
