package com.google.android.gms.internal.gtm;

import java.util.List;

public final class zzaa extends zzuz<zzaa, zzz> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzaa zza;
    private int zze;
    private zzvh<String> zzf = zzuz.zzag();
    private zzvh<String> zzg = zzuz.zzag();
    private zzvh<zzak> zzh = zzuz.zzag();
    private zzvh<zzy> zzi = zzuz.zzag();
    private zzvh<zzs> zzj = zzuz.zzag();
    private zzvh<zzs> zzk = zzuz.zzag();
    private zzvh<zzs> zzl = zzuz.zzag();
    private zzvh<zzac> zzm = zzuz.zzag();
    private String zzn = "";
    private String zzo = "";
    private String zzp = "0";
    private String zzq = "";
    private zzq zzr;
    private float zzs;
    private boolean zzt;
    private zzvh<String> zzu = zzuz.zzag();
    private int zzv;
    private byte zzw = 2;

    static {
        zzaa zzaa = new zzaa();
        zza = zzaa;
        zzuz.zzak(zzaa.class, zzaa);
    }

    private zzaa() {
    }

    public static zzz zzj() {
        return (zzz) zza.zzY();
    }

    public static zzaa zzl() {
        return zza;
    }

    public static zzaa zzm(byte[] bArr, zzuj zzuj) throws zzvk {
        return (zzaa) zzuz.zzad(zza, bArr, zzuj);
    }

    public final int zza() {
        return this.zzj.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        Class<zzs> cls = zzs.class;
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzw);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return zzuz.zzaj(zza, "\u0001\u0011\u0000\u0001\u0001\u0013\u0011\u0000\t\u0005\u0001\u001a\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007\u001b\tဈ\u0000\nဈ\u0001\fဈ\u0002\rဈ\u0003\u000eဉ\u0004\u000fခ\u0005\u0010\u001a\u0011င\u0007\u0012ဇ\u0006\u0013\u001a", new Object[]{"zze", "zzg", "zzh", zzak.class, "zzi", zzy.class, "zzj", cls, "zzk", cls, "zzl", cls, "zzm", zzac.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzu", "zzv", "zzt", "zzf"});
        } else if (i11 == 3) {
            return new zzaa();
        } else {
            if (i11 == 4) {
                return new zzz((zzn) null);
            }
            if (i11 == 5) {
                return zza;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzw = b10;
            return null;
        }
    }

    public final int zzc() {
        return this.zzl.size();
    }

    public final int zzd() {
        return this.zzv;
    }

    public final int zze() {
        return this.zzk.size();
    }

    public final int zzf() {
        return this.zzh.size();
    }

    public final zzs zzg(int i10) {
        return this.zzj.get(i10);
    }

    public final zzs zzh(int i10) {
        return this.zzl.get(i10);
    }

    public final zzs zzi(int i10) {
        return this.zzk.get(i10);
    }

    public final zzak zzn(int i10) {
        return this.zzh.get(i10);
    }

    public final String zzo() {
        return this.zzq;
    }

    public final List<String> zzp() {
        return this.zzg;
    }

    public final List<zzy> zzq() {
        return this.zzi;
    }

    public final List<zzac> zzr() {
        return this.zzm;
    }

    public final List<zzak> zzs() {
        return this.zzh;
    }
}
