package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.List;
import java.util.Timer;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

public final class zzao implements zzaj {
    public static final zzak zza = new zzak((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static Timer zzb;
    private final zzap zzc;
    /* access modifiers changed from: private */
    public final k0 zzd;
    /* access modifiers changed from: private */
    public final zzad zze;

    public /* synthetic */ zzao(Context context, zzap zzap, k0 k0Var, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        k0 zza2 = zzp.zza();
        this.zzc = zzap;
        this.zzd = zza2;
        zzad zzc2 = zzad.zzb;
        zzc2 = zzc2 == null ? new zzad(context, (DefaultConstructorMarker) null) : zzc2;
        zzad.zzb = zzc2;
        this.zze = zzc2;
        zzh();
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        for (List<zzae> list : CollectionsKt___CollectionsKt.C0(this.zze.zzd(), 20, 20, true)) {
            zzkz zzf = zzla.zzf();
            for (zzae zzc2 : list) {
                zzf.zzd(zzkx.zzG(zzeb.zzg().zzj(zzc2.zzc())));
            }
            if (this.zzc.zza(((zzla) zzf.zzj()).zzd())) {
                for (zzae zzf2 : list) {
                    this.zze.zzf(zzf2);
                }
            }
        }
    }

    private final void zzh() {
        if (zzb == null) {
            Timer timer = new Timer();
            zzb = timer;
            timer.schedule(new zzal(this), 120000, 120000);
        }
    }

    public final void zzf(zzkx zzkx) {
        s1 unused = j.d(this.zzd, (CoroutineContext) null, (CoroutineStart) null, new zzan(zzkx, this, (c) null), 3, (Object) null);
        zzh();
    }
}
