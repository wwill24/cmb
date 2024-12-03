package com.google.android.recaptcha.internal;

import android.webkit.JavascriptInterface;
import gk.g;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.n;

public final class zzcu {
    final /* synthetic */ zzda zza;
    private Long zzb;
    private final zzdk zzc = zzdk.zzb();

    public zzcu(zzda zzda) {
        this.zza = zzda;
    }

    private final void zzb() {
        if (this.zzb == null) {
            this.zzc.zzf();
            this.zzb = Long.valueOf(this.zzc.zza(TimeUnit.MILLISECONDS));
        }
    }

    public final Long zza() {
        return this.zzb;
    }

    @JavascriptInterface
    public final void zzoed(String str) {
        zzb();
        zzlz zzg = zzlz.zzg(zzeb.zzh().zzj(str));
        zzg.zzi().name();
        zzg.zzk();
        n nVar = (n) this.zza.zzk.remove(zzg.zzj());
        String zzk = zzg.zzk();
        if (zzk == null || zzk.length() == 0) {
            zzg.zzi().name();
            zzg zzg2 = zzh.zza;
            zzh zza2 = zzg.zza(zzg.zzi());
            zzg.zzj();
            if (nVar != null) {
                Result.a aVar = Result.f32010a;
                nVar.resumeWith(Result.b(g.a(zza2)));
            }
        } else if (nVar != null) {
            nVar.resumeWith(Result.b(zzg.zzk()));
        }
    }

    @JavascriptInterface
    public final void zzoid(String str) {
        zzb();
        zzmd zzg = zzmd.zzg(zzeb.zzh().zzj(str));
        zzg.zzi().name();
        if (zzg.zzi() == zzmf.JS_CODE_SUCCESS) {
            this.zza.zzm().hashCode();
            if (!this.zza.zzm().L(Unit.f32013a)) {
                this.zza.zzm().hashCode();
                return;
            }
            return;
        }
        zzg.zzi().name();
        zzg zzg2 = zzh.zza;
        zzh zza2 = zzg.zza(zzg.zzi());
        this.zza.zzm().hashCode();
        this.zza.zzm().J(zza2);
    }

    @JavascriptInterface
    public final void zzrp(String str) {
        zzb();
        this.zza.zzd().zza(str);
    }
}
