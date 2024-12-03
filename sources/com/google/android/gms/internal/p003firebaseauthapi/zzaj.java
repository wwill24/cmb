package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaj  reason: invalid package */
public final class zzaj extends zzag {
    public zzaj() {
        super(4);
    }

    public final zzaj zzb(Object obj) {
        int i10 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i10) {
            this.zza = Arrays.copyOf(objArr, zzah.zza(length, i10));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i11 = this.zzb;
        this.zzb = i11 + 1;
        objArr2[i11] = obj;
        return this;
    }

    public final zzam zzc() {
        this.zzc = true;
        return zzam.zzg(this.zza, this.zzb);
    }
}
