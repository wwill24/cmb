package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

class zzjx extends zzjw {
    protected final byte[] zza;

    zzjx(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzka) || zzd() != ((zzka) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzjx)) {
            return obj.equals(this);
        }
        zzjx zzjx = (zzjx) obj;
        int zzk = zzk();
        int zzk2 = zzjx.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzjx.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd <= zzjx.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzjx.zza;
            zzjx.zzc();
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
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzjx.zzd());
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
    public final int zze(int i10, int i11, int i12) {
        return zzlj.zzb(i10, this.zza, 0, i12);
    }

    public final zzka zzf(int i10, int i11) {
        int zzj = zzka.zzj(0, i11, zzd());
        if (zzj == 0) {
            return zzka.zzb;
        }
        return new zzju(this.zza, 0, zzj);
    }

    /* access modifiers changed from: protected */
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzjq zzjq) throws IOException {
        ((zzkf) zzjq).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zznz.zze(this.zza, 0, zzd());
    }
}
