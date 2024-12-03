package com.google.android.gms.internal.gtm;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.mparticle.kits.AppsFlyerKit;
import java.util.HashSet;
import java.util.Set;
import me.q;

public final class zzct {
    private final zzbv zza;
    private volatile Boolean zzb;
    private String zzc;
    private Set<Integer> zzd;

    protected zzct(zzbv zzbv) {
        p.k(zzbv);
        this.zza = zzbv;
    }

    public static final long zzc() {
        return zzeu.zzG.zzb().longValue();
    }

    public static final long zzd() {
        return zzeu.zzm.zzb().longValue();
    }

    public static final long zze() {
        return zzeu.zzj.zzb().longValue();
    }

    public static final int zzf() {
        return zzeu.zzy.zzb().intValue();
    }

    public static final int zzg() {
        return zzeu.zzp.zzb().intValue();
    }

    public static final int zzh() {
        return zzeu.zzo.zzb().intValue();
    }

    public static final String zzi() {
        return zzeu.zzr.zzb();
    }

    public static final String zzj() {
        return zzeu.zzs.zzb();
    }

    public static final String zzk() {
        return zzeu.zzq.zzb();
    }

    public static final boolean zzl() {
        return zzeu.zzb.zzb().booleanValue();
    }

    public final Set<Integer> zza() {
        String str;
        String zzb2 = zzeu.zzB.zzb();
        if (this.zzd == null || (str = this.zzc) == null || !str.equals(zzb2)) {
            String[] split = TextUtils.split(zzb2, AppsFlyerKit.COMMA);
            HashSet hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException unused) {
                }
            }
            this.zzc = zzb2;
            this.zzd = hashSet;
        }
        return this.zzd;
    }

    public final boolean zzb() {
        if (this.zzb == null) {
            synchronized (this) {
                if (this.zzb == null) {
                    ApplicationInfo applicationInfo = this.zza.zza().getApplicationInfo();
                    String a10 = q.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z10 = false;
                        if (str != null && str.equals(a10)) {
                            z10 = true;
                        }
                        this.zzb = Boolean.valueOf(z10);
                    }
                    if ((this.zzb == null || !this.zzb.booleanValue()) && "com.google.android.gms.analytics".equals(a10)) {
                        this.zzb = Boolean.TRUE;
                    }
                    if (this.zzb == null) {
                        this.zzb = Boolean.TRUE;
                        this.zza.zzm().zzJ("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzb.booleanValue();
    }
}
