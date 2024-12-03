package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.math.RoundingMode;

class zzbk extends zzbl {
    final zzbh zzb;
    final Character zzc;

    zzbk(zzbh zzbh, Character ch2) {
        this.zzb = zzbh;
        if (ch2 == null || !zzbh.zzb(ch2.charValue())) {
            this.zzc = ch2;
            return;
        }
        throw new IllegalArgumentException(zzat.zza("Padding character %s was already in alphabet", ch2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbk) {
            zzbk zzbk = (zzbk) obj;
            if (this.zzb.equals(zzbk.zzb)) {
                Character ch2 = this.zzc;
                Character ch3 = zzbk.zzc;
                if (ch2 == ch3) {
                    return true;
                }
                if (ch2 == null || !ch2.equals(ch3)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int hashCode = this.zzb.hashCode();
        Character ch2 = this.zzc;
        if (ch2 == null) {
            i10 = 0;
        } else {
            i10 = ch2.hashCode();
        }
        return hashCode ^ i10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BaseEncoding.");
        sb2.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb2.append(".omitPadding()");
            } else {
                sb2.append(".withPadChar('");
                sb2.append(this.zzc);
                sb2.append("')");
            }
        }
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public void zza(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        zzas.zze(0, i11, bArr.length);
        while (i12 < i11) {
            zzc(appendable, bArr, i12, Math.min(this.zzb.zzd, i11 - i12));
            i12 += this.zzb.zzd;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzb(int i10) {
        zzbh zzbh = this.zzb;
        return zzbh.zzc * zzbn.zza(i10, zzbh.zzd, RoundingMode.CEILING);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
        boolean z10;
        zzas.zze(i10, i10 + i11, bArr.length);
        int i12 = 0;
        if (i11 <= this.zzb.zzd) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzas.zzc(z10);
        long j10 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            j10 = (j10 | ((long) (bArr[i10 + i13] & 255))) << 8;
        }
        int i14 = ((i11 + 1) * 8) - this.zzb.zzb;
        while (i12 < i11 * 8) {
            zzbh zzbh = this.zzb;
            appendable.append(zzbh.zza(zzbh.zza & ((int) (j10 >>> (i14 - i12)))));
            i12 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i12 < this.zzb.zzd * 8) {
                appendable.append(this.zzc.charValue());
                i12 += this.zzb.zzb;
            }
        }
    }

    zzbk(String str, String str2, Character ch2) {
        this(new zzbh(str, str2.toCharArray()), ch2);
    }
}
