package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajs  reason: invalid package */
public abstract class zzajs extends zzaiv {
    private static final Logger zza = Logger.getLogger(zzajs.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzb = zzanf.zzx();
    public static final /* synthetic */ int zzf = 0;
    zzajt zze;

    private zzajs() {
    }

    /* synthetic */ zzajs(zzajr zzajr) {
    }

    public static int zzA(int i10) {
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

    public static int zzB(long j10) {
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

    public static zzajs zzC(byte[] bArr, int i10, int i11) {
        return new zzajo(bArr, 0, i11);
    }

    @Deprecated
    static int zzw(int i10, zzalp zzalp, zzamb zzamb) {
        int zzn = ((zzaip) zzalp).zzn(zzamb);
        int zzA = zzA(i10 << 3);
        return zzA + zzA + zzn;
    }

    public static int zzx(int i10) {
        if (i10 >= 0) {
            return zzA(i10);
        }
        return 10;
    }

    static int zzy(zzalp zzalp, zzamb zzamb) {
        int zzn = ((zzaip) zzalp).zzn(zzamb);
        return zzA(zzn) + zzn;
    }

    public static int zzz(String str) {
        int i10;
        try {
            i10 = zzank.zzc(str);
        } catch (zzanj unused) {
            i10 = str.getBytes(zzakq.zzb).length;
        }
        return zzA(i10) + i10;
    }

    public final void zzD() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(String str, zzanj zzanj) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzanj);
        byte[] bytes = str.getBytes(zzakq.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzajp(e10);
        }
    }

    public abstract void zzI() throws IOException;

    public abstract void zzJ(byte b10) throws IOException;

    public abstract void zzK(int i10, boolean z10) throws IOException;

    public abstract void zzL(int i10, zzajf zzajf) throws IOException;

    public abstract void zza(byte[] bArr, int i10, int i11) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i10, int i11) throws IOException;

    public abstract void zzi(int i10) throws IOException;

    public abstract void zzj(int i10, long j10) throws IOException;

    public abstract void zzk(long j10) throws IOException;

    public abstract void zzl(int i10, int i11) throws IOException;

    public abstract void zzm(int i10) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzn(int i10, zzalp zzalp, zzamb zzamb) throws IOException;

    public abstract void zzo(int i10, String str) throws IOException;

    public abstract void zzq(int i10, int i11) throws IOException;

    public abstract void zzr(int i10, int i11) throws IOException;

    public abstract void zzs(int i10) throws IOException;

    public abstract void zzt(int i10, long j10) throws IOException;

    public abstract void zzu(long j10) throws IOException;
}
