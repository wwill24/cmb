package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiz  reason: invalid package */
final class zzaiz extends zzajc {
    private final int zzc;

    zzaiz(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzajf.zzl(0, i11, bArr.length);
        this.zzc = i11;
    }

    public final byte zza(int i10) {
        int i11 = this.zzc;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.zza[i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i10) {
        return this.zza[i10];
    }

    /* access modifiers changed from: protected */
    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final void zze(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.zza, 0, bArr, 0, i12);
    }
}
