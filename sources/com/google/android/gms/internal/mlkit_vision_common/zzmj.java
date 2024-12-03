package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.os.f;
import androidx.core.os.j;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.c;
import com.google.mlkit.common.sdkinternal.g;
import com.google.mlkit.common.sdkinternal.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class zzmj {
    private static zzp zza;
    private static final zzr zzb = zzr.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzc;
    private final String zzd;
    private final zzmc zze;
    private final m zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzmj(Context context, m mVar, zzmc zzmc, String str) {
        int i10;
        this.zzc = context.getPackageName();
        this.zzd = c.a(context);
        this.zzf = mVar;
        this.zze = zzmc;
        zzmw.zza();
        this.zzi = str;
        this.zzg = g.a().b(new zzmg(this));
        g a10 = g.a();
        mVar.getClass();
        this.zzh = a10.b(new zzmh(mVar));
        zzr zzr = zzb;
        if (zzr.containsKey(str)) {
            i10 = DynamiteModule.b(context, (String) zzr.get(str));
        } else {
            i10 = -1;
        }
        this.zzj = i10;
    }

    @NonNull
    private static synchronized zzp zzd() {
        synchronized (zzmj.class) {
            zzp zzp = zza;
            if (zzp != null) {
                return zzp;
            }
            j a10 = f.a(Resources.getSystem().getConfiguration());
            zzm zzm = new zzm();
            for (int i10 = 0; i10 < a10.f(); i10++) {
                zzm.zzb(c.b(a10.c(i10)));
            }
            zzp zzc2 = zzm.zzc();
            zza = zzc2;
            return zzc2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zza() throws Exception {
        return com.google.android.gms.common.internal.m.a().b(this.zzi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzmb zzmb, zziv zziv, String str) {
        String str2;
        zzmb.zza(zziv);
        String zzc2 = zzmb.zzc();
        zzky zzky = new zzky();
        zzky.zzb(this.zzc);
        zzky.zzc(this.zzd);
        zzky.zzh(zzd());
        zzky.zzg(Boolean.TRUE);
        zzky.zzl(zzc2);
        zzky.zzj(str);
        if (this.zzh.isSuccessful()) {
            str2 = (String) this.zzh.getResult();
        } else {
            str2 = this.zzf.a();
        }
        zzky.zzi(str2);
        zzky.zzd(10);
        zzky.zzk(Integer.valueOf(this.zzj));
        zzmb.zzb(zzky);
        this.zze.zza(zzmb);
    }

    public final void zzc(zzmt zzmt, zziv zziv) {
        zzii zzii;
        zzio zzio;
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzk.get(zziv) == null || elapsedRealtime - ((Long) this.zzk.get(zziv)).longValue() > TimeUnit.SECONDS.toMillis(30)) {
            this.zzk.put(zziv, Long.valueOf(elapsedRealtime));
            int i10 = zzmt.zza;
            int i11 = zzmt.zzb;
            int i12 = zzmt.zzc;
            int i13 = zzmt.zzd;
            int i14 = zzmt.zze;
            long j10 = zzmt.zzf;
            int i15 = zzmt.zzg;
            zzin zzin = new zzin();
            if (i10 == -1) {
                zzii = zzii.BITMAP;
            } else if (i10 == 35) {
                zzii = zzii.YUV_420_888;
            } else if (i10 == 842094169) {
                zzii = zzii.YV12;
            } else if (i10 == 16) {
                zzii = zzii.NV16;
            } else if (i10 != 17) {
                zzii = zzii.UNKNOWN_FORMAT;
            } else {
                zzii = zzii.NV21;
            }
            zzin.zzd(zzii);
            if (i11 == 1) {
                zzio = zzio.BITMAP;
            } else if (i11 == 2) {
                zzio = zzio.BYTEARRAY;
            } else if (i11 == 3) {
                zzio = zzio.BYTEBUFFER;
            } else if (i11 != 4) {
                zzio = zzio.ANDROID_MEDIA_IMAGE;
            } else {
                zzio = zzio.FILEPATH;
            }
            zzin.zzf(zzio);
            zzin.zzc(Integer.valueOf(i12));
            zzin.zze(Integer.valueOf(i13));
            zzin.zzg(Integer.valueOf(i14));
            zzin.zzb(Long.valueOf(j10));
            zzin.zzh(Integer.valueOf(i15));
            zziq zzj2 = zzin.zzj();
            zziw zziw = new zziw();
            zziw.zzd(zzj2);
            zzmb zze2 = zzmk.zze(zziw);
            if (this.zzg.isSuccessful()) {
                str = (String) this.zzg.getResult();
            } else {
                str = com.google.android.gms.common.internal.m.a().b(this.zzi);
            }
            g.d().execute(new zzmi(this, zze2, zziv, str));
        }
    }
}
