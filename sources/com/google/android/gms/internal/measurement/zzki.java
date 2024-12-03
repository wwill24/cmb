package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzki extends zzjq {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzki.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzd = zznu.zzx();
    zzkj zza;

    private zzki() {
    }

    /* synthetic */ zzki(zzkh zzkh) {
    }

    @Deprecated
    static int zzt(int i10, zzmi zzmi, zzmt zzmt) {
        int zzbu = ((zzjk) zzmi).zzbu(zzmt);
        int zzx = zzx(i10 << 3);
        return zzx + zzx + zzbu;
    }

    public static int zzu(int i10) {
        if (i10 >= 0) {
            return zzx(i10);
        }
        return 10;
    }

    static int zzv(zzmi zzmi, zzmt zzmt) {
        int zzbu = ((zzjk) zzmi).zzbu(zzmt);
        return zzx(zzbu) + zzbu;
    }

    public static int zzw(String str) {
        int i10;
        try {
            i10 = zznz.zzc(str);
        } catch (zzny unused) {
            i10 = str.getBytes(zzlj.zzb).length;
        }
        return zzx(i10) + i10;
    }

    public static int zzx(int i10) {
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

    public static int zzy(long j10) {
        int i10;
        if ((-128 & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if ((-34359738368L & j10) != 0) {
            i10 = 6;
            j10 >>>= 28;
        } else {
            i10 = 2;
        }
        if ((-2097152 & j10) != 0) {
            j10 >>>= 14;
            i10 += 2;
        }
        return (j10 & -16384) != 0 ? i10 + 1 : i10;
    }

    public static zzki zzz(byte[] bArr, int i10, int i11) {
        return new zzkf(bArr, 0, i11);
    }

    public final void zzA() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB(String str, zzny zzny) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzny);
        byte[] bytes = str.getBytes(zzlj.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzkg(e10);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b10) throws IOException;

    public abstract void zzd(int i10, boolean z10) throws IOException;

    public abstract void zze(int i10, zzka zzka) throws IOException;

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
