package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajc  reason: invalid package */
class zzajc extends zzajb {
    protected final byte[] zza;

    zzajc(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzajf) || zzd() != ((zzajf) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzajc)) {
            return obj.equals(this);
        }
        zzajc zzajc = (zzajc) obj;
        int zzm = zzm();
        int zzm2 = zzajc.zzm();
        if (zzm != 0 && zzm2 != 0 && zzm != zzm2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzajc.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd <= zzajc.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzajc.zza;
            zzajc.zzc();
            int i10 = 0;
            int i11 = 0;
            while (i10 < zzd) {
                if (bArr[i10] != bArr2[i11]) {
                    return false;
                }
                i10++;
                i11++;
            }
            return true;
        } else {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzajc.zzd());
        }
    }

    public byte zza(int i10) {
        return this.zza[i10];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i10) {
        return this.zza[i10];
    }

    /* access modifiers changed from: protected */
    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public void zze(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.zza, 0, bArr, 0, i12);
    }

    /* access modifiers changed from: protected */
    public final int zzf(int i10, int i11, int i12) {
        return zzakq.zzb(i10, this.zza, 0, i12);
    }

    public final zzajf zzg(int i10, int i11) {
        int zzl = zzajf.zzl(0, i11, zzd());
        if (zzl == 0) {
            return zzajf.zzb;
        }
        return new zzaiz(this.zza, 0, zzl);
    }

    public final zzajl zzh() {
        return zzajl.zzH(this.zza, 0, zzd(), true);
    }

    /* access modifiers changed from: protected */
    public final String zzi(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzj(zzaiv zzaiv) throws IOException {
        zzaiv.zza(this.zza, 0, zzd());
    }

    public final boolean zzk() {
        return zzank.zzf(this.zza, 0, zzd());
    }
}
