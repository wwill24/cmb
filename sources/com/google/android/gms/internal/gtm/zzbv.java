package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.android.gms.common.internal.p;
import me.f;
import me.i;
import rd.b;
import rd.u;

@SuppressLint({"StaticFieldLeak"})
public final class zzbv {
    private static volatile zzbv zza;
    private final Context zzb;
    private final Context zzc;
    private final f zzd = i.c();
    private final zzct zze = new zzct(this);
    private final zzfb zzf;
    private final u zzg;
    private final zzbq zzh;
    private final zzcy zzi;
    private final zzft zzj;
    private final zzfh zzk;
    private final b zzl;
    private final zzcn zzm;
    private final zzbi zzn;
    private final zzcf zzo;
    private final zzcx zzp;

    protected zzbv(zzbw zzbw) {
        Context zza2 = zzbw.zza();
        p.l(zza2, "Application context can't be null");
        Context zzb2 = zzbw.zzb();
        p.k(zzb2);
        this.zzb = zza2;
        this.zzc = zzb2;
        zzfb zzfb = new zzfb(this);
        zzfb.zzX();
        this.zzf = zzfb;
        zzfb zzm2 = zzm();
        String str = zzbt.zza;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 134);
        sb2.append("Google Analytics ");
        sb2.append(str);
        sb2.append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        zzm2.zzM(sb2.toString());
        zzfh zzfh = new zzfh(this);
        zzfh.zzX();
        this.zzk = zzfh;
        zzft zzft = new zzft(this);
        zzft.zzX();
        this.zzj = zzft;
        zzbq zzbq = new zzbq(this, zzbw);
        zzcn zzcn = new zzcn(this);
        zzbi zzbi = new zzbi(this);
        zzcf zzcf = new zzcf(this);
        zzcx zzcx = new zzcx(this);
        u b10 = u.b(zza2);
        b10.j(new zzbu(this));
        this.zzg = b10;
        b bVar = new b(this);
        zzcn.zzX();
        this.zzm = zzcn;
        zzbi.zzX();
        this.zzn = zzbi;
        zzcf.zzX();
        this.zzo = zzcf;
        zzcx.zzX();
        this.zzp = zzcx;
        zzcy zzcy = new zzcy(this);
        zzcy.zzX();
        this.zzi = zzcy;
        zzbq.zzX();
        this.zzh = zzbq;
        bVar.o();
        this.zzl = bVar;
        zzbq.zzm();
    }

    public static zzbv zzg(Context context) {
        p.k(context);
        if (zza == null) {
            synchronized (zzbv.class) {
                if (zza == null) {
                    f c10 = i.c();
                    long b10 = c10.b();
                    zzbv zzbv = new zzbv(new zzbw(context));
                    zza = zzbv;
                    b.n();
                    long b11 = c10.b() - b10;
                    long longValue = zzeu.zzQ.zzb().longValue();
                    if (b11 > longValue) {
                        zzbv.zzm().zzT("Slow initialization (ms)", Long.valueOf(b11), Long.valueOf(longValue));
                    }
                }
            }
        }
        return zza;
    }

    private static final void zzs(zzbs zzbs) {
        p.l(zzbs, "Analytics service not created/initialized");
        p.b(zzbs.zzY(), "Analytics service not initialized");
    }

    public final Context zza() {
        return this.zzb;
    }

    public final Context zzb() {
        return this.zzc;
    }

    public final b zzc() {
        p.k(this.zzl);
        p.b(this.zzl.r(), "Analytics instance not initialized");
        return this.zzl;
    }

    public final u zzd() {
        p.k(this.zzg);
        return this.zzg;
    }

    public final zzbi zze() {
        zzs(this.zzn);
        return this.zzn;
    }

    public final zzbq zzf() {
        zzs(this.zzh);
        return this.zzh;
    }

    public final zzcf zzh() {
        zzs(this.zzo);
        return this.zzo;
    }

    public final zzcn zzi() {
        zzs(this.zzm);
        return this.zzm;
    }

    public final zzct zzj() {
        return this.zze;
    }

    public final zzcx zzk() {
        return this.zzp;
    }

    public final zzcy zzl() {
        zzs(this.zzi);
        return this.zzi;
    }

    public final zzfb zzm() {
        zzs(this.zzf);
        return this.zzf;
    }

    public final zzfb zzn() {
        return this.zzf;
    }

    public final zzfh zzo() {
        zzs(this.zzk);
        return this.zzk;
    }

    public final zzfh zzp() {
        zzfh zzfh = this.zzk;
        if (zzfh == null || !zzfh.zzY()) {
            return null;
        }
        return this.zzk;
    }

    public final zzft zzq() {
        zzs(this.zzj);
        return this.zzj;
    }

    public final f zzr() {
        return this.zzd;
    }
}
