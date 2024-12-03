package com.google.android.gms.internal.mlkit_vision_text_common;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class zzog {
    private static zzbm zza;
    private static final zzbo zzb = zzbo.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzc;
    private final String zzd;
    private final zzof zze;
    private final m zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzog(Context context, m mVar, zzof zzof, String str) {
        int i10;
        this.zzc = context.getPackageName();
        this.zzd = c.a(context);
        this.zzf = mVar;
        this.zze = zzof;
        zzos.zza();
        this.zzi = str;
        this.zzg = g.a().b(new zznz(this));
        g a10 = g.a();
        mVar.getClass();
        this.zzh = a10.b(new zzoa(mVar));
        zzbo zzbo = zzb;
        if (zzbo.containsKey(str)) {
            i10 = DynamiteModule.b(context, (String) zzbo.get(str));
        } else {
            i10 = -1;
        }
        this.zzj = i10;
    }

    static long zza(List list, double d10) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d10 / 100.0d) * ((double) list.size()))) - 1, 0))).longValue();
    }

    @NonNull
    private static synchronized zzbm zzi() {
        synchronized (zzog.class) {
            zzbm zzbm = zza;
            if (zzbm != null) {
                return zzbm;
            }
            j a10 = f.a(Resources.getSystem().getConfiguration());
            zzbj zzbj = new zzbj();
            for (int i10 = 0; i10 < a10.f(); i10++) {
                zzbj.zzb(c.b(a10.c(i10)));
            }
            zzbm zzc2 = zzbj.zzc();
            zza = zzc2;
            return zzc2;
        }
    }

    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return com.google.android.gms.common.internal.m.a().b(this.zzi);
    }

    private final boolean zzk(zzkt zzkt, long j10, long j11) {
        if (this.zzk.get(zzkt) != null && j10 - ((Long) this.zzk.get(zzkt)).longValue() <= TimeUnit.SECONDS.toMillis(30)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzb() throws Exception {
        return com.google.android.gms.common.internal.m.a().b(this.zzi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zznv zznv, zzkt zzkt, String str) {
        String str2;
        zznv.zzb(zzkt);
        String zzd2 = zznv.zzd();
        zzmw zzmw = new zzmw();
        zzmw.zzb(this.zzc);
        zzmw.zzc(this.zzd);
        zzmw.zzh(zzi());
        zzmw.zzg(Boolean.TRUE);
        zzmw.zzl(zzd2);
        zzmw.zzj(str);
        if (this.zzh.isSuccessful()) {
            str2 = (String) this.zzh.getResult();
        } else {
            str2 = this.zzf.a();
        }
        zzmw.zzi(str2);
        zzmw.zzd(10);
        zzmw.zzk(Integer.valueOf(this.zzj));
        zznv.zzc(zzmw);
        this.zze.zza(zznv);
    }

    public final void zzd(zznv zznv, zzkt zzkt) {
        zze(zznv, zzkt, zzj());
    }

    public final void zze(zznv zznv, zzkt zzkt, String str) {
        g.d().execute(new zzob(this, zznv, zzkt, str));
    }

    public final void zzf(zzoe zzoe, zzkt zzkt) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzkt, elapsedRealtime, 30)) {
            this.zzk.put(zzkt, Long.valueOf(elapsedRealtime));
            zze(zzoe.zza(), zzkt, zzj());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzkt zzkt, com.google.mlkit.vision.text.internal.m mVar) {
        zzbr zzbr = (zzbr) this.zzl.get(zzkt);
        if (zzbr != null) {
            for (Object next : zzbr.zzq()) {
                ArrayList<Long> arrayList = new ArrayList<>(zzbr.zzc(next));
                Collections.sort(arrayList);
                zzjz zzjz = new zzjz();
                long j10 = 0;
                for (Long longValue : arrayList) {
                    j10 += longValue.longValue();
                }
                zzjz.zza(Long.valueOf(j10 / ((long) arrayList.size())));
                zzjz.zzc(Long.valueOf(zza(arrayList, 100.0d)));
                zzjz.zzf(Long.valueOf(zza(arrayList, 75.0d)));
                zzjz.zzd(Long.valueOf(zza(arrayList, 50.0d)));
                zzjz.zzb(Long.valueOf(zza(arrayList, 25.0d)));
                zzjz.zze(Long.valueOf(zza(arrayList, 0.0d)));
                zze(mVar.a(next, arrayList.size(), zzjz.zzg()), zzkt, zzj());
            }
            this.zzl.remove(zzkt);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(zzkt zzkt, Object obj, long j10, com.google.mlkit.vision.text.internal.m mVar) {
        if (!this.zzl.containsKey(zzkt)) {
            this.zzl.put(zzkt, zzar.zzr());
        }
        ((zzbr) this.zzl.get(zzkt)).zzo(obj, Long.valueOf(j10));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzkt, elapsedRealtime, 30)) {
            this.zzk.put(zzkt, Long.valueOf(elapsedRealtime));
            g.d().execute(new zzod(this, zzkt, mVar, (byte[]) null));
        }
    }
}
