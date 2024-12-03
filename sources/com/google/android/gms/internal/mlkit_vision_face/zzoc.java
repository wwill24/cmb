package com.google.android.gms.internal.mlkit_vision_face;

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

public final class zzoc {
    private static zzbn zza;
    private static final zzbp zzb = zzbp.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzc;
    private final String zzd;
    private final zzob zze;
    private final m zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzoc(Context context, m mVar, zzob zzob, String str) {
        int i10;
        this.zzc = context.getPackageName();
        this.zzd = c.a(context);
        this.zzf = mVar;
        this.zze = zzob;
        zzoo.zza();
        this.zzi = str;
        this.zzg = g.a().b(new zznv(this));
        g a10 = g.a();
        mVar.getClass();
        this.zzh = a10.b(new zznw(mVar));
        zzbp zzbp = zzb;
        if (zzbp.containsKey(str)) {
            i10 = DynamiteModule.b(context, (String) zzbp.get(str));
        } else {
            i10 = -1;
        }
        this.zzj = i10;
    }

    static long zza(List list, double d10) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d10 / 100.0d) * ((double) list.size()))) - 1, 0))).longValue();
    }

    @NonNull
    private static synchronized zzbn zzi() {
        synchronized (zzoc.class) {
            zzbn zzbn = zza;
            if (zzbn != null) {
                return zzbn;
            }
            j a10 = f.a(Resources.getSystem().getConfiguration());
            zzbk zzbk = new zzbk();
            for (int i10 = 0; i10 < a10.f(); i10++) {
                zzbk.zzb(c.b(a10.c(i10)));
            }
            zzbn zzc2 = zzbk.zzc();
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
    public final /* synthetic */ void zzc(zznr zznr, zzkt zzkt, String str) {
        String str2;
        zznr.zzb(zzkt);
        String zzd2 = zznr.zzd();
        zzmt zzmt = new zzmt();
        zzmt.zzb(this.zzc);
        zzmt.zzc(this.zzd);
        zzmt.zzh(zzi());
        zzmt.zzg(Boolean.TRUE);
        zzmt.zzl(zzd2);
        zzmt.zzj(str);
        if (this.zzh.isSuccessful()) {
            str2 = (String) this.zzh.getResult();
        } else {
            str2 = this.zzf.a();
        }
        zzmt.zzi(str2);
        zzmt.zzd(10);
        zzmt.zzk(Integer.valueOf(this.zzj));
        zznr.zzc(zzmt);
        this.zze.zza(zznr);
    }

    public final void zzd(zznr zznr, zzkt zzkt) {
        zze(zznr, zzkt, zzj());
    }

    public final void zze(zznr zznr, zzkt zzkt, String str) {
        g.d().execute(new zznx(this, zznr, zzkt, str));
    }

    public final void zzf(zzoa zzoa, zzkt zzkt) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzkt, elapsedRealtime, 30)) {
            this.zzk.put(zzkt, Long.valueOf(elapsedRealtime));
            zze(zzoa.zza(), zzkt, zzj());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzkt zzkt, com.google.mlkit.vision.face.internal.f fVar) {
        zzbs zzbs = (zzbs) this.zzl.get(zzkt);
        if (zzbs != null) {
            for (Object next : zzbs.zzq()) {
                ArrayList<Long> arrayList = new ArrayList<>(zzbs.zzc(next));
                Collections.sort(arrayList);
                zzjt zzjt = new zzjt();
                long j10 = 0;
                for (Long longValue : arrayList) {
                    j10 += longValue.longValue();
                }
                zzjt.zza(Long.valueOf(j10 / ((long) arrayList.size())));
                zzjt.zzc(Long.valueOf(zza(arrayList, 100.0d)));
                zzjt.zzf(Long.valueOf(zza(arrayList, 75.0d)));
                zzjt.zzd(Long.valueOf(zza(arrayList, 50.0d)));
                zzjt.zzb(Long.valueOf(zza(arrayList, 25.0d)));
                zzjt.zze(Long.valueOf(zza(arrayList, 0.0d)));
                zze(fVar.a(next, arrayList.size(), zzjt.zzg()), zzkt, zzj());
            }
            this.zzl.remove(zzkt);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(zzkt zzkt, Object obj, long j10, com.google.mlkit.vision.face.internal.f fVar) {
        if (!this.zzl.containsKey(zzkt)) {
            this.zzl.put(zzkt, zzas.zzr());
        }
        ((zzbs) this.zzl.get(zzkt)).zzo(obj, Long.valueOf(j10));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzkt, elapsedRealtime, 30)) {
            this.zzk.put(zzkt, Long.valueOf(elapsedRealtime));
            g.d().execute(new zznz(this, zzkt, fVar, (byte[]) null));
        }
    }
}
