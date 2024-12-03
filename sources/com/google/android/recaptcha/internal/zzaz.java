package com.google.android.recaptcha.internal;

import gk.g;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

final class zzaz extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzba zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzn zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaz(zzba zzba, String str, zzn zzn, c cVar) {
        super(2, cVar);
        this.zzc = zzba;
        this.zzd = str;
        this.zze = zzn;
    }

    public final c create(Object obj, c cVar) {
        return new zzaz(this.zzc, this.zzd, this.zze, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzaz) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object d10 = b.d();
        int i10 = this.zzb;
        if (i10 == 0) {
            g.b(obj);
            zzn zzn = new zzn();
            zzmp zzg = zzmp.zzg(zzeb.zzh().zzj(this.zzd));
            obj2 = zzn;
            zzdk zzb2 = zzdk.zzb();
            zzmh zzc2 = zzba.zzy(zzg.zzi(), zzg.zzj());
            zzb2.zzf();
            long zza2 = zzb2.zza(TimeUnit.MICROSECONDS);
            zzj zzj = zzj.zza;
            zzj.zza(zzl.zzm.zza(), zza2);
            zzba zzba = this.zzc;
            List zzi = zzc2.zzi();
            zzn zzn2 = this.zze;
            this.zza = zzn;
            this.zzb = 1;
            if (zzba.zzt(zzi, zzn2, zzn, this) == d10) {
                return d10;
            }
        } else if (i10 != 1) {
            g.b(obj);
        } else {
            Object obj3 = this.zza;
            try {
                obj2 = obj3;
                g.b(obj);
                obj2 = obj3;
            } catch (Exception e10) {
                zzba zzba2 = this.zzc;
                zzn zzn3 = this.zze;
                this.zza = null;
                this.zzb = 2;
                if (zzba2.zzu(e10, "recaptcha.m.Main.rge", zzn3, (zzn) obj2, 0, this) == d10) {
                    return d10;
                }
            }
        }
        return Unit.f32013a;
    }
}
