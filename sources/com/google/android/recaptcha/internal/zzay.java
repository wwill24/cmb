package com.google.android.recaptcha.internal;

import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

final class zzay extends SuspendLambda implements Function2 {
    final /* synthetic */ Exception zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzn zzc;
    final /* synthetic */ zzn zzd;
    final /* synthetic */ String zze;
    final /* synthetic */ zzba zzf;
    private /* synthetic */ Object zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzay(Exception exc, int i10, zzn zzn, zzn zzn2, String str, zzba zzba, c cVar) {
        super(2, cVar);
        this.zza = exc;
        this.zzb = i10;
        this.zzc = zzn;
        this.zzd = zzn2;
        this.zze = str;
        this.zzf = zzba;
    }

    public final c create(Object obj, c cVar) {
        zzay zzay = new zzay(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, cVar);
        zzay.zzg = obj;
        return zzay;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzay) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        zzmi zzmi;
        Object unused = b.d();
        g.b(obj);
        k0 k0Var = (k0) this.zzg;
        Exception exc = this.zza;
        if (exc instanceof zzt) {
            zzmi = ((zzt) exc).zza();
            zzmi.zzd(this.zzb);
        } else {
            zzmi = zzmj.zzf();
            zzmi.zzd(this.zzb);
            zzmi.zzp(2);
            zzmi.zze(2);
        }
        zzmj zzmj = (zzmj) zzmi.zzj();
        zzmj.zzk();
        zzmj.zzj();
        l.b(this.zza.getClass()).getSimpleName();
        this.zza.getMessage();
        zzlg zza2 = zzar.zza(this.zzc, this.zzd);
        String str = this.zze;
        if (str.length() == 0) {
            str = "recaptcha.m.Main.rge";
        }
        if (l0.i(k0Var)) {
            zzba zzba = this.zzf;
            zzeb zzh = zzeb.zzh();
            byte[] zzd2 = zzmj.zzd();
            zzeb zzh2 = zzeb.zzh();
            byte[] zzd3 = zza2.zzd();
            zzba.zzv(str, zzh.zzi(zzd2, 0, zzd2.length), zzh2.zzi(zzd3, 0, zzd3.length));
        }
        return Unit.f32013a;
    }
}
