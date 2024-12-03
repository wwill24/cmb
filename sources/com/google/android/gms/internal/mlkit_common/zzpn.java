package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.core.os.f;
import androidx.core.os.j;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.c;
import com.google.mlkit.common.sdkinternal.g;
import com.google.mlkit.common.sdkinternal.m;
import java.util.HashMap;
import java.util.Map;
import tg.b;

public final class zzpn {
    private static zzar zza;
    private static final zzau zzb = zzau.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzc;
    private final String zzd;
    private final zzpf zze;
    private final m zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzpn(Context context, m mVar, zzpf zzpf, String str) {
        int i10;
        this.zzc = context.getPackageName();
        this.zzd = c.a(context);
        this.zzf = mVar;
        this.zze = zzpf;
        zzqb.zza();
        this.zzi = str;
        this.zzg = g.a().b(new zzpj(this));
        g a10 = g.a();
        mVar.getClass();
        this.zzh = a10.b(new zzpk(mVar));
        zzau zzau = zzb;
        if (zzau.containsKey(str)) {
            i10 = DynamiteModule.b(context, (String) zzau.get(str));
        } else {
            i10 = -1;
        }
        this.zzj = i10;
    }

    @NonNull
    private static synchronized zzar zzh() {
        synchronized (zzpn.class) {
            zzar zzar = zza;
            if (zzar != null) {
                return zzar;
            }
            j a10 = f.a(Resources.getSystem().getConfiguration());
            zzao zzao = new zzao();
            for (int i10 = 0; i10 < a10.f(); i10++) {
                zzao.zzb(c.b(a10.c(i10)));
            }
            zzar zzc2 = zzao.zzc();
            zza = zzc2;
            return zzc2;
        }
    }

    private final zznz zzi(String str, String str2) {
        String str3;
        zznz zznz = new zznz();
        zznz.zzb(this.zzc);
        zznz.zzc(this.zzd);
        zznz.zzh(zzh());
        zznz.zzg(Boolean.TRUE);
        zznz.zzl(str);
        zznz.zzj(str2);
        if (this.zzh.isSuccessful()) {
            str3 = (String) this.zzh.getResult();
        } else {
            str3 = this.zzf.a();
        }
        zznz.zzi(str3);
        zznz.zzd(10);
        zznz.zzk(Integer.valueOf(this.zzj));
        return zznz;
    }

    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return com.google.android.gms.common.internal.m.a().b(this.zzi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zza() throws Exception {
        return com.google.android.gms.common.internal.m.a().b(this.zzi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzpe zzpe, zzld zzld, String str) {
        zzpe.zza(zzld);
        zzpe.zzc(zzi(zzpe.zzd(), str));
        this.zze.zza(zzpe);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzpe zzpe, zzpp zzpp, b bVar) {
        zzpe.zza(zzld.MODEL_DOWNLOAD);
        zzpe.zzc(zzi(zzpp.zze(), zzj()));
        zzpe.zzb(zzpz.zza(bVar, this.zzf, zzpp));
        this.zze.zza(zzpe);
    }

    public final void zzd(zzpe zzpe, zzld zzld) {
        g.d().execute(new zzpl(this, zzpe, zzld, zzj()));
    }

    public final void zze(zzpe zzpe, b bVar, boolean z10, int i10) {
        zzpo zzh2 = zzpp.zzh();
        zzh2.zzf(false);
        zzh2.zzd(bVar.c());
        zzh2.zza(zzli.FAILED);
        zzh2.zzb(zzlc.DOWNLOAD_FAILED);
        zzh2.zzc(i10);
        zzg(zzpe, bVar, zzh2.zzh());
    }

    public final void zzf(zzpe zzpe, b bVar, zzlc zzlc, boolean z10, ModelType modelType, zzli zzli) {
        zzpo zzh2 = zzpp.zzh();
        zzh2.zzf(z10);
        zzh2.zzd(modelType);
        zzh2.zzb(zzlc);
        zzh2.zza(zzli);
        zzg(zzpe, bVar, zzh2.zzh());
    }

    public final void zzg(zzpe zzpe, b bVar, zzpp zzpp) {
        g.d().execute(new zzpm(this, zzpe, zzpp, bVar));
    }
}
