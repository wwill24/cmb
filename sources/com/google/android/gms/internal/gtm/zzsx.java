package com.google.android.gms.internal.gtm;

final class zzsx extends zzta {
    private final int zzc;
    private final int zzd;

    zzsx(byte[] bArr, int i10, int i11) {
        super(bArr);
        zztd.zzk(i10, i10 + i11, bArr.length);
        this.zzc = i10;
        this.zzd = i11;
    }

    public final byte zza(int i10) {
        int i11 = this.zzd;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.zza[this.zzc + i10];
        }
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append("Index < 0: ");
            sb2.append(i10);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(40);
        sb3.append("Index > length: ");
        sb3.append(i10);
        sb3.append(", ");
        sb3.append(i11);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i10) {
        return this.zza[this.zzc + i10];
    }

    /* access modifiers changed from: protected */
    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final void zze(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.zza, this.zzc, bArr, 0, i12);
    }
}
