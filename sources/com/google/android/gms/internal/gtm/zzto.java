package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzto extends zzss {
    private static final Logger zzb = Logger.getLogger(zzto.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzxy.zzx();
    zztp zza;

    private zzto() {
    }

    /* synthetic */ zzto(zztn zztn) {
    }

    static int zzA(zzwk zzwk, zzwx zzwx) {
        zzsh zzsh = (zzsh) zzwk;
        int zzQ = zzsh.zzQ();
        if (zzQ == -1) {
            zzQ = zzwx.zza(zzsh);
            zzsh.zzT(zzQ);
        }
        return zzD(zzQ) + zzQ;
    }

    public static int zzB(String str) {
        int i10;
        try {
            i10 = zzyd.zzc(str);
        } catch (zzyc unused) {
            i10 = str.getBytes(zzvi.zza).length;
        }
        return zzD(i10) + i10;
    }

    public static int zzC(int i10) {
        return zzD(i10 << 3);
    }

    public static int zzD(int i10) {
        if ((i10 & -128) == 0) {
            return 1;
        }
        if ((i10 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i10) == 0) {
            return 3;
        }
        return (i10 & -268435456) == 0 ? 4 : 5;
    }

    public static int zzE(long j10) {
        int i10;
        if ((-128 & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if ((-34359738368L & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if ((-2097152 & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & -16384) != 0 ? i10 + 1 : i10;
    }

    public static zzto zzF(byte[] bArr) {
        return new zztl(bArr, 0, bArr.length);
    }

    public static int zzt(byte[] bArr) {
        int length = bArr.length;
        return zzD(length) + length;
    }

    public static int zzu(zztd zztd) {
        int zzd = zztd.zzd();
        return zzD(zzd) + zzd;
    }

    @Deprecated
    static int zzv(int i10, zzwk zzwk, zzwx zzwx) {
        int zzD = zzD(i10 << 3);
        int i11 = zzD + zzD;
        zzsh zzsh = (zzsh) zzwk;
        int zzQ = zzsh.zzQ();
        if (zzQ == -1) {
            zzQ = zzwx.zza(zzsh);
            zzsh.zzT(zzQ);
        }
        return i11 + zzQ;
    }

    @Deprecated
    public static int zzw(zzwk zzwk) {
        return zzwk.zzX();
    }

    public static int zzx(int i10) {
        if (i10 >= 0) {
            return zzD(i10);
        }
        return 10;
    }

    public static int zzy(zzvq zzvq) {
        int zza2 = zzvq.zza();
        return zzD(zza2) + zza2;
    }

    public static int zzz(zzwk zzwk) {
        int zzX = zzwk.zzX();
        return zzD(zzX) + zzX;
    }

    public final void zzG() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzH(String str, zzyc zzyc) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzyc);
        byte[] bytes = str.getBytes(zzvi.zza);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zztm(e10);
        } catch (zztm e11) {
            throw e11;
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b10) throws IOException;

    public abstract void zzd(int i10, boolean z10) throws IOException;

    public abstract void zze(int i10, zztd zztd) throws IOException;

    public abstract void zzf(int i10, int i11) throws IOException;

    public abstract void zzg(int i10) throws IOException;

    public abstract void zzh(int i10, long j10) throws IOException;

    public abstract void zzi(long j10) throws IOException;

    public abstract void zzj(int i10, int i11) throws IOException;

    public abstract void zzk(int i10) throws IOException;

    public abstract void zzl(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void zzm(int i10, String str) throws IOException;

    public abstract void zzo(int i10, int i11) throws IOException;

    public abstract void zzp(int i10, int i11) throws IOException;

    public abstract void zzq(int i10) throws IOException;

    public abstract void zzr(int i10, long j10) throws IOException;

    public abstract void zzs(long j10) throws IOException;
}
