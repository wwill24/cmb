package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class zzau extends Lambda implements Function2 {
    final /* synthetic */ zzba zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(zzba zzba, String str, int i10) {
        super(2);
        this.zza = zzba;
        this.zzb = str;
        this.zzc = i10;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        this.zza.zzv(this.zzb, (String) obj2);
        int i10 = this.zzc;
        if (i10 != -1) {
            this.zza.zzb().zzb().zzf(i10, objArr);
        }
        return Unit.f32013a;
    }
}
