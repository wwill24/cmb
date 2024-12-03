package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.charset.Charset;

class zzta extends zzsz {
    protected final byte[] zza;

    zzta(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zztd) || zzd() != ((zztd) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzta)) {
            return obj.equals(this);
        }
        zzta zzta = (zzta) obj;
        int zzl = zzl();
        int zzl2 = zzta.zzl();
        if (zzl != 0 && zzl2 != 0 && zzl != zzl2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzta.zzd()) {
            int zzd2 = zzd();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(zzd);
            sb2.append(zzd2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (zzd <= zzta.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzta.zza;
            int zzc = zzc() + zzd;
            int zzc2 = zzc();
            int zzc3 = zzta.zzc();
            while (zzc2 < zzc) {
                if (bArr[zzc2] != bArr2[zzc3]) {
                    return false;
                }
                zzc2++;
                zzc3++;
            }
            return true;
        } else {
            int zzd3 = zzta.zzd();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(zzd);
            sb3.append(", ");
            sb3.append(zzd3);
            throw new IllegalArgumentException(sb3.toString());
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
        return zzvi.zzd(i10, this.zza, zzc(), i12);
    }

    public final zztd zzg(int i10, int i11) {
        int zzk = zztd.zzk(0, i11, zzd());
        if (zzk == 0) {
            return zztd.zzb;
        }
        return new zzsx(this.zza, zzc(), zzk);
    }

    /* access modifiers changed from: protected */
    public final String zzh(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzi(zzss zzss) throws IOException {
        ((zztl) zzss).zzc(this.zza, zzc(), zzd());
    }

    public final boolean zzj() {
        int zzc = zzc();
        return zzyd.zzf(this.zza, zzc, zzd() + zzc);
    }
}
