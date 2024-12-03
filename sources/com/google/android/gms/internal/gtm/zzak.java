package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;

public final class zzak extends zzuv<zzak, zzal> {
    private static final zzvf<Integer, zzao> zze = new zzvf<Integer, zzao>() {
        /* renamed from: zza */
        public zzao zzb(Integer num) {
            zzao zzb = zzao.zzb(num.intValue());
            return zzb == null ? zzao.ESCAPE_HTML : zzb;
        }
    };
    /* access modifiers changed from: private */
    public static final zzak zzf;
    private int zzg;
    private int zzh = 1;
    private String zzi = "";
    /* access modifiers changed from: private */
    public zzvh<zzak> zzj = zzuz.zzag();
    /* access modifiers changed from: private */
    public zzvh<zzak> zzk = zzuz.zzag();
    /* access modifiers changed from: private */
    public zzvh<zzak> zzl = zzuz.zzag();
    private String zzm = "";
    private String zzn = "";
    private long zzo;
    private boolean zzp;
    /* access modifiers changed from: private */
    public zzvh<zzak> zzq = zzuz.zzag();
    /* access modifiers changed from: private */
    public zzve zzr = zzuz.zzaf();
    private boolean zzs;
    private byte zzt = 2;

    static {
        zzak zzak = new zzak();
        zzf = zzak;
        zzuz.zzak(zzak.class, zzak);
    }

    private zzak() {
    }

    static /* synthetic */ void zzA(zzak zzak, String str) {
        str.getClass();
        zzak.zzg |= 4;
        zzak.zzm = str;
    }

    static /* synthetic */ void zzB(zzak zzak, String str) {
        str.getClass();
        zzak.zzg |= 8;
        zzak.zzn = str;
    }

    static /* synthetic */ void zzC(zzak zzak, String str) {
        str.getClass();
        zzak.zzg |= 2;
        zzak.zzi = str;
    }

    static /* synthetic */ void zzD(zzak zzak, long j10) {
        zzak.zzg |= 16;
        zzak.zzo = j10;
    }

    static /* synthetic */ void zzE(zzak zzak, boolean z10) {
        zzak.zzg |= 32;
        zzak.zzp = z10;
    }

    static /* synthetic */ void zzF(zzak zzak, zzak zzak2) {
        zzak2.getClass();
        zzvh<zzak> zzvh = zzak.zzq;
        if (!zzvh.zzc()) {
            zzak.zzq = zzuz.zzah(zzvh);
        }
        zzak.zzq.add(zzak2);
    }

    static /* synthetic */ void zzH(zzak zzak, Iterable iterable) {
        int i10;
        zzve zzve = zzak.zzr;
        if (!zzve.zzc()) {
            int size = zzve.size();
            if (size == 0) {
                i10 = 10;
            } else {
                i10 = size + size;
            }
            zzak.zzr = zzve.zzg(i10);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzak.zzr.zzh(((zzao) it.next()).zza());
        }
    }

    static /* synthetic */ void zzJ(zzak zzak, boolean z10) {
        zzak.zzg |= 64;
        zzak.zzs = z10;
    }

    static /* synthetic */ void zzK(zzak zzak, zzak zzak2) {
        zzak2.getClass();
        zzak.zzal();
        zzak.zzj.add(zzak2);
    }

    static /* synthetic */ void zzL(zzak zzak, Iterable iterable) {
        zzak.zzal();
        zzsh.zzS(iterable, zzak.zzj);
    }

    static /* synthetic */ void zzP(zzak zzak, int i10) {
        zzak.zzh = i10;
        zzak.zzg |= 1;
    }

    private final void zzal() {
        zzvh<zzak> zzvh = this.zzj;
        if (!zzvh.zzc()) {
            this.zzj = zzuz.zzah(zzvh);
        }
    }

    private final void zzam() {
        zzvh<zzak> zzvh = this.zzk;
        if (!zzvh.zzc()) {
            this.zzk = zzuz.zzah(zzvh);
        }
    }

    private final void zzan() {
        zzvh<zzak> zzvh = this.zzl;
        if (!zzvh.zzc()) {
            this.zzl = zzuz.zzah(zzvh);
        }
    }

    public static zzal zzg() {
        return (zzal) zzf.zzY();
    }

    public static zzak zzi() {
        return zzf;
    }

    static /* synthetic */ void zzu(zzak zzak, zzak zzak2) {
        zzak2.getClass();
        zzak.zzam();
        zzak.zzk.add(zzak2);
    }

    static /* synthetic */ void zzv(zzak zzak, Iterable iterable) {
        zzak.zzam();
        zzsh.zzS(iterable, zzak.zzk);
    }

    static /* synthetic */ void zzx(zzak zzak, zzak zzak2) {
        zzak2.getClass();
        zzak.zzan();
        zzak.zzl.add(zzak2);
    }

    static /* synthetic */ void zzy(zzak zzak, Iterable iterable) {
        zzak.zzan();
        zzsh.zzS(iterable, zzak.zzl);
    }

    public final boolean zzM() {
        return this.zzp;
    }

    public final boolean zzN() {
        return this.zzs;
    }

    public final int zzO() {
        int zza = zzar.zza(this.zzh);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zza() {
        return this.zzj.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        Class<zzak> cls = zzak.class;
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzt);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return zzuz.zzaj(zzf, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0005\u0005\u0001ᔌ\u0000\u0002ဈ\u0001\u0003Л\u0004Л\u0005Л\u0006ဈ\u0002\u0007ဈ\u0003\bဂ\u0004\tဇ\u0006\n\u001e\u000bЛ\fဇ\u0005", new Object[]{"zzg", "zzh", zzaq.zza, "zzi", "zzj", cls, "zzk", cls, "zzl", cls, "zzm", "zzn", "zzo", "zzs", "zzr", zzao.zzc(), "zzq", cls, "zzp"});
        } else if (i11 == 3) {
            return new zzak();
        } else {
            if (i11 == 4) {
                return new zzal((zzaj) null);
            }
            if (i11 == 5) {
                return zzf;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzt = b10;
            return null;
        }
    }

    public final int zzc() {
        return this.zzk.size();
    }

    public final int zzd() {
        return this.zzl.size();
    }

    public final int zze() {
        return this.zzq.size();
    }

    public final long zzf() {
        return this.zzo;
    }

    public final zzak zzj(int i10) {
        return this.zzj.get(i10);
    }

    public final zzak zzk(int i10) {
        return this.zzk.get(i10);
    }

    public final zzak zzl(int i10) {
        return this.zzl.get(i10);
    }

    public final zzak zzm(int i10) {
        return this.zzq.get(i10);
    }

    public final String zzn() {
        return this.zzn;
    }

    public final String zzo() {
        return this.zzm;
    }

    public final String zzp() {
        return this.zzi;
    }

    public final List<zzao> zzq() {
        return new zzvg(this.zzr, zze);
    }

    public final List<zzak> zzr() {
        return this.zzj;
    }

    public final List<zzak> zzs() {
        return this.zzq;
    }
}
