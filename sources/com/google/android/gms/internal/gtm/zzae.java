package com.google.android.gms.internal.gtm;

import java.util.List;

public final class zzae extends zzuz<zzae, zzad> implements zzwl {
    public static final zzux<zzak, zzae> zza;
    /* access modifiers changed from: private */
    public static final zzae zze;
    private int zzf;
    private zzve zzg = zzuz.zzaf();
    private zzve zzh = zzuz.zzaf();
    private zzve zzi = zzuz.zzaf();
    private int zzj;
    private zzve zzk = zzuz.zzaf();
    private int zzl;
    private int zzm;

    static {
        zzae zzae = new zzae();
        zze = zzae;
        zzuz.zzak(zzae.class, zzae);
        zza = zzuz.zzaa(zzak.zzi(), zzae, zzae, (zzvc) null, 101, zzye.MESSAGE, zzae.class);
    }

    private zzae() {
    }

    public final int zza() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzuz.zzaj(zze, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004င\u0000\u0005\u0016\u0006င\u0001\u0007င\u0002", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        } else if (i11 == 3) {
            return new zzae();
        } else {
            if (i11 == 4) {
                return new zzad((zzn) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zze;
        }
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zzi.size();
    }

    public final List<Integer> zzf() {
        return this.zzg;
    }

    public final List<Integer> zzg() {
        return this.zzh;
    }

    public final List<Integer> zzh() {
        return this.zzi;
    }

    public final List<Integer> zzi() {
        return this.zzk;
    }
}
